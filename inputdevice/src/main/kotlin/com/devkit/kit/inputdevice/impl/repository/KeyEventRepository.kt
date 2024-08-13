package com.devkit.kit.inputdevice.impl.repository

import com.devkit.kit.inputdevice.api.model.HotKeyStatus
import com.devkit.kit.inputdevice.api.model.KeyEvent
import com.devkit.kit.inputdevice.api.model.KeyEventType
import com.devkit.kit.inputdevice.api.model.NativeKey
import com.devkit.kit.inputdevice.impl.usecase.ListenHotKeyEventImpl
import com.devkit.kit.inputdevice.impl.usecase.ListenHotKeyStatusImpl
import com.devkit.kit.inputdevice.impl.util.GlobalScreenUtil
import com.github.kwhat.jnativehook.GlobalScreen
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

internal class KeyEventRepository :
    ListenHotKeyEventImpl.KeyEventRepository,
    ListenHotKeyStatusImpl.KeyEventRepository {

    init {
        GlobalScreenUtil.tryRegisterNativeHook()
    }

    override fun listEvents(filterType: List<KeyEventType>): Flow<KeyEvent> = callbackFlow {

        val keyboardListener = object : NativeKeyListener {
            override fun nativeKeyPressed(nativeEvent: NativeKeyEvent?) {
                if (nativeEvent != null && filterType.contains(KeyEventType.KEY_PRESSED)) {
                    trySend(KeyEvent.Pressed(NativeKey.fromValue(nativeEvent.keyCode)))
                }
            }

            override fun nativeKeyReleased(nativeEvent: NativeKeyEvent?) {
                if (nativeEvent != null && filterType.contains(KeyEventType.KEY_RELEASED)) {
                    trySend(KeyEvent.Released(NativeKey.fromValue(nativeEvent.keyCode)))
                }
            }

            override fun nativeKeyTyped(nativeEvent: NativeKeyEvent?) {
                if (nativeEvent != null && filterType.contains(KeyEventType.KEY_TYPED)) {
                    trySend(KeyEvent.Typed(NativeKey.fromValue(nativeEvent.keyCode)))
                }
            }
        }

        GlobalScreen.addNativeKeyListener(keyboardListener)
        awaitClose {
            GlobalScreen.removeNativeKeyListener(keyboardListener)
        }
    }

    override fun listenHotKeyEventStatus(): Flow<HotKeyStatus> {
        val hotKeyStatus = HotKeyStatus()

        return listEvents(KeyEventType.All).map {
            when (it) {
                is KeyEvent.Pressed -> {
                    hotKeyStatus.onPress(it.key)
                    hotKeyStatus.copy()
                }
                is KeyEvent.Released -> {
                    hotKeyStatus.onRelease(it.key)
                    hotKeyStatus.copy()
                }
                is KeyEvent.Typed -> {
                    null
                }
            }
        }
            .filterNotNull()
            .distinctUntilChanged()
    }
}
