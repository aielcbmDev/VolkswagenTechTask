package com.something.volkswagentechtask.utils

import kotlin.experimental.ExperimentalNativeApi

class BuildConfigImpl : BuildConfig {

    @OptIn(ExperimentalNativeApi::class)
    override fun isDebug(): Boolean {
        return Platform.isDebugBinary
    }
}
