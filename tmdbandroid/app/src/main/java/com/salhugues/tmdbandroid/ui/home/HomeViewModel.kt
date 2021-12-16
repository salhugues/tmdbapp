package com.salhugues.tmdbandroid.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salhugues.tmdbandroid.common.DataState
import com.salhugues.tmdbandroid.domain.model.Movie
import com.salhugues.tmdbandroid.domain.usecase.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {

    private val _movieHomeState = MutableStateFlow<DataState<List<Movie>>>(DataState.None)
    val movieHomeState
        get() = _movieHomeState

    fun setStateAction(state: HomeStateAction) {
        viewModelScope.launch {
            when (state) {
                is HomeStateAction.None -> {
                    _movieHomeState.value = DataState.None
                }

                is HomeStateAction.GetNowPlayingAction -> {
                    _movieHomeState.value = DataState.Loading
                    _movieHomeState.value = homeUseCase.requestNowPlayingMovies().await()
                }
            }
        }
    }
}

sealed class HomeStateAction {
    object None : HomeStateAction()
    object GetNowPlayingAction : HomeStateAction()
}
