package com.devkit.kit.inputdevice.api.model

sealed class MouseButton {
    data class Other(val button: Int) : MouseButton()
    data object Left : MouseButton()
    data object Right : MouseButton()
    data object Middle : MouseButton()
    data object None : MouseButton()

    val isLeft: Boolean
        get() = this is Left

    val isRight: Boolean
        get() = this is Right

    val isMiddle: Boolean
        get() = this is Middle
}
