package com.salhugues.tmdbandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.salhugues.tmdbandroid.R
import com.salhugues.tmdbandroid.common.DataState
import com.salhugues.tmdbandroid.databinding.FragmentHomeBinding
import com.salhugues.tmdbandroid.errorMessage
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToObservers()
        homeViewModel.setStateAction(HomeStateAction.GetNowPlayingAction)

        binding.btnGotoSearch.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.gotoSearch())
        }

        binding.btnGotoExample.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.gotoExample())
        }
    }

    private fun subscribeToObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.homeState.collect { dataState ->
                    when (dataState) {
                        is DataState.Success -> {
                            context?.let {
                                Toast.makeText(activity, "Success", Toast.LENGTH_SHORT).show()
                            }
                        }
                        is DataState.Error -> {
                            context?.let {
                                Toast.makeText(
                                    activity,
                                    errorMessage(dataState.apiError, it.resources),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                        is DataState.Loading -> {
                            context?.let {
                                Toast.makeText(
                                    activity,
                                    getString(R.string.state_loading),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                        else -> {
                            // do nothing
                        }
                    }
                }
            }
        }
    }
}
