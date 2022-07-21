package com.jordan.audioplayer.di

import android.content.Context
import com.jordan.audioplayer.data.ContentResolverHelper
import com.jordan.audioplayer.data.repository.AudioRepositoryImpl
import com.jordan.audioplayer.domain.repository.AudioRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContentResolverHelper(
        @ApplicationContext context: Context
    ): ContentResolverHelper {
        return ContentResolverHelper(context)
    }

    @Provides
    @Singleton
    fun provideAudioRepository(
        contentResolverHelper: ContentResolverHelper
    ): AudioRepository {
        return AudioRepositoryImpl(contentResolverHelper)
    }
}