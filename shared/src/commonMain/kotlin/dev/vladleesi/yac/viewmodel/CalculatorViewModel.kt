package dev.vladleesi.yac.viewmodel

import dev.vladleesi.yac.state.CalculatorAction
import dev.vladleesi.yac.state.CalculatorOperation
import dev.vladleesi.yac.state.CalculatorState
import dev.vladleesi.yac.utils.stringFormat
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CalculatorViewModel {

    val stateFlow = MutableStateFlow(CalculatorState())

    private val state
        get() = stateFlow.value

    fun onAction(action: CalculatorAction) = runBlocking {
        launch {
            when (action) {
                is CalculatorAction.Number -> enterNumber(action.number)
                is CalculatorAction.Decimal -> enterDecimal()
                is CalculatorAction.Clear -> clear()
                is CalculatorAction.Operation -> enterOperation(action.operation)
                is CalculatorAction.Calculate -> performCalculation()
                is CalculatorAction.Delete -> performDeletion()
            }
        }
    }

    private suspend fun enterNumber(number: Int) {
        if (state.operation == null) {
            when {
                state.isCalculationPerformed -> {
                    stateFlow.emit(
                        state.copy(
                            number1 = number.toString(),
                            isCalculationPerformed = false
                        )
                    )
                    return
                }
                state.number1.length >= MAX_INPUT_LENGTH -> return
                else -> {
                    stateFlow.emit(state.copy(number1 = state.number1 + number))
                    return
                }
            }
        }
        if (state.number2.length >= MAX_INPUT_LENGTH) {
            return
        }
        stateFlow.emit(state.copy(number2 = state.number2 + number))
    }

    private suspend fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            stateFlow.emit(state.copy(number1 = state.number1 + "."))
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            stateFlow.emit(state.copy(number2 = state.number2 + "."))
        }
    }

    private suspend fun clear() {
        stateFlow.emit(CalculatorState())
    }

    private suspend fun enterOperation(operation: CalculatorOperation) {
        if (stateFlow.value.number1.isNotBlank()) {
            stateFlow.emit(stateFlow.value.copy(operation = operation))
        }
    }

    private suspend fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val resultDouble = when (state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                else -> return
            }
            stateFlow.emit(
                state.copy(
                    number1 = resultDouble.formatResult(),
                    number2 = "",
                    operation = null,
                    isCalculationPerformed = true
                )
            )
        }
    }

    private suspend fun performDeletion() {
        when {
            state.number2.isNotBlank() -> stateFlow.emit(
                state.copy(number2 = state.number2.dropLast(1))
            )

            state.operation != null -> stateFlow.emit(
                state.copy(operation = null)
            )

            state.number1.isNotBlank() -> stateFlow.emit(
                state.copy(number1 = state.number1.dropLast(1))
            )
        }
    }

    private fun Double.formatResult(): String {
        if (toString().contains(EXPONENTIAL)) {
            return stringFormat(EXPONENTIAL_NOTATION_PATTERN, this)
        }
        return if (hasDecimalPlaces()) {
            this.toString()
        } else {
            this.toInt().toString()
        }
    }

    private fun Double.hasDecimalPlaces(): Boolean {
        val decimalPlaces = toString().split(".").lastOrNull()?.toLongOrNull() ?: 0L
        return decimalPlaces > 0L
    }

    private companion object {
        private const val EXPONENTIAL = "E"
        private const val EXPONENTIAL_NOTATION_PATTERN = "0.0000000000E0"
        private const val MAX_INPUT_LENGTH = 8
    }
}
