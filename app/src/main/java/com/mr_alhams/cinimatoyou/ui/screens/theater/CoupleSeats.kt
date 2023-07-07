package com.mr_alhams.cinimatoyou.ui.screens.theater

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mr_alhams.cinimatoyou.R
import com.mr_alhams.cinimatoyou.ui.theme.BlurredGray20
import com.mr_alhams.cinimatoyou.ui.theme.BlurredGray60
import com.mr_alhams.cinimatoyou.ui.theme.BlurredOrange
import com.mr_alhams.cinimatoyou.ui.theme.Orange

@Composable
fun CoupleSeats(
    seats: Pair<SeatUIState, SeatUIState>,
    modifier: Modifier = Modifier
) {
    val borderColor =
        if (seats.first.seatState == SeatUIState.SeatState.SELECTED &&
            seats.second.seatState == SeatUIState.SeatState.SELECTED
        ) {
            BlurredOrange
        } else if (seats.first.seatState == SeatUIState.SeatState.AVAILABLE &&
            seats.second.seatState == SeatUIState.SeatState.AVAILABLE
        ) {
            BlurredGray60
        } else {
            BlurredGray20
        }

    Box(
        modifier = modifier
            .padding(vertical = 4.dp),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.chair_container),
            contentDescription = null,
            modifier = Modifier
                .width(120.dp)
                .height(40.dp),
            tint = borderColor
        )

        Row {
            Seat(seats.first) {

            }

            Seat(seats.second) {

            }
        }
    }
}

@Composable
private fun Seat(
    seatUIState: SeatUIState,
    onClick: () -> Unit,
) {

    val color = when (seatUIState.seatState) {
        SeatUIState.SeatState.AVAILABLE -> Color.White
        SeatUIState.SeatState.TAKEN -> Color.Gray
        SeatUIState.SeatState.SELECTED -> Orange
    }

    Icon(
        painter = painterResource(id = R.drawable.seat),
        contentDescription = null,
        tint = color,
        modifier = Modifier
            .size(40.dp)
            .padding(start = 2.dp, bottom = 8.dp)
            .clickable { onClick() }
    )

}