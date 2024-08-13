package com.devkit.kit.inputdevice.impl.repository

import com.devkit.kit.inputdevice.api.model.MouseButton
import com.devkit.kit.inputdevice.api.model.MouseEvent
import com.devkit.kit.inputdevice.api.model.MouseEventType
import com.devkit.kit.inputdevice.api.model.Position
import com.devkit.kit.inputdevice.impl.usecase.ListenHotMouseEventImpl
import com.devkit.kit.inputdevice.impl.util.GlobalScreenUtil
import com.github.kwhat.jnativehook.GlobalScreen
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener
import java.awt.MouseInfo
import java.awt.PointerInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

internal class MouseEventRepository : ListenHotMouseEventImpl.MouseEventRepository, NativeMouseInputListener {
    private val mutableStateFlow = MutableSharedFlow<MouseEvent>(extraBufferCapacity = 64)
    private var isListening: Boolean = false
    private var previousButton: MouseButton = MouseButton.None

    init {
        GlobalScope.launch(Dispatchers.IO) {
            GlobalScreenUtil.tryRegisterNativeHook()
            mutableStateFlow.subscriptionCount.collectLatest { count ->
                if (count == 0) {
                    GlobalScreen.removeNativeMouseListener(this@MouseEventRepository)
                    GlobalScreen.removeNativeMouseMotionListener(this@MouseEventRepository)
                    isListening = false
                } else if (!isListening) {
                    GlobalScreen.addNativeMouseListener(this@MouseEventRepository)
                    GlobalScreen.addNativeMouseMotionListener(this@MouseEventRepository)
                    isListening = true
                }
            }
        }
    }

    override fun listEvents(filterType: List<MouseEventType>): Flow<MouseEvent> {
        return mutableStateFlow
            .filterNotNull()
            .filter { filterType.contains(it.type) }
    }

    override fun nativeMousePressed(nativeEvent: NativeMouseEvent?) {
        val currentPointerInfo = getCurrentMouseLocation()
        if (nativeEvent != null && currentPointerInfo != null) {
            previousButton = nativeEvent.toMouseButton()
            mutableStateFlow.tryEmit(MouseEvent.Pressed(currentPointerInfo, nativeEvent.toMouseButton()))
        }
    }

    override fun nativeMouseReleased(nativeEvent: NativeMouseEvent?) {
        val currentPointerInfo = getCurrentMouseLocation()
        if (nativeEvent != null && currentPointerInfo != null) {
            mutableStateFlow.tryEmit(MouseEvent.Released(currentPointerInfo, nativeEvent.toMouseButton()))
        }
    }

    override fun nativeMouseClicked(nativeEvent: NativeMouseEvent?) {
        val currentPointerInfo = getCurrentMouseLocation()
        if (nativeEvent != null && currentPointerInfo != null) {
            mutableStateFlow.tryEmit(MouseEvent.Clicked(currentPointerInfo, nativeEvent.toMouseButton()))
        }
    }

    override fun nativeMouseMoved(nativeEvent: NativeMouseEvent?) {
        val currentPointerInfo = getCurrentMouseLocation()
        if (nativeEvent != null && currentPointerInfo != null) {
            mutableStateFlow.tryEmit(MouseEvent.Moved(currentPointerInfo))
        }
    }

    override fun nativeMouseDragged(nativeEvent: NativeMouseEvent?) {
        val currentPointerInfo = getCurrentMouseLocation()
        if (nativeEvent != null && currentPointerInfo != null) {
            mutableStateFlow.tryEmit(MouseEvent.Dragged(currentPointerInfo, previousButton))
        }
    }
}

private fun getCurrentMouseLocation(): Position? {
    val cursorInfo: PointerInfo? = MouseInfo.getPointerInfo()
    return cursorInfo?.let {
        Position(
            x = cursorInfo.location.x.toFloat(),
            y = cursorInfo.location.y.toFloat(),
        )
    }
}

private fun NativeMouseEvent.toMouseButton(): MouseButton {
    return when (button) {
        NativeMouseEvent.BUTTON1 -> MouseButton.Left
        NativeMouseEvent.BUTTON2 -> MouseButton.Middle
        NativeMouseEvent.BUTTON3 -> MouseButton.Right
        else -> MouseButton.None
    }
}
