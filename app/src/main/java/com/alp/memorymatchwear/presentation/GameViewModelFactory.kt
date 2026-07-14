package com.alp.memorymatchwear.presentation

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material.MaterialTheme
import com.alp.memorymatchwear.data.datasource.BestTimeDataSource
import com.alp.memorymatchwear.data.repository.BestTimeRepositoryImpl
import com.alp.memorymatchwear.domain.usecase.CheckMatchUseCase
import com.alp.memorymatchwear.domain.usecase.FlipCardUseCase
import com.alp.memorymatchwear.domain.usecase.GetBestTimeUseCase
import com.alp.memorymatchwear.domain.usecase.SaveBestTimeUseCase
import com.alp.memorymatchwear.domain.usecase.ShuffleBoardUseCase
import com.alp.memorymatchwear.presentation.board.BoardScreen
import com.alp.memorymatchwear.presentation.board.MemoryViewModel

class MemoryViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dataSource  = BestTimeDataSource(context)
        val repository  = BestTimeRepositoryImpl(dataSource)
        return MemoryViewModel(
            shuffleBoard = ShuffleBoardUseCase(),
            flipCard     = FlipCardUseCase(),
            checkMatch   = CheckMatchUseCase(),
            saveBestTime = SaveBestTimeUseCase(repository),
            getBestTime  = GetBestTimeUseCase(repository),
        ) as T
    }
}
 
class GameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm: MemoryViewModel = viewModel(
                factory = MemoryViewModelFactory(applicationContext)
            )
            MaterialTheme { BoardScreen(viewModel = vm) }
        }
    }
}
