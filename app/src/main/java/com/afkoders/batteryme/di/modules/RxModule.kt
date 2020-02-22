package com.afkoders.batteryme.di.modules

import com.afkoders.batteryme.di.qualifiers.SchedulerIO
import com.afkoders.batteryme.di.qualifiers.SchedulerUI
import com.afkoders.batteryme.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

@Module
class RxModule {
    @ApplicationScope
    @SchedulerIO
    @Provides
    fun provideIoScheduler(): Scheduler = Schedulers.io()

    @ApplicationScope
    @SchedulerUI
    @Provides
    fun provideUiScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}