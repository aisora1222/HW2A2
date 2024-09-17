package com.example.hw2a2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hw2a2.ui.theme.HW2A2Theme
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import java.util.Calendar

class MainActivity : ComponentActivity() {
    private var name = mutableStateOf("")
    private var greeting = mutableStateOf("")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HW2A2Theme { myGreeting(name, greeting) }
        }
    }
}

@Composable
fun myGreeting(name:MutableState<String>, greeting:MutableState<String>) {

    val greets =
        if (greeting.value.isNotEmpty() && name.value.isNotEmpty()) {
        greeting.value + name.value + "!"
    } else {
        greeting.value
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        TextField(
            value = name.value,
            onValueChange = {name.value = it},
            label = {Text("Enter Your Name")},

        )
        Button(
            onClick = {
                if (name.value.isNotEmpty()) {
                    greeting.value = greetingByTime()
                } else {
                    greeting.value = "Please Enter Your Name"
                }
            },
            modifier = Modifier.padding(20.dp)
        ) {
            Text("Push Me!")
        }

        Text(text= greets, style = MaterialTheme.typography.bodyLarge)

    }

}

fun greetingByTime():String{
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    if (0 < hour && hour <  12){
            return "Good Morning, "

    }else{
        return "Good Afternoon, "
    }

}

