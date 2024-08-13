package com.devkit.kit.inputdevice.impl.usecase

import com.devkit.kit.inputdevice.api.model.KeyEvent
import com.devkit.kit.inputdevice.api.model.KeyEventType
import com.devkit.kit.inputdevice.api.usecase.ListenHotKeyEvent
import kotlinx.coroutines.flow.Flow

internal class ListenHotKeyEventImpl(
    private val keyEventRepository: KeyEventRepository
) : ListenHotKeyEvent {

    interface KeyEventRepository {
        fun listEvents(filterType: List<KeyEventType>): Flow<KeyEvent>
    }

    override fun invoke(filterType: List<KeyEventType>): Flow<KeyEvent> {
        return keyEventRepository.listEvents(filterType)
    }
}
