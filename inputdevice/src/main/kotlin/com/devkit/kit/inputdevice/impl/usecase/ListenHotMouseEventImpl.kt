package com.devkit.kit.inputdevice.impl.usecase

import com.devkit.kit.inputdevice.api.model.MouseEvent
import com.devkit.kit.inputdevice.api.model.MouseEventType
import com.devkit.kit.inputdevice.api.usecase.ListenHotMouseEvent
import kotlinx.coroutines.flow.Flow


internal class ListenHotMouseEventImpl(
    private val mouseEventRepository: MouseEventRepository
) : ListenHotMouseEvent {

    interface MouseEventRepository {
        fun listEvents(filterType: List<MouseEventType>): Flow<MouseEvent>
    }

    override fun invoke(filterType: List<MouseEventType>): Flow<MouseEvent> {
        return mouseEventRepository.listEvents(filterType)
    }
}

