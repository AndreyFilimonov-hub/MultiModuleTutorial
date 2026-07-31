package com.filimonov.stepikclient.feature.onboarding.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.filimonov.onboarding.R
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    viewModel: OnboardingViewModel = koinViewModel(),
    onNavigate: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.events.collect { onboardingEvent ->
            when (onboardingEvent) {
                OnboardingEvent.Completed -> onNavigate()
            }
        }
    }

    val pages = listOf(
        OnboardingPage(
            R.drawable.onboarding_courses,
            R.string.onboarding_courses_title,
            R.string.onboarding_courses_desc
        ),
        OnboardingPage(
            R.drawable.onboarding_progress,
            R.string.onboarding_progress_title,
            R.string.onboarding_progress_desc
        ),
        OnboardingPage(
            R.drawable.onboarding_certificate,
            R.string.onboarding_certificate_title,
            R.string.onboarding_certificate_desc
        )
    )
    val pagerState = rememberPagerState { pages.size }

    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { position ->
                OnboardingPageContent(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    page = pages[position]
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                StartButton(
                    pagerState = pagerState,
                    lastPageIndex = pages.lastIndex,
                    onClick = {
                        viewModel.completeOnboarding()
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            AnimatedIndicators(
                total = pages.size,
                selectedIndex = pagerState.currentPage
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun AnimatedIndicators(
    modifier: Modifier = Modifier,
    total: Int,
    selectedIndex: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(total) { index ->
            val isSelected = index == selectedIndex

            val width by animateDpAsState(
                targetValue = if (isSelected) 24.dp else 8.dp
            )

            val color by animateColorAsState(
                targetValue = if (isSelected) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
                }
            )

            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .heightIn(8.dp)
                    .width(width)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}

@Composable
private fun OnboardingPageContent(
    modifier: Modifier = Modifier,
    page: OnboardingPage
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(page.imageResId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(page.titleResId),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(page.descriptionResId),
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun StartButton(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    lastPageIndex: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.padding(horizontal = 40.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == lastPageIndex
        ) {
            Button(
                modifier = modifier
                    .width(260.dp)
                    .heightIn(min = 48.dp),
                onClick = onClick
            ) {
                Text(
                    text = stringResource(R.string.login),
                    fontSize = 19.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}