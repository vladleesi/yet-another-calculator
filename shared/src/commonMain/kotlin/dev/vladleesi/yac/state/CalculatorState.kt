package dev.vladleesi.yac.state

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null,
    val isCalculationPerformed: Boolean = false
)
