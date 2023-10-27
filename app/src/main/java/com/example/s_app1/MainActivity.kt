package com.example.s_app1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.s_app1.ui.theme.SApp1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SApp1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard(){
    val ButtonClickedState= remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card (modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(4.dp)

        ){
            Column (modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally){
                CreatImageProfile()
                Divider()
                CreatInfo()
                Button(onClick = {
                    ButtonClickedState.value= !ButtonClickedState.value
                }) {
                    Text(text = "protfolio",
                        style = MaterialTheme.typography.bodyLarge)
                    
                }


            }
            if (ButtonClickedState.value){
                Content()

            }else{
                Box {

                }
            }


        }

    }
}
@Preview
@Composable
fun Content(){
    Box (modifier = Modifier
        .padding(5.dp)
        .fillMaxHeight()
        .fillMaxWidth()){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(2.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray),
            color = Color.White
        ) {
            portfilio(data = listOf("project1","project2","project3","project4","project5","project6"))

        }
    }

}
@Composable
fun portfilio(data: List<String>) {
LazyColumn{
    items(data){item ->
        Card(modifier = Modifier
            .padding(13.dp)
            .fillMaxWidth(),
            shape = RectangleShape,
            colors = CardDefaults.cardColors(Color.White)
            ) {
            Row (modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .padding(8.dp)){

                CreatImageProfile(modifier = Modifier.size(100.dp).align(alignment = Alignment.CenterVertically))
                Column (modifier = Modifier.padding(7.dp)){
                    Text(text = item, fontWeight = FontWeight.Bold)
                    Text(text = "agreet project",
                        style = MaterialTheme.typography.bodyMedium)
                }


            }

        }

    }

}
}

@Composable
private fun CreatInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Miles P.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.outlineVariant
        )
        Text(
            text = "Jetback compose Programmer",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "@themlisCompose",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(3.dp)
        )


    }
}

@Composable
private fun CreatImageProfile(modifier: Modifier=Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(15.dp),
        shape = CircleShape,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
        border = BorderStroke(width = 0.5.dp, color = Color.LightGray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ma), contentDescription = "profile Image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SApp1Theme {
        CreateBizCard()
    }
}