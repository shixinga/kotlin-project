package com.shixing.mvp.impl

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.shixing.mvp.IMvpView
import com.shixing.mvp.IPresenter
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.jvmErasure
import kotlin.coroutines.experimental.buildSequence
abstract class BaseFragment<out P:BasePresenter<BaseFragment<P>>>:IMvpView<P>, Fragment() {
    override val presenter: P

    init {
        presenter = createPresenter()
        presenter.view = this
    }
    fun createPresenter() : P {
        buildSequence {
            var thisClass:KClass<*> = this@BaseFragment::class
            while (true) {
                yield(thisClass.supertypes)
                thisClass = thisClass.supertypes.firstOrNull()?.jvmErasure ?: break
            }
        }.flatMap {
            it.flatMap { it.arguments }.asSequence()
        }.first {
            it.type?.jvmErasure?.isSubclassOf(IPresenter::class) ?: false
        }.let {
            return it.type!!.jvmErasure.primaryConstructor!!.call() as P
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        presenter.onViewStateRestored(savedInstanceState)
    }
}

class MainFragment:BaseFragment<MainPresenter>()
class MainPresenter:BasePresenter<MainFragment>() {
    override fun onResume() {
        super.onResume()
        Log.d("Login", "main presenter onresume")
    }
}