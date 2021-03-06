/*
 * Copyright (c) 2020 Chamich Apps. All rights reserved.
 */

package app.chamich.feature.profile.di

import app.chamich.feature.profile.api.Profile
import app.chamich.library.logger.ILogger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ProfileModule {

    @Provides
    @Singleton
    fun providesProfile(logger: ILogger) = Profile(logger)
}
