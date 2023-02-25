package com.fawry.publicapis.di

import android.app.Application
import android.content.Context
import com.fawry.publicapis.BuildConfig
import com.fawry.publicapis.di.annotations.qualifiers.AppBuildType
import com.fawry.publicapis.di.annotations.qualifiers.AppContext
import com.fawry.publicapis.di.annotations.qualifiers.AppRemoteUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class ApplicationModule {

    @AppContext
    @Provides
    fun context(application: Application): Context {
        return application.applicationContext
    }

    @AppRemoteUrl
    @Provides
    fun provideBaseURl(): String {
        return BuildConfig.BASE_URL
    }

    @AppBuildType
    @Provides
    fun provideBuildType(): Boolean {
        return BuildConfig.DEBUG
    }

}