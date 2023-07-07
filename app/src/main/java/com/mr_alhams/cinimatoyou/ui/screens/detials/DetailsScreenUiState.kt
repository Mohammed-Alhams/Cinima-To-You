package com.mr_alhams.cinimatoyou.ui.screens.detials

data class DetailsScreenUiState(
    val actorList: List<ActorsUiState> = emptyList()
)

data class ActorsUiState(
    val actor_image: Int
)