package com.mr_alhams.cinimatoyou.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mr_alhams.cinimatoyou.ui.theme.OpenSans

@Composable
fun PaymentInformation(
    totalPrice: String,
    numberOfTickets: String
) {
    Column {
        Row {
            Text(
                text = "$",
                fontFamily = OpenSans,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
            )
            Text(
                text = totalPrice,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
            )
        }
        Row {
            Text(
                modifier = Modifier.padding(end = 2.dp),
                text = numberOfTickets,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
            )
            Text(
                text = "Tickets",
                fontFamily = OpenSans,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
            )
        }
    }
}