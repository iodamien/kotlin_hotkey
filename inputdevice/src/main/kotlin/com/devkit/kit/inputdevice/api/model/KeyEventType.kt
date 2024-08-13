package com.devkit.kit.inputdevice.api.model

enum class KeyEventType {
    KEY_PRESSED,
    KEY_RELEASED,
    KEY_TYPED;

    companion object {
        val All = listOf(
            KEY_PRESSED,
            KEY_RELEASED,
            KEY_TYPED
        )
    }
}
