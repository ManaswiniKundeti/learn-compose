package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    private val backgroundList = listOf(
        R.drawable.background,
        R.drawable.background1,
        R.drawable.background2
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyList(backgroundList)
        }
    }
}

@Composable
fun MyList(imageList: List<Int>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(imageList) { data ->
            val painter = painterResource(id = data)
            val description = "Image shows an amazing waterfall"
            val title = "Travel into the wild"
            Box(modifier = Modifier
                .fillMaxWidth(0.6f)
                .padding(16.dp)) {
                ImageCard(painter = painter, contentDescription = description, title = title)
            }
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter, // be able to use image from imageResources
    contentDescription: String,
    title: String,
    passedModifier: Modifier = Modifier
) {
    Card(
        modifier = passedModifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(130.dp)) { // each item inside  will be stacked
            Image(
                painter = painter, 
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            // if the background image is light the white colored text might not be visisble. So lets add graident.
            //Gradient can be applied using a modifier. So we need a box so that we can apply the required modifier to it
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 170f

                    )
                )
            )
            // for the text, create another box so that we can keep the text at the bottom
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }        
    }
    
}
    

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    val painter = painterResource(id = R.drawable.background2)
//    val description = "Image shows an amazing waterfall"
//    val title = "Travel into the wild"
//    Box(modifier = Modifier
//        .fillMaxWidth(0.5f)
//        .padding(16.dp)) {
//        ImageCard(painter = painter, contentDescription = description, title = title)
//    }
    val backgroundList = listOf(
        R.drawable.background,
        R.drawable.background1,
        R.drawable.background2
    )
    MyList(backgroundList)
}