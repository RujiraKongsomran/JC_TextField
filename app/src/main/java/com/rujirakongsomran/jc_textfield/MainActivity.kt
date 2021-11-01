package com.rujirakongsomran.jc_textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rujirakongsomran.jc_textfield.ui.theme.JC_TextFieldTheme
import com.rujirakongsomran.jc_textfield.ui.theme.color1
import com.rujirakongsomran.jc_textfield.ui.theme.color2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_TextFieldTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Login()
                }
            }
        }
    }
}

@Composable
fun SimpleFilledTextFieldSample() {
    var text by remember { mutableStateOf("Hello") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(text = "Label") }
    )
}

@Composable
fun SimpleOutlinedTextFieldSample() {
    var text by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(text = "Label") }
    )
}

@Composable
fun StyledTextField() {
    var value by remember {
        mutableStateOf("Hello\nWorld\nInvisible")
    }
    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Enter text") },
        maxLines = 3,
        textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(20.dp)
    )
}

@Composable
fun PasswordTextField() {
    var password by remember {
        mutableStateOf("")
    }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Enter password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
fun GradientButton(
    text: String,
    textColor: Color,
    gradient: Brush,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        contentPadding = PaddingValues(),
        onClick = { onClick() }
    ) {
        Box(
            modifier = Modifier
                .background(gradient)
                .padding(
                    horizontal = 120.dp,
                    vertical = 14.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = textColor)
        }
    }
}

@Composable
fun Login() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // TextField username
        var username by remember {
            mutableStateOf("Enter username")
        }

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Label") }
        )

        // TextField Password

        var password by remember {
            mutableStateOf("")
        }
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Button Login
        GradientButton(
            text = "Login",
            textColor = Color.White,
            gradient = Brush.horizontalGradient(
                colors = listOf(
                    color1,
                    color2
                )
            )
        ) {

        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JC_TextFieldTheme {
        Login()
    }
}