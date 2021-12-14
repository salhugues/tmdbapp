package com.salhugues.tmdbandroid.ui.home

import androidx.lifecycle.ViewModel
import com.salhugues.tmdbandroid.common.DataStateWrapper
import com.salhugues.tmdbandroid.domain.usecase.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {

    private val _movieHomeState = MutableStateFlow(DataStateWrapper.Idle)
    private val movieHomeState = _movieHomeState
}
