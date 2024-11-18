package com.vegcale.jetpackcomposestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vegcale.jetpackcomposestudy.ui.theme.JetpackComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeStudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OptimizationTestScreen()
                }
            }
        }
    }
}

@Composable
private fun OptimizationTestScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(60.dp)
    ) {
        NotOptimized()

        Optimized()
    }
}

@Composable
private fun NotOptimized() {
    Column(
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        var text by rememberSaveable { mutableStateOf("") }

        TextField(
            value = text,
            onValueChange = {
                text = it
            }
        )

        Text(
            text = "関係ない文字列"
        )
    }
}


@Composable
private fun Optimized() {
    Column {
        var text by rememberSaveable { mutableStateOf("編集する文字列") }

        OptimizedTextField(
            value = { text },
            onValueChanged = { newText ->
                text = newText
            }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "関係ない文字列"
        )
    }
}

@Composable
private fun OptimizedTextField(
    value: () -> String,
    onValueChanged: (String) -> Unit,
) {
    TextField(
        value = value(),
        onValueChange = onValueChanged
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeStudyTheme {
        OptimizationTestScreen()
    }
}