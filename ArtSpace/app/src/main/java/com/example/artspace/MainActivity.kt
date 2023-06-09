package com.example.artspace

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    // Current step the app is displaying (remember allows the state to be retained
    // across recompositions).
    var currentStep by remember { mutableStateOf(1) }

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Spacer(modifier = Modifier.height(125.dp))
                    Image(
                        painter = painterResource(R.drawable.image_1),
                        contentDescription = stringResource(R.string.content_description_1),
                        modifier = Modifier
                            .wrapContentSize()
                            .size(375.dp)
                            .shadow(elevation = 4.dp, shape = RectangleShape)
                            .padding(20.dp)
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    Text(text = stringResource(R.string.text_1),
                        textAlign = TextAlign.Center,
                        fontSize = 22.sp)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = stringResource(R.string.name) + stringResource(R.string.year_1),
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Button(enabled = false, onClick = { currentStep-- },
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp).width(150.dp)) {
                            Text(stringResource(R.string.previous))
                        }
                        Button(onClick = { currentStep++ },
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp).width(150.dp)) {
                            Text(stringResource(R.string.next))
                        }
                    }
                }
            }
            2 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Spacer(modifier = Modifier.height(125.dp))
                    Image(
                        painter = painterResource(R.drawable.image_2),
                        contentDescription = stringResource(R.string.content_description_2),
                        modifier = Modifier
                            .wrapContentSize()
                            .size(375.dp)
                            .shadow(elevation = 4.dp, shape = RectangleShape)
                            .padding(20.dp)
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(text = stringResource(R.string.text_2),
                        textAlign = TextAlign.Center,
                        fontSize = 22.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = stringResource(R.string.name) + stringResource(R.string.year_1),
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Button(onClick = { currentStep-- },
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp).width(150.dp)) {
                            Text(stringResource(R.string.previous))
                        }
                        Button(onClick = { currentStep++ },
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp).width(150.dp)) {
                            Text(stringResource(R.string.next))
                        }
                    }
                }
            }
            3 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Spacer(modifier = Modifier.height(125.dp))
                    Image(
                        painter = painterResource(R.drawable.image_3),
                        contentDescription = stringResource(R.string.content_description_3),
                        modifier = Modifier
                            .wrapContentSize()
                            .size(375.dp)
                            .shadow(elevation = 4.dp, shape = RectangleShape)
                            .padding(20.dp)
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(text = stringResource(R.string.text_3),
                        textAlign = TextAlign.Center,
                        fontSize = 22.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = stringResource(R.string.name)  + stringResource(R.string.year_1),
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Button(onClick = { currentStep-- },
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp).width(150.dp)) {
                            Text(stringResource(R.string.previous))
                        }
                        Button(onClick = { currentStep++ },
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp).width(150.dp)) {
                            Text(stringResource(R.string.next))
                        }
                    }
                }
            }
            4 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Spacer(modifier = Modifier.height(125.dp))
                    Image(
                        painter = painterResource(R.drawable.image_4),
                        contentDescription = stringResource(R.string.content_description_4),
                        modifier = Modifier
                            .wrapContentSize()
                            .size(375.dp)
                            .shadow(elevation = 4.dp, shape = RectangleShape)
                            .padding(20.dp)
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(text = stringResource(R.string.text_4),
                        textAlign = TextAlign.Center,
                        fontSize = 22.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = stringResource(R.string.name)  + stringResource(R.string.year_1),
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Button(onClick = { currentStep-- },
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp).width(150.dp)) {
                            Text(stringResource(R.string.previous))
                        }
                        Button(onClick = { currentStep++ },
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp).width(150.dp)) {
                            Text(stringResource(R.string.next))
                        }
                    }
                }
            }
            5 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Spacer(modifier = Modifier.height(125.dp))
                    Image(
                        painter = painterResource(R.drawable.image_5),
                        contentDescription = stringResource(R.string.content_description_5),
                        modifier = Modifier
                            .wrapContentSize()
                            .size(375.dp)
                            .shadow(elevation = 4.dp, shape = RectangleShape)
                            .padding(20.dp)
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(text = stringResource(R.string.text_5),
                        textAlign = TextAlign.Center,
                        fontSize = 22.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = stringResource(R.string.name)  + stringResource(R.string.year_2),
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Button(onClick = { currentStep-- },
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp).width(150.dp)) {
                            Text(stringResource(R.string.previous))
                        }
                        Button(enabled = false, onClick = { currentStep++ },
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp).width(150.dp)) {
                            Text(stringResource(R.string.next))
                        }
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}