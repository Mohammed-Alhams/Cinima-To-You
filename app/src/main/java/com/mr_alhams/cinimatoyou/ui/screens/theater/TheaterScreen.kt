package com.mr_alhams.cinimatoyou.ui.screens.theater

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mr_alhams.cinimatoyou.R
import com.mr_alhams.cinimatoyou.ui.composables.BlurryButton
import com.mr_alhams.cinimatoyou.ui.composables.DefaultButton
import com.mr_alhams.cinimatoyou.ui.composables.PaymentInformation
import com.mr_alhams.cinimatoyou.ui.composables.ShowDates
import com.mr_alhams.cinimatoyou.ui.composables.ShowTimes
import com.mr_alhams.cinimatoyou.ui.theme.OnPrimary
import com.mr_alhams.cinimatoyou.ui.theme.OpenSans
import com.mr_alhams.cinimatoyou.ui.theme.Orange

@Composable
fun TheaterScreen(navController: NavHostController) {

    val times =
        listOf(
            ShowTimeUIState("10:00", true),
            ShowTimeUIState("10:00", false),
            ShowTimeUIState("10:00", false),
            ShowTimeUIState("10:00", false),
            ShowTimeUIState("10:00", false),
            ShowTimeUIState("10:00", false),
            ShowTimeUIState("10:00", false),
            ShowTimeUIState("10:00", false),
        )

    val dates = listOf(
        ShowDatesUIState("14", "Thu"),
        ShowDatesUIState("14", "Thu", true),
        ShowDatesUIState("14", "Thu"),
        ShowDatesUIState("14", "Thu"),
        ShowDatesUIState("14", "Thu"),
        ShowDatesUIState("14", "Thu"),
        ShowDatesUIState("14", "Thu"),
        ShowDatesUIState("14", "Thu"),
    )

    val seats = listOf(
        Pair(
            SeatUIState(SeatUIState.SeatState.SELECTED),
            SeatUIState(SeatUIState.SeatState.SELECTED)
        ),
        Pair(SeatUIState(), SeatUIState()),
        Pair(SeatUIState(), SeatUIState()),
        Pair(SeatUIState(SeatUIState.SeatState.TAKEN), SeatUIState()),
        Pair(SeatUIState(), SeatUIState()),
    )

    val totalPrice = "100.00"

    val numberOfTickets = "4"


    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {

        Column {
            BlurryButton(onClick = {
                navController.navigateUp()
            }, modifier = Modifier.padding(16.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = null,
                    tint = Color.White,
                )
            }

            Image(
                painter = painterResource(id = R.drawable.img_3),
                contentDescription = null,
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(seats) {
                        CoupleSeats(it, modifier = Modifier.rotate(8f))
                    }
                }

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    items(seats) {
                        CoupleSeats(it)
                    }
                }

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(seats) {
                        CoupleSeats(it, modifier = Modifier.rotate(-8f))
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SeatStatus(Color.White, stringResource(R.string.available))
                SeatStatus(Color.Gray, stringResource(R.string.taken))
                SeatStatus(Orange, stringResource(R.string.selected))
            }
        }


        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(Color.White)
                .align(Alignment.BottomCenter)
        ) {

            ShowDates(dates, modifier = Modifier.padding(top = 32.dp)) {}

            ShowTimes(times, modifier = Modifier.padding(top = 16.dp)) {}

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                PaymentInformation(totalPrice, numberOfTickets)

                DefaultButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.credit_card),
                        contentDescription = null,
                        tint = OnPrimary
                    )
                    Text(
                        text = stringResource(R.string.buy_tickets),
                        modifier = Modifier.padding(start = 8.dp),
                        color = OnPrimary,
                        fontFamily = OpenSans,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }

}

@Composable
private fun SeatStatus(color: Color, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(color)
                .size(10.dp)
        )

        Text(
            text = text,
            color = Color.Gray,
            fontSize = 14.sp,
            fontFamily = OpenSans,
            fontWeight = FontWeight.Normal
        )
    }
}