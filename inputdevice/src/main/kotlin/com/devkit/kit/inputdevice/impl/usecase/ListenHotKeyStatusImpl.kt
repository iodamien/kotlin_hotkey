package com.devkit.kit.inputdevice.impl.usecase

import com.devkit.kit.inputdevice.api.model.HotKeyStatus
import com.devkit.kit.inputdevice.api.usecase.ListenHotKeyStatus
import kotlinx.coroutines.flow.Flow

internal class ListenHotKeyStatusImpl(
    private val keyEventRepository: KeyEventRepository,
) : ListenHotKeyStatus {

    interface KeyEventRepository {
        fun listenHotKeyEventStatus(): Flow<HotKeyStatus>
    }

    override fun invoke(): Flow<HotKeyStatus> {
        return keyEventRepository.listenHotKeyEventStatus()
    }
}
