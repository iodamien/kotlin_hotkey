package com.tanucube.kit

import com.devkit.kit.inputdevice.api.model.NativeKey
import com.devkit.kit.inputdevice.api.usecase.ListenHotKeyEvent
import com.devkit.kit.inputdevice.api.usecase.ListenHotMouseEvent
import com.devkit.kit.inputdevice.impl.di.inputDeviceDI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.get
import kotlin.system.exitProcess

suspend fun main() {

    startKoin {
        modules(inputDeviceDI)
    }

    val listenHotKey: ListenHotKeyEvent = get(ListenHotKeyEvent::class.java)
    val listenMouseEvent: ListenHotMouseEvent = get(ListenHotMouseEvent::class.java)
    val scope = CoroutineScope(Dispatchers.Default)

    val jobKeyEvent = scope.launch {
        listenHotKey().collectLatest { keyEvent ->
            println("Key printed: $keyEvent")

            if (keyEvent.key == NativeKey.KEY_ESCAPE) {
                println("Exiting...")
                exitProcess(0)
            }
        }
    }

    val jobKeyEnter = scope.launch {
        listenHotKey()
            .filter { keyEvent -> keyEvent.key == NativeKey.KEY_ENTER }
            .filter { keyEvent -> keyEvent.isReleased }
            .collectLatest {
                println("**** Enter isReleased ****")
            }
    }

    val jobMouseEvent = scope.launch {
        listenMouseEvent().collectLatest { mouseEvent ->
            println("Mouse printed: $mouseEvent")
        }
    }

    jobKeyEvent.join()
    jobKeyEnter.join()
    jobMouseEvent.join()
}