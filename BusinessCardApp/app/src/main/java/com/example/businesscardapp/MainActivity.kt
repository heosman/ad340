package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(name = "Hanan Osman", title = "Student & Small Business Owner", phone = "206-665-4655", email = "hanaaneooo@gmail.com")
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, title: String, phone: String, email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(0xFFA1AFA6)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
                .padding(bottom = 70.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = modifier.fillMaxWidth().padding(horizontal = 5.dp, vertical = 5.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                val me = painterResource(id = R.drawable.me)
                Image(
                    painter = me,
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp).size(150.dp).clip(
                        RoundedCornerShape(100.dp)
                ))
            }
            Row(
                modifier = modifier.fillMaxWidth().padding(horizontal = 5.dp, vertical = 5.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name,
                    fontSize = 25.sp,
                    lineHeight = 40.sp,
                    textAlign = TextAlign.Center
                )
            }
            Row(
                modifier = modifier.fillMaxWidth().padding(horizontal = 5.dp, vertical = 5.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    lineHeight = 40.sp,
                    textAlign = TextAlign.Center
                )
            }
            Row(
                modifier = modifier.fillMaxWidth().padding(top = 100.dp).padding(start = 100.dp).padding(vertical = 5.dp),
            ) {
                val phoneImage = painterResource(id = R.drawable.phone)
                Image(
                    painter = phoneImage,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 10.dp).size(25.dp)
                )
                Text(
                    text = phone,
                    fontSize = 16.sp,
                    lineHeight = 40.sp,
                    textAlign = TextAlign.Center
                )
            }
            Row(
                modifier = modifier.fillMaxWidth().padding(start = 100.dp).padding(vertical = 5.dp)
            ) {
                val emailImage = painterResource(id = R.drawable.email)
                Image(
                    painter = emailImage,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 10.dp).size(25.dp)
                )
                Text(
                    text = email,
                    fontSize = 16.sp,
                    lineHeight = 40.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCard(name = "Hanan Osman", title = "Student & Small Business Owner", phone = "206-665-4655", email = "hanaaneooo@gmail.com")
    }
}