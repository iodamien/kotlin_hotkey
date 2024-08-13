package com.devkit.kit.inputdevice.api.model

enum class MouseEventType {
    MOUSE_PRESSED,
    MOUSE_RELEASED,
    MOUSE_CLICKED,
    MOUSE_MOVED,
    MOUSE_DRAGGED;

    companion object {
        val All = listOf(
            MOUSE_PRESSED,
            MOUSE_RELEASED,
            MOUSE_CLICKED,
            MOUSE_MOVED,
            MOUSE_DRAGGED
        )
    }
}
