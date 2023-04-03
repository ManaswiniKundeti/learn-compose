package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        // Modifier functions are applied sequentially
        modifier = Modifier
            .background(Color.Magenta)
            .fillMaxHeight(0.5f)
//            .width(600.dp)
            .fillMaxWidth()
            .border(width = 5.dp, color = Color.Green)
            .padding(top = 5.dp)
//            .border(width = 5.dp, color = Color.Blue)
//            .padding(top = 5.dp)
//            .border(width = 10.dp, color = Color.Red)
//            .padding(top = 10.dp)
    ) {
        // JC doesn't have conceot of margins. We make do stuff here more efficiently using padding & offsets
        // first element in offset is the horizontal offset,followed by vertical offset
        Text(text = "Hello $name!", modifier = Modifier
            .offset(10.dp, 30.dp)
            .clickable {

            }
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "How was your day?", modifier = Modifier.padding(5.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Manu")
    }
}