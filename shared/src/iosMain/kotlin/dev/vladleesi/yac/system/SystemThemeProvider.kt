package dev.vladleesi.yac.system

import platform.UIKit.UITraitCollection
import platform.UIKit.UIUserInterfaceStyle
import platform.UIKit.currentTraitCollection

object SystemThemeProvider {
    fun isDarkThemeEnabled(): Boolean =
        UITraitCollection.currentTraitCollection().userInterfaceStyle ==
                UIUserInterfaceStyle.UIUserInterfaceStyleDark
}
