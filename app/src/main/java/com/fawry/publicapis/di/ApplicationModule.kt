package com.fawry.publicapis.di

import com.fawry.publicapis.BuildConfig
import com.fawry.remote.di.qualifiers.AppBuildType
import com.fawry.remote.di.qualifiers.AppRemoteUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class ApplicationModule {

    @AppRemoteUrl
    @Provides
    fun provideBaseURl(): String {
        return "https://api.publicapis.org/"
    }

    @AppBuildType
    @Provides
    fun provideBuildType(): Boolean {
        return BuildConfig.DEBUG
    }

}