package com.devkit.kit.inputdevice.api.usecase

import com.devkit.kit.inputdevice.api.model.HotKeyStatus
import kotlinx.coroutines.flow.Flow

interface ListenHotKeyStatus {
    operator fun invoke(): Flow<HotKeyStatus>
}
