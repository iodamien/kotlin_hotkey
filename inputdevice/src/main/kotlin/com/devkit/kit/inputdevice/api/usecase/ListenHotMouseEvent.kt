package com.devkit.kit.inputdevice.api.usecase

import com.devkit.kit.inputdevice.api.model.MouseEvent
import com.devkit.kit.inputdevice.api.model.MouseEventType
import kotlinx.coroutines.flow.Flow

interface ListenHotMouseEvent {
    operator fun invoke(filterType: List<MouseEventType> = MouseEventType.All): Flow<MouseEvent>
}
