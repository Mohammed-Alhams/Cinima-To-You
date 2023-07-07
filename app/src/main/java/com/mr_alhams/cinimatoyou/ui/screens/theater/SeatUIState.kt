package com.mr_alhams.cinimatoyou.ui.screens.theater

data class SeatUIState(
    val seatState: SeatState = SeatState.AVAILABLE,
){
    enum class SeatState{
        AVAILABLE, TAKEN, SELECTED
    }
}
