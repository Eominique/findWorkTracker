package com.example.findworktracker.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.findworktracker.models.Job

@Dao
interface JobDao {

    @Query("SELECT * FROM job_table ORDER BY publication_date DESC LIMIT 10")
    fun getAllJobs(): LiveData<List<Job>>

    @Query("SELECT * FROM job_table  ORDER BY publication_date DESC")
    fun getLiveDataMarked(): LiveData<List<Job>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note : Job):Long

    @Query("DELETE FROM job_table WHERE id = :id")
    suspend fun delete(id : Int):Int

    @Query("select id from job_table")
    fun getIds():LiveData<List<Int>>

    @Query("SELECT * FROM job_table WHERE title LIKE :keyword OR company_name LIKE :keyword OR category LIKE :keyword")
    suspend fun searchNotes(keyword :String): List<Job>
}