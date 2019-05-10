@file:Suppress("RedundantUnitReturnType")

package jfxwindow.helpers

import javafx.geometry.Pos
import javafx.stage.Screen
import jfxwindow.base.WindowBase

internal fun installInitMaximizing(windowBase: WindowBase): Unit {
    if (windowBase.windowOptions.stage.isMaximized) {
        val screen = Screen.getPrimary()
        val bounds = screen.visualBounds

        windowBase.windowOptions.stage.x = bounds.minX
        windowBase.windowOptions.stage.y = bounds.minY
        windowBase.windowOptions.stage.width = bounds.width
        windowBase.windowOptions.stage.height = bounds.height

        windowBase.windowUi.buttonContainer.alignment = Pos.CENTER_RIGHT
        windowBase.windowUi.win32MaxButton.isManaged = false
        windowBase.windowUi.win32MaxButton.isVisible = false
    } else {
        windowBase.windowUi.win32UnMaxButton.isManaged = false
        windowBase.windowUi.win32UnMaxButton.isVisible = false
    }
}
