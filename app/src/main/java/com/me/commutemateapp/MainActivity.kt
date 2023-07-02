package com.me.commutemateapp

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.me.commutemateapp.ui.theme.CommuteMateAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CommuteMateAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingBlock(message = getString(R.string.welcome_to_app_text), from = getString(R.string.app_name_text))
                }
            }
        }
    }
}

@Composable
fun GreetingBlock(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.logolarge)
    Column (modifier = modifier, verticalArrangement = Arrangement.Center) {
        Text(
            text = message,
            style = MaterialTheme.typography.titleLarge,
            color = Color(0, 191, 125),
            modifier = Modifier.padding(10.dp).align(alignment = Alignment.CenterHorizontally),
            fontSize = 40.sp
        )
        Image(
            painter = image,
            contentDescription = "Logo of CommuteMate application showing a house connected to a location pin by a path (half dotted line, half solid line) with two people in the middle of the path",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = from,
            style = MaterialTheme.typography.titleLarge,
            color = Color(0, 191, 125),
            modifier = Modifier.padding(4.dp).align(alignment = Alignment.CenterHorizontally),
            fontSize = 40.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CommuteMateAppTheme {
        GreetingBlock("Welcome to", "CommuteMate")
    }
}