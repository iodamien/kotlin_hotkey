package com.devkit.kit.inputdevice.api.usecase

import com.devkit.kit.inputdevice.api.model.KeyEvent
import com.devkit.kit.inputdevice.api.model.KeyEventType
import kotlinx.coroutines.flow.Flow

interface ListenHotKeyEvent {
    operator fun invoke(filterType: List<KeyEventType> = KeyEventType.All): Flow<KeyEvent>
}
