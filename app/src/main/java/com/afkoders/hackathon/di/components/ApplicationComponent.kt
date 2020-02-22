package com.afkoders.hackathon.di.components

import com.afkoders.hackathon.HackathonApplication
import com.afkoders.hackathon.data.repository.RepositoryModule
import com.afkoders.hackathon.di.modules.ApplicationModule
import com.afkoders.hackathon.di.modules.NetworkingModule
import com.afkoders.hackathon.di.modules.RxModule
import com.afkoders.hackathon.di.scope.ApplicationScope
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