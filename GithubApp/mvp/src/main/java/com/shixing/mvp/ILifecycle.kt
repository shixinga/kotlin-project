package com.shixing.mvp

import android.content.res.Configuration
import android.os.Bundle

interface ILifecycle {
    fun onCreate(saveInstanceState:Bundle ?)
    fun onSaveInstanceState(saveInstanceState:Bundle)
    fun onViewStateRestored(saveInstanceState:Bundle?)
    fun onConfigurationChanged(newConfig:Configuration)
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
}