package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImagePreview()
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(id = R.drawable.birthday)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message, from)
    }

}

@Composable
fun BirthdayGreetingWithText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
//            .wrapContentHeight(Alignment.CenterVertically)
            .padding(top = 128.dp)
    ) {
        val alike = FontFamily(
            Font(R.font.alike)
        )

        val daydream = FontFamily(
            Font(R.font.daydream)
        )
        Text(
            text = message,
            fontFamily = daydream,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 56.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, end = 15.dp)
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Text(
            text = from,
            fontFamily = alike,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, end = 15.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun BirthdayGreetingWithImagePreview() {
    BirthdayGreetingWithImage(
        message = stringResource(R.string.happy_birthday_text), from = stringResource(
            R.string.from_text
        )
    )
}