package dev.vladleesi.yac.utils

actual fun stringFormat(format: String, double: Double): String =
    iOSStringFormatter.format(format, double)