package com.example.findworktracker.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.findworktracker.databinding.ListJobsFragmentBinding
import com.example.findworktracker.ui.viewmodels.ListJobsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListJobsFragment: Fragment() {

    private var _binding: ListJobsFragmentBinding? = null
    private val binding get() = _binding!!

    private val listJobsViewModel: ListJobsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListJobsFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}