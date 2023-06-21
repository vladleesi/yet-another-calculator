package dev.vladleesi.yac.utils

import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSNumberFormatterScientificStyle

object iOSStringFormatter {
    fun format(format: String, double: Double): String {
        val formatter = NSNumberFormatter().apply {
            numberStyle = NSNumberFormatterScientificStyle
            positiveFormat = format
        }
        return formatter.stringFromNumber(NSNumber(double)) ?: double.toString()
    }
}