package com.afkoders.batteryme.di.components

import com.afkoders.batteryme.HackathonApplication
import com.afkoders.batteryme.data.repository.RepositoryModule
import com.afkoders.batteryme.di.modules.ApplicationModule
import com.afkoders.batteryme.di.modules.NetworkingModule
import com.afkoders.batteryme.di.modules.RxModule
import com.afkoders.batteryme.di.scope.ApplicationScope
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


@ApplicationScope
@Component(
    modules = [AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        RxModule::class,
        RepositoryModule::class,
        NetworkingModule::class]
)
interface ApplicationComponent : AndroidInjector<HackathonApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<HackathonApplication>()
}