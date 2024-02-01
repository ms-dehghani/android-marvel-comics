package ir.training.marvelcomics.main.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ir.training.marvelcomics.main.navigation.MainApp
import ir.training.marvelcomics.main.viewmodel.comic.list.ComicListViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ComicListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}