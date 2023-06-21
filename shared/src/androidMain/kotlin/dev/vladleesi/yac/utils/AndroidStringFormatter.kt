package dev.vladleesi.yac.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

actual fun stringFormat(format: String, double: Double): String {
    val symbols: DecimalFormatSymbols = DecimalFormatSymbols.getInstance().apply {
        exponentSeparator = "E"
    }
    val decimalFormat = DecimalFormat(format, symbols)
    return decimalFormat.format(double)
}