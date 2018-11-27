package com.shixing.mvp.impl

import android.content.res.Configuration
import android.os.Bundle
import com.shixing.mvp.IMvpView
import com.shixing.mvp.IPresenter

abstract class BasePresenter<out V:IMvpView<BasePresenter<V>>>:IPresenter<V> {
    override lateinit var view: @UnsafeVariance V

    override fun onCreate(saveInstanceState: Bundle?) = Unit

    override fun onSaveInstanceState(saveInstanceState: Bundle) = Unit

    override fun onViewStateRestored(saveInstanceState: Bundle?) = Unit

    override fun onConfigurationChanged(newConfig: Configuration)  = Unit

    override fun onStart()  = Unit

    override fun onResume()  = Unit

    override fun onPause()  = Unit

    override fun onStop()  = Unit

    override fun onDestroy()  = Unit

}