package com.afkoders.batteryme.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.afkoders.batteryme.presentation.dialogs.BaseDialog
import com.afkoders.batteryme.presentation.dialogs.LoaderDialog
import com.afkoders.batteryme.utils.extensions.disposeBy
import com.afkoders.batteryme.utils.extensions.throttleFirst
import com.jakewharton.rxbinding2.view.RxView
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.koin.android.ext.android.inject
import org.koin.standalone.KoinComponent
import javax.inject.Inject

abstract class BaseFragmentImpl<P : BasePresenter<V>, V : BaseView>(@LayoutRes val layoutRes: Int) :
    Fragment(), BaseView, KoinComponent {

    protected val progress: BaseDialog = LoaderDialog.createDialog {
        isCancelableOnTouchOutside = false
        shouldClearDim = true
    }

    private val compositeDisposable: CompositeDisposable by inject()

    protected lateinit var presenter: P


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(layoutRes, null, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupInputs()
    }

    override fun onResume() {
        super.onResume()
        presenter.bindView(returnThisHerePlease())
    }

    override fun onPause() {
        super.onPause()
        presenter.unbindView()
    }

    protected fun Disposable.disposeByBagProvider() = disposeBy(compositeDisposable)

    protected fun View.bindClick(block: () -> Unit) = RxView.clicks(this)
        .throttleFirst()
        .subscribe { block.invoke() }
        .disposeByBagProvider()

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    abstract fun setupInputs()

    abstract fun returnThisHerePlease(): V
}