package com.example.presentation.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.domain.utils.LoadingState
import com.example.presentation.R

@Composable
fun CoilImage(
    data: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop
) {
    var imageState by remember { mutableStateOf<LoadingState>(LoadingState.Loading) }

    Box(modifier = modifier) {
        // Show the image
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data)
                .crossfade(true)
                .listener(
                    onStart = {
                        if (imageState == LoadingState.Loading) {
                            imageState = LoadingState.Loading
                        }
                    },
                    onSuccess = { _, _ ->
                        imageState = LoadingState.Success
                    },
                    onError = { _, _ ->
                        imageState = LoadingState.Error
                    }
                )
                .build(),
            placeholder = painterResource(R.drawable.placeholder),
            error = painterResource(R.drawable.placeholder),
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = Modifier.fillMaxWidth()
        )

        // Show loading indicator while in the loading state
        if (imageState == LoadingState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(40.dp)
            )
        }

    }
}
