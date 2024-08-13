package com.devkit.kit.inputdevice.impl.di

import com.devkit.kit.inputdevice.api.usecase.ListenHotKeyEvent
import com.devkit.kit.inputdevice.api.usecase.ListenHotKeyStatus
import com.devkit.kit.inputdevice.api.usecase.ListenHotMouseEvent
import com.devkit.kit.inputdevice.impl.repository.KeyEventRepository
import com.devkit.kit.inputdevice.impl.repository.MouseEventRepository
import com.devkit.kit.inputdevice.impl.usecase.ListenHotKeyEventImpl
import com.devkit.kit.inputdevice.impl.usecase.ListenHotKeyStatusImpl
import com.devkit.kit.inputdevice.impl.usecase.ListenHotMouseEventImpl
import org.koin.dsl.binds
import org.koin.dsl.module

internal val repositoryModule = module {
    single { MouseEventRepository() } binds (
        arrayOf(
            ListenHotMouseEventImpl.MouseEventRepository::class,
        )
    )

    single { KeyEventRepository() } binds (
        arrayOf(
            ListenHotKeyEventImpl.KeyEventRepository::class,
            ListenHotKeyStatusImpl.KeyEventRepository::class,
        )
    )
}

internal val domainModule = module {
    single<ListenHotMouseEvent> { ListenHotMouseEventImpl(get()) }
    single<ListenHotKeyEvent> { ListenHotKeyEventImpl(get()) }
    single<ListenHotKeyStatus> { ListenHotKeyStatusImpl(get()) }
}

val inputDeviceDI = module {
    includes(repositoryModule, domainModule)
}
