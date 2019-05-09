package jfxwindow.listeners

import javafx.geometry.Insets
import javafx.scene.layout.BorderWidths
import javafx.stage.Screen
import jfxwindow.base.WindowBase

@Suppress("RedundantUnitReturnType")
internal class WindowMaximizeListener(private val windowBase: WindowBase) {
    private var isResizableHelper: Boolean = false

    internal fun init(): Unit {
        windowBase.windowOptions.stage.maximizedProperty().addListener { _,
                                                                         _,
                                                                         newValue ->
            windowBase.windowUi.win32MaxButton.isManaged = !newValue
            windowBase.windowUi.win32MaxButton.isVisible = !newValue
            windowBase.windowUi.win32UnMaxButton.isManaged = newValue
            windowBase.windowUi.win32UnMaxButton.isVisible = newValue

            windowBase.borderPart.borderOnState(newValue)
            windowBase.borderPart.borderChangeRestricted = newValue

            if (newValue) {
                windowBase.windowUi.windowPane.padding = Insets(-18.0)
                windowBase.windowOptions.stage.height = Screen.getPrimary().visualBounds.height

                if (windowBase.borderPart.bottomBorderIsVisible) {
                    windowBase.borderPart.setBottomBorderIsVisible(BorderWidths(0.0, 0.0, 1.0, 0.0))
                } else {
                    windowBase.borderPart.setBottomBorderIsVisible(BorderWidths(0.0))
                }

                isResizableHelper = windowBase.windowPart.isResizable
                windowBase.windowPart.isResizable = false
                validateMaximizing()
            } else {
                windowBase.windowUi.windowPane.padding = Insets(0.0)
                if (windowBase.borderPart.bottomBorderIsVisible) {
                    windowBase.borderPart.setBottomBorderIsVisible(BorderWidths(1.0, 0.0, 1.0, 0.0))
                } else {
                    windowBase.borderPart.setBottomBorderIsVisible(BorderWidths(1.0, 0.0, 0.0, 0.0))
                }

                windowBase.borderPart.borderIsVisible = windowBase.borderPart.borderIsVisible
                windowBase.windowPart.isResizable = isResizableHelper
            }

            if (!windowBase.buttonPart.maxButtonIsVisible) {
                windowBase.windowUi.win32MaxButton.isManaged = false
                windowBase.windowUi.win32MaxButton.isVisible = false
                windowBase.windowUi.win32UnMaxButton.isManaged = false
                windowBase.windowUi.win32UnMaxButton.isVisible = false
            }
        }
    }

    private fun validateMaximizing(): Unit {
        if (windowBase.windowOptions.stage.x == 0.0 &&
            windowBase.windowOptions.stage.y == 0.0
        ) return

        windowBase.windowOptions.stage.x = 0.0
        windowBase.windowOptions.stage.y = 0.0
    }
}
