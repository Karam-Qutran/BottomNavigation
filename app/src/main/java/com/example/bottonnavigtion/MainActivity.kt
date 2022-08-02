package com.example.bottonnavigtion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottonnavigtion.ui.theme.BottonNavigtionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBottomNavigation()
        }
    }
}

@Composable
fun MyBottomNavigation() {

    var bottomState by remember {
        mutableStateOf("Home")
    }
    Scaffold(
        content = {
                  Box(
                      modifier = Modifier
                          .fillMaxSize(),
                  Alignment.Center) {
                      Text(text = bottomState,
                      fontSize = 25.sp,
                      fontWeight = FontWeight.Bold
                      )
                  }
        },
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
                backgroundColor = Color(0xFFFEDBD0),
                contentColor = Color(0xFF442c2E)
            ) {
                BottomNavigationItem(
                    selected = bottomState == "Home" ,
                    onClick = { bottomState = "Home"},
                    label = { Text(text = "Home")},
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null)}
                )

                BottomNavigationItem(
                    selected = bottomState == "Account" ,
                    onClick = { bottomState = "Account"},
                    label = { Text(text = "Account")},
                    icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)}
                )
                BottomNavigationItem(
                    selected = bottomState == "Search" ,
                    onClick = { bottomState = "Search"},
                    label = { Text(text = "Search")},
                    icon = { Icon(imageVector = Icons.Default.Search, contentDescription = null)}
                )
                BottomNavigationItem(
                    selected = bottomState == "Setting" ,
                    onClick = { bottomState = "Setting"},
                    label = { Text(text = "Setting")},
                    icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = null)}
                )

            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyBottomNavigation()
}