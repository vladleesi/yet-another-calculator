package dev.vladleesi.yac

import androidx.compose.runtime.collectAsState
import androidx.compose.ui.window.ComposeUIViewController
import dev.vladleesi.yac.ui.CalculatorApp
import dev.vladleesi.yac.viewmodel.CalculatorViewModel

fun MainViewController() =
    ComposeUIViewController {
        // TODO: Will be destroyed with activity
        val viewModel = CalculatorViewModel()
        val state = viewModel.stateFlow.collectAsState()
        CalculatorApp(
            stateFlow = state,
            onAction = viewModel::onAction
        )
    }