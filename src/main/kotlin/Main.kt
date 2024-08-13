package com.tanucube.kit

import com.devkit.kit.inputdevice.api.model.NativeKey
import com.devkit.kit.inputdevice.api.usecase.ListenHotKeyEvent
import com.devkit.kit.inputdevice.api.usecase.ListenHotMouseEvent
import com.devkit.kit.inputdevice.impl.di.inputDeviceDI
import kotlinx.coroutines.flow.collectLatest
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.inject
import kotlin.system.exitProcess

suspend fun main() {

    startKoin {
        modules(inputDeviceDI)
    }

    val listenHotKey: ListenHotKeyEvent by inject(ListenHotKeyEvent::class.java)
    val listenMouseEvent: ListenHotMouseEvent by inject(ListenHotMouseEvent::class.java)


    listenHotKey().collectLatest { keyEvent ->
        println("Key printed: $keyEvent")

        if (keyEvent.key == NativeKey.KEY_ESCAPE) {
            println("Exiting...")
            exitProcess(0)
        }
    }

    listenMouseEvent().collectLatest { mouseEvent ->
        println("Mouse printed: $mouseEvent")
    }

}