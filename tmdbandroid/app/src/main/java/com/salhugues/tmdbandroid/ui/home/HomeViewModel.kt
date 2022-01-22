package com.salhugues.tmdbandroid.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salhugues.tmdbandroid.common.DataState
import com.salhugues.tmdbandroid.domain.interactor.HomeInteractor
import com.salhugues.tmdbandroid.domain.model.Movie
import com.salhugues.tmdbandroid.domain.usecase.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeInteractor: HomeUseCase
) : ViewModel() {

    private val _homeState = MutableStateFlow<DataState<List<Movie>>>(DataState.Loading)
    val homeState
        get() = _homeState

    private val _countDownState = MutableStateFlow(10)
    val countDownState
        get() = _countDownState

    fun setStateAction(state: HomeStateAction) {
        when (state) {
            is HomeStateAction.GetNowPlayingAction -> {
                viewModelScope.launch {
                    _homeState.value = homeInteractor.requestNowPlayingMovies()
                }
            }

            is HomeStateAction.CountDownAction -> {
                viewModelScope.launch {
                    (homeInteractor as HomeInteractor).countDownFlow().collect {
                        _countDownState.value = it
                    }
                }
            }
        }
    }
}

sealed class HomeStateAction {
    object GetNowPlayingAction : HomeStateAction()
    object CountDownAction : HomeStateAction()
}
