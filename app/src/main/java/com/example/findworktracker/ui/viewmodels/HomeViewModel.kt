package com.example.findworktracker.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.findworktracker.di.qualifiers.MainThread
import com.example.findworktracker.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository,
    @MainThread private val dispatcher: CoroutineDispatcher
): ViewModel() {



}