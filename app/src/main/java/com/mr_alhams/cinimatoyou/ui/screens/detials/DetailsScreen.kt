import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mr_alhams.cinimatoyou.R
import com.mr_alhams.cinimatoyou.ui.composables.BlurredText
import com.mr_alhams.cinimatoyou.ui.composables.BlurryButton
import com.mr_alhams.cinimatoyou.ui.composables.ChipsList
import com.mr_alhams.cinimatoyou.ui.composables.DefaultButton
import com.mr_alhams.cinimatoyou.ui.theme.OnPrimary
import com.mr_alhams.cinimatoyou.ui.theme.Orange
import com.mr_alhams.cinimatoyou.ui.theme.bodySmall
import com.mr_alhams.cinimatoyou.ui.theme.labelLarge
import com.mr_alhams.cinimatoyou.ui.theme.labelSmall
import com.mr_alhams.cinimatoyou.ui.theme.spanLabelLarge
import com.mr_alhams.cinimatoyou.ui.theme.titleLarge
import com.mr_alhams.cinimatoyou.ui.theme.titleMedium


@Composable
fun DetailsScreen(navController: NavHostController) {

    val casts = listOf(
        R.drawable.img_4,
        R.drawable.img_5,
        R.drawable.img_6,
        R.drawable.img_4,
        R.drawable.img_5,
        R.drawable.img_6
    )
    val categories = listOf("Fantasy", "Adventure")

    val duration = "2h 24min"


    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
    ) {


        Box(
            modifier = Modifier.height((LocalConfiguration.current.screenHeightDp / 2.2).dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.img_8),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                BlurryButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.close),
                        contentDescription = null,
                        tint = Color.White,
                    )
                }

                BlurredText(
                    modifier = Modifier
                        .padding()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.clock),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp),
                        tint = Color.LightGray
                    )
                    Text(
                        text = duration,
                        style = labelSmall.copy(Color.White)
                    )
                }
            }

            Icon(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Orange)
                    .padding(16.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = R.drawable.play),
                contentDescription = null,
                tint = Color.White
            )

        }

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(Color.White)
                .height((LocalConfiguration.current.screenHeightDp / 1.6).dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                RateInformation("IMDb") {
                    RateText("6.8", "10")
                }

                RateInformation(title = "Rotten Tomatoes") {
                    Text(text = "63%", style = labelLarge.copy(color = Color.Black))
                }

                RateInformation("IGN") {
                    RateText("4", "10")
                }
            }

            Text(
                text = "Fantastic Beasts: The Secrets of Dumbledore",
                style = titleLarge,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(top = 16.dp)
            )

            ChipsList(categories, modifier = Modifier.padding(top = 16.dp))

            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(casts) {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(72.dp)
                    )
                }
            }

            Text(
                text = "Professor Albus Dumbledore knows the powerful, dark wizard Gellert Grindelwald is moving to seize control of the wizarding world. Unable to stop him alone, he entrusts magizoologist Newt Scamander to lead an intrepid team of wizards and witches. Eddie Redmayne leads the cast as Newt Scamander, with Jude Law as Albus Dumbledore, and Mads Mikkelsen as Gellert Grindelwald.",
                style = bodySmall,
                color = Color.Black,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 3,
                modifier = Modifier
                    .padding(horizontal = 32.dp)
            )

            DefaultButton(onClick = {
                navController.navigate("theaterScreen")
            }, modifier = Modifier.padding(32.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.credit_card),
                    contentDescription = null,
                    tint = OnPrimary
                )
                Text(
                    text = "Booking",
                    modifier = Modifier.padding(start = 8.dp),
                    style = titleMedium,
                    color = OnPrimary,
                )
            }
        }
    }
}

@Composable
fun RateInformation(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
        Text(text = title, style = titleMedium.copy(color = Color.Gray))
    }
}

@Composable
fun RateText(
    rate: String,
    rateLimit: String
) {
    Text(
        buildAnnotatedString {
            withStyle(style = spanLabelLarge.copy(color = Color.Black)) {
                append(rate)
            }
            withStyle(style = spanLabelLarge.copy(color = Color.Gray)) {
                append("/$rateLimit")
            }
        }
    )
}