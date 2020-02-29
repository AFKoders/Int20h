package com.afkoders.batteryme.presentation.base

import com.afkoders.batteryme.utils.extensions.disposeBy
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import java.lang.ref.WeakReference

abstract class BasePresenterImpl<M, V : BaseView> : BasePresenter<V>, KoinComponent {

    private val compositeDisposable: CompositeDisposable by inject()

    protected var model: M? = null
        set(value) {
            resetState()
            field = value
        }

    private var viewWeakReference: WeakReference<V>? = null
    protected val view: V?
        get() = viewWeakReference?.get()

    protected fun resetState() {}

    override fun bindView(view: V) {
        this.viewWeakReference = WeakReference(view)
    }

    override fun unbindView() {
        this.viewWeakReference = null
    }

    fun Disposable.disposeByBagProvider() = disposeBy(compositeDisposable)

    protected fun <T> Observable<T>.bindLoading(): Observable<T> =
        this.observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view?.showLoading() }
            .doOnNext { view?.hideLoading() }
            .doOnTerminate { view?.hideLoading() }
            .doOnError { view?.hideLoading() }

    protected fun <T> Single<T>.bindLoading(): Single<T> =
        this.observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view?.showLoading() }
            .doOnSuccess { view?.hideLoading() }
            .doOnError { view?.hideLoading() }
}