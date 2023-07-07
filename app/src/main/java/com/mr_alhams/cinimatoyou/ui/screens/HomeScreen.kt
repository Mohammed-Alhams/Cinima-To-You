package com.mr_alhams.cinimatoyou.ui.screens

import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mr_alhams.cinimatoyou.R
import com.mr_alhams.cinimatoyou.ui.composables.BottomNavBar
import com.mr_alhams.cinimatoyou.ui.composables.BottomNavBarItem
import com.mr_alhams.cinimatoyou.ui.composables.ChipsList
import com.mr_alhams.cinimatoyou.ui.composables.SpacerVertical24
import com.mr_alhams.cinimatoyou.ui.theme.Orange
import com.mr_alhams.cinimatoyou.ui.theme.labelLarge
import com.mr_alhams.cinimatoyou.ui.theme.labelSmall
import com.mr_alhams.cinimatoyou.ui.theme.titleLarge
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController
) {

    val categories = listOf("Fantasy", "Adventure")
    val images = listOf(R.drawable.img, R.drawable.img_1, R.drawable.img_2)
    val title = "Fantastic Beasts: The Secrets of Dumbledore"
    val duration = "2h 24min"
    val pagerState = rememberPagerState(initialPage = 1)


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Box(
            modifier = Modifier
                .height(500.dp)
                .fillMaxWidth()
        ) {

            GradiantContent(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.White,
                    )
                )
            ) {

                Crossfade(
                    targetState = images[pagerState.currentPage],
                    animationSpec = tween(1000),
                    label = ""
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .blur(16.dp),
                        painter = painterResource(id = it),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }

            }

            Column {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    DefaultTab(stringResource(R.string.now_playing), true) {

                    }
                    DefaultTab(stringResource(R.string.coming_soon), false) {

                    }
                }

                CarouselSlider(pagerState, images) {
                    MovieCard(
                        painterResource(id = images[it]),
                        modifier = Modifier
                            .width(300.dp)
                            .height(450.dp)
                    ) {
                        navController.navigate("detailsScreen")
                    }
                }
            }

        }

        SpacerVertical24()
        Row(
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 4.dp),
                tint = Color.Gray
            )
            Text(
                text = duration,
                style = labelSmall
            )
        }

        SpacerVertical24()
        Text(
            text = title,
            style = titleLarge,
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        SpacerVertical24()
        ChipsList(categories)
        Spacer(modifier = Modifier.weight(1f))
        BottomNavBar(modifier = Modifier.padding(16.dp)) {
            BottomNavBarItem(isSelected = true, painter = painterResource(id = R.drawable.video)) {

            }
            BottomNavBarItem(
                isSelected = false,
                painter = painterResource(id = R.drawable.search)
            ) {

            }
            BottomNavBarItem(
                isSelected = false,
                painter = painterResource(id = R.drawable.credit_card)
            ) {

            }
            BottomNavBarItem(
                isSelected = false,
                painter = painterResource(id = R.drawable.person)
            ) {

            }
        }
    }

}

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun <T> CarouselSlider(
    pagerState: PagerState,
    state: List<T>,
    content: @Composable (index: Int) -> Unit
) {
    HorizontalPager(
        state = pagerState,
        pageCount = state.size,
        contentPadding = PaddingValues(horizontal = 56.dp),
        modifier = Modifier.padding(top = 24.dp)
    ) { currentPage ->
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(450.dp)
                .graphicsLayer {
                    val pageOffset =
                        ((pagerState.currentPage - currentPage) + pagerState.currentPageOffsetFraction)
                            .absoluteValue
                    alpha = 1f - pageOffset.coerceIn(0f, 0.8f)
                    scaleY = 1f - pageOffset.coerceIn(0f, 0.1f)
                    scaleX = 1f - pageOffset.coerceIn(0f, 0.1f)
                }
        ) {
            content(currentPage)
        }
    }
}

@Composable
fun DefaultTab(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {

    val backgroundColor = if (isSelected) Orange else Color.Transparent

    val borderColor = if (isSelected) Color.Transparent else Color.White

    Text(
        text = title,
        style = labelLarge,
        color = Color.White,
        modifier = Modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .border(1.dp, color = borderColor, CircleShape)
            .clickable { onClick() }
            .padding(vertical = 8.dp, horizontal = 16.dp),
    )
}


@Composable
private fun GradiantContent(
    brush: Brush,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box {
        content()
        Box(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .alpha(1f)
                .background(brush = brush),
        )
    }
}


@Composable
fun MovieCard(
    painter: Painter,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier
            .clickable { onClick() }
            .clip(RoundedCornerShape(32.dp)),
        contentScale = ContentScale.Crop
    )
}
