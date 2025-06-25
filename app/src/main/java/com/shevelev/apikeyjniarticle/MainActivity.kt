package com.shevelev.apikeyjniarticle

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.shevelev.apikeyjniarticle.ui.theme.ApiKeyJNIArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApiKeyJNIArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val key = ApiKeyExtractor().getKey()
                    Log.d("API_KEY", key)

                    Text(
                        text = "Our key is: $key",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
