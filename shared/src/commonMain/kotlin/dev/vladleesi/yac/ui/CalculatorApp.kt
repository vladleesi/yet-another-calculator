package dev.vladleesi.yac.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vladleesi.yac.resources.icon.rememberBackspace
import dev.vladleesi.yac.state.CalculatorAction
import dev.vladleesi.yac.state.CalculatorOperation
import dev.vladleesi.yac.state.CalculatorState
import dev.vladleesi.yac.system.isDarkThemeEnabled
import dev.vladleesi.yac.ui.component.CalculatorImageButton
import dev.vladleesi.yac.ui.component.CalculatorTextButton
import dev.vladleesi.yac.ui.style.orange
import dev.vladleesi.yac.ui.style.textColorBlack
import dev.vladleesi.yac.ui.style.textColorWhite

@Composable
fun CalculatorApp(
    stateFlow: State<CalculatorState>,
    onAction: (CalculatorAction) -> Unit
) {
    val state = stateFlow.value
    val buttonsSpacing = 8.dp
    val backgroundColor = getBackgroundColor()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(buttonsSpacing)
            ) {
                Text(
                    text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    color = getTextColor(),
                    fontSize = 64.sp,
                    maxLines = 2
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonsSpacing)
                ) {
                    CalculatorTextButton(
                        symbol = "AC",
                        textColor = orange,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Clear) }
                    CalculatorTextButton(
                        symbol = "+/-",
                        textColor = orange,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { }
                    CalculatorTextButton(
                        symbol = "%",
                        textColor = orange,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { }
                    CalculatorTextButton(
                        symbol = "÷",
                        textSize = 40.sp,
                        textColor = orange,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Operation(CalculatorOperation.Divide)) }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonsSpacing)
                ) {
                    CalculatorTextButton(
                        symbol = "7",
                        textColor = getTextColor(),
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Number(7)) }
                    CalculatorTextButton(
                        symbol = "8",
                        textColor = getTextColor(),
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Number(8)) }
                    CalculatorTextButton(
                        symbol = "9",
                        textColor = getTextColor(),
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Number(9)) }
                    CalculatorTextButton(
                        symbol = "×",
                        textSize = 40.sp,
                        textColor = orange,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Operation(CalculatorOperation.Multiply)) }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonsSpacing)
                ) {
                    CalculatorTextButton(
                        symbol = "4",
                        textColor = getTextColor(),
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Number(4)) }
                    CalculatorTextButton(
                        symbol = "5",
                        textColor = getTextColor(),
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Number(5)) }
                    CalculatorTextButton(
                        symbol = "6",
                        textColor = getTextColor(),
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Number(6)) }
                    CalculatorTextButton(
                        symbol = "-",
                        textSize = 40.sp,
                        textColor = orange,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Operation(CalculatorOperation.Subtract)) }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonsSpacing)
                ) {
                    CalculatorTextButton(
                        symbol = "1",
                        textColor = getTextColor(),
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Number(1)) }
                    CalculatorTextButton(
                        symbol = "2",
                        textColor = getTextColor(),
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Number(2)) }
                    CalculatorTextButton(
                        symbol = "3",
                        textColor = getTextColor(),
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Number(3)) }
                    CalculatorTextButton(
                        symbol = "+",
                        textSize = 40.sp,
                        textColor = orange,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Operation(CalculatorOperation.Add)) }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonsSpacing)
                ) {
                    CalculatorTextButton(
                        symbol = "0",
                        textColor = getTextColor(),
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Number(0)) }
                    CalculatorTextButton(
                        symbol = ".",
                        textColor = getTextColor(),
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Decimal) }
                    CalculatorImageButton(
                        imageVector = rememberBackspace(),
                        tintColor = orange,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Delete) }
                    CalculatorTextButton(
                        symbol = "=",
                        textColor = Color.White,
                        textSize = 40.sp,
                        modifier = Modifier
                            .background(orange)
                            .aspectRatio(1f)
                            .weight(1f)
                    ) { onAction(CalculatorAction.Calculate) }
                }
            }
        }
    }
}

@Composable
private fun getBackgroundColor() =
    if (isDarkThemeEnabled()) {
        Color.Black
    } else {
        Color.White
    }

@Composable
private fun getTextColor() =
    if (isDarkThemeEnabled()) {
        textColorWhite
    } else {
        textColorBlack
    }