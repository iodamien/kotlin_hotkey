package com.devkit.kit.inputdevice.api.model


sealed class KeyEvent {
    data class Pressed(
        override val key: NativeKey,
    ) : KeyEvent()

    data class Released(
        override val key: NativeKey
    ) : KeyEvent()

    data class Typed(
        override val key: NativeKey
    ) : KeyEvent()

    abstract val key: NativeKey

    val isPressed: Boolean
        get() = this is Pressed

    val isReleased: Boolean
        get() = this is Released
}
