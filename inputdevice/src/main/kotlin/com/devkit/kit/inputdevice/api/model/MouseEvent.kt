package com.devkit.kit.inputdevice.api.model

sealed class MouseEvent {
    data class Pressed(
        override val position: Position,
        val button: MouseButton,
    ) : MouseEvent() {
        override val type: MouseEventType = MouseEventType.MOUSE_PRESSED
    }

    data class Released(
        override val position: Position,
        val button: MouseButton,
    ) : MouseEvent() {
        override val type: MouseEventType = MouseEventType.MOUSE_RELEASED
    }

    data class Clicked(
        override val position: Position,
        val button: MouseButton?,
    ) : MouseEvent() {
        override val type: MouseEventType = MouseEventType.MOUSE_CLICKED
    }

    data class Moved(
        override val position: Position
    ) : MouseEvent() {
        override val type: MouseEventType = MouseEventType.MOUSE_MOVED
    }

    data class Dragged(
        override val position: Position,
        val mouseButton: MouseButton,
    ) : MouseEvent() {
        override val type: MouseEventType = MouseEventType.MOUSE_DRAGGED
    }

    abstract val position: Position
    abstract val type: MouseEventType
}
