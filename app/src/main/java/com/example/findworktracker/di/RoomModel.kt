package com.example.findworktracker.di

import com.example.findworktracker.data.local.JobDao
import com.example.findworktracker.data.local.JobDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RoomModel {


    @Provides
    @ViewModelScoped
    fun provideNoteDao(appDatabase: JobDataBase): JobDao {
        return appDatabase.noteDao()
    }


}