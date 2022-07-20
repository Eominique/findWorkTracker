package com.example.findworktracker.repository

import com.example.findworktracker.data.local.ApiJobService
import com.example.findworktracker.data.local.JobDao
import com.example.findworktracker.di.qualifiers.IOThread
import com.example.findworktracker.helper.Resource
import com.example.findworktracker.models.Job
import com.example.findworktracker.models.ParentJob
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val apiJobService: ApiJobService,
    private val jobDao: JobDao,
    @IOThread private val dispatcher: CoroutineDispatcher
) {

    suspend fun getListJob(currentJob: Int): Resource<ParentJob> = withContext(dispatcher) {
        val result = apiJobService.getListJobs(currentJob)
        Resource.Success(result)
    }

    suspend fun insertMarkedJob(job: Job): Resource<Long> = withContext(dispatcher) {
        val result = jobDao.insertNote(job)
        Resource.Success(result)
    }

    suspend fun getMarkerList(): Resource<List<Job>> = withContext(dispatcher) {
        val result = jobDao.getAllNote()
        Resource.Success(result)
    }

}