package com.devkit.kit.inputdevice.impl.util

import com.github.kwhat.jnativehook.GlobalScreen

object GlobalScreenUtil {

    fun tryRegisterNativeHook() {
        if (!GlobalScreen.isNativeHookRegistered()) {
            GlobalScreen.registerNativeHook()
        }
    }
}
