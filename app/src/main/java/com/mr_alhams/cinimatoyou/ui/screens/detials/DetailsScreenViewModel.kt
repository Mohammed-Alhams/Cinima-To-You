package com.mr_alhams.cinimatoyou.ui.screens.detials

import androidx.lifecycle.ViewModel
import com.mr_alhams.cinimatoyou.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class DetailsScreenViewModel @Inject constructor(): ViewModel() {

    private val _state = MutableStateFlow(DetailsScreenUiState())
    val state = _state.asStateFlow()

    init {
        getActors()
    }

    private fun getActors() {
        _state.update {
            it.copy(
                actorList = listOf(
                    ActorsUiState(R.drawable.img_1),
                    ActorsUiState(R.drawable.img),
                    ActorsUiState(R.drawable.img_2),
                )
            )
        }
    }
}