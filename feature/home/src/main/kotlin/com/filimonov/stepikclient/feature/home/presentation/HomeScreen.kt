package com.filimonov.stepikclient.feature.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.filimonov.core.stepikclient.domain.NetworkError
import com.filimonov.core.stepikclient.domain.course.Course
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    when (val currentState = state) {
        is HomeUiState.Error -> ErrorScreen(modifier = modifier, error = currentState.error)
        HomeUiState.Idle,
        HomeUiState.Loading -> LoadingScreen(modifier)

        is HomeUiState.Success -> CourseScreen(modifier = modifier, courses = currentState.courses)
    }
}

@Composable
private fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun ErrorScreen(
    modifier: Modifier = Modifier,
    error: NetworkError
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$error",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun CourseScreen(
    modifier: Modifier = Modifier,
    courses: List<Course>
) {
    Scaffold(modifier = modifier) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp),
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = courses, key = { it.id }) { course ->
                CourseItem(course = course)
            }
        }
    }
}

@Composable
private fun CourseItem(
    modifier: Modifier = Modifier,
    course: Course
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                model = course.cover,
                contentDescription = course.title,
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = course.title,
                    maxLines = 2
                )
                course.summary?.let { summary ->
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = summary,
                        maxLines = 3
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${course.learnersCount} учеников"
                    )
                    if (course.isPaid) {
                        AssistChip(
                            onClick = {},
                            label = {
                                Text(text = "Платный")
                            }
                        )
                    } else {
                        AssistChip(
                            onClick = {},
                            label = {
                                Text(text = "Беслатный")
                            }
                        )
                    }
                }
            }
        }
    }
}