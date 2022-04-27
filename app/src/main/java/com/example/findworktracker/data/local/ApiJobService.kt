package com.example.findworktracker.data.local

import com.example.findworktracker.models.ParentJob
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiJobService {

    @GET("remote-jobs")
    suspend fun getListJobs(
        @Query("limit") page: Int
    ): ParentJob

    @GET("remote-jobs")
    suspend fun searchJobList(
        @Query("limit") page: Int,
        @Query("search") keyword: String?
    ): ParentJob

}