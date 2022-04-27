package com.example.findworktracker.repository

import com.example.findworktracker.data.local.ApiJobService
import com.example.findworktracker.data.local.JobDao
import com.example.findworktracker.di.qualifiers.IOThread
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val apiJobService: ApiJobService,
    private val jobDao: JobDao,
    @IOThread private val dispatcher: CoroutineDispatcher
) {





}