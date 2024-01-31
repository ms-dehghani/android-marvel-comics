package ir.training.marvelcomics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ir.training.marvelcomics.main.view.theme.MarvelComicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelComicsTheme {
            }
        }
    }
}