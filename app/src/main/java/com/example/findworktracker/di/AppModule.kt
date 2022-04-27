package com.example.findworktracker.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.findworktracker.data.local.ApiJobService
import com.example.findworktracker.data.local.JobDataBase
import com.example.findworktracker.di.qualifiers.IOThread
import com.example.findworktracker.di.qualifiers.MainThread
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplicationContext(
        @ApplicationContext context: Context
    ) = context

    @MainThread
    @Singleton
    @Provides
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @IOThread
    @Singleton
    @Provides
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): JobDataBase {
        return Room.databaseBuilder(
            appContext,
            JobDataBase::class.java,
            "job_DB"
        ).setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
            .build()
    }


    @Provides
    @Singleton
    fun providesApiService(): ApiJobService =
        Retrofit.Builder()
            .run {
                build()
            }.create(ApiJobService::class.java)

}