package com.salhugues.tmdbandroid.app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salhugues.tmdbandroid.app.common.DataState
import com.salhugues.tmdbandroid.app.domain.model.Movie
import com.salhugues.tmdbandroid.app.domain.usecase.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {

    private val _homeState = MutableStateFlow<DataState<List<Movie>>>(DataState.Loading)
    val homeState
        get() = _homeState

    fun setStateAction(state: HomeStateAction) {
        viewModelScope.launch {
            when (state) {
                is HomeStateAction.GetNowPlayingAction -> {
                    _homeState.value = homeUseCase.requestNowPlayingMovies()
                }
            }
        }
    }
}

sealed class HomeStateAction {
    object GetNowPlayingAction : HomeStateAction()
}
