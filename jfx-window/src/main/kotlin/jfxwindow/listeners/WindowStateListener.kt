package jfxwindow.listeners

import javafx.geometry.Insets
import javafx.scene.layout.BorderWidths
import javafx.stage.Screen
import jfxwindow.base.WindowOptions
import jfxwindow.base.WindowUi
import jfxwindow.parts.BorderPart
import jfxwindow.parts.WindowPart
import java.util.logging.Level
import java.util.logging.Logger

internal class WindowStateListener {
    private var borderChangeRestricted: Boolean = false
    @set:JvmSynthetic  @get:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowUiInstance: WindowUi
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var borderInstance: BorderPart
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowInstance: WindowPart

    @JvmSynthetic
    internal fun addWindowMaximizeListener() =
            windowOptionsInstance.stage.maximizedProperty().addListener { _,
                                                                          _,
                                                                          newValue ->
                windowUiInstance.win32MaxButton.isManaged = !newValue
                windowUiInstance.win32MaxButton.isVisible = !newValue
                windowUiInstance.win32UnMaxButton.isManaged = newValue
                windowUiInstance.win32UnMaxButton.isVisible = newValue

                borderOnState(newValue)

                if (newValue) {
                    windowOptionsInstance.stage.height = Screen.getPrimary().visualBounds.height

                    validateTrueMaximizing()

                    if (borderInstance.bottomBorderIsVisible) {
                        borderInstance.setBottomBorderIsVisible(BorderWidths(0.0, 0.0, 1.0, 0.0))
                    } else {
                        borderInstance.setBottomBorderIsVisible(BorderWidths(0.0))
                    }

                    windowInstance.isResizable = false
                } else {
                    if (borderInstance.bottomBorderIsVisible) {
                        borderInstance.setBottomBorderIsVisible(BorderWidths(1.0, 0.0, 1.0, 0.0))
                    } else {
                        borderInstance.setBottomBorderIsVisible(BorderWidths(1.0, 0.0, 0.0, 0.0))
                    }

                    borderInstance.borderIsVisible = borderInstance.borderIsVisible
                    windowInstance.isResizable = true
                }

                if (newValue) {
                    windowUiInstance.windowPane.padding = Insets(-18.0)
                } else {
                    windowUiInstance.windowPane.padding = Insets(0.0)
                }
            }

    @JvmSynthetic
    internal fun addWindowMinimizeListener() =
            windowOptionsInstance.stage.iconifiedProperty().addListener { _,
                                                                          _,
                                                                          newValue ->
                if (!newValue) {
                    if (windowOptionsInstance.stage.isMaximized) {
                        windowOptionsInstance.stage.height = Screen.getPrimary().visualBounds.height
                    }
                }
            }

    @JvmSynthetic
    internal fun addBorderChangeListener() {
        windowUiInstance.windowTitleBarPane.borderProperty().addListener { _,
                                                                           _,
                                                                           _ ->
            if (borderChangeRestricted) {
                if (borderInstance.bottomBorderIsVisible) {
                    borderInstance.setBottomBorderIsVisible(BorderWidths(0.0, 0.0, 1.0, 0.0))
                } else {
                    borderInstance.setBottomBorderIsVisible(BorderWidths(0.0))
                }
            }
        }
    }

    @JvmSynthetic
    internal fun borderOnState(remove: Boolean) {
        windowUiInstance.bottomBorder.isVisible = !remove
        windowUiInstance.bottomBorder.isManaged = !remove
        windowUiInstance.leftBorder.isVisible = !remove
        windowUiInstance.leftBorder.isManaged = !remove
        windowUiInstance.rightBorder.isVisible = !remove
        windowUiInstance.rightBorder.isManaged = !remove

        borderChangeRestricted = remove
    }

    private fun validateTrueMaximizing() {
        if (windowOptionsInstance.stage.x == 0.0 && windowOptionsInstance.stage.y == 0.0) return

        windowOptionsInstance.stage.x = 0.0
        windowOptionsInstance.stage.y = 0.0

        Logger.getLogger(WindowStateListener::class.java.name).log(
                Level.WARNING,
                "stage maximizing was finished with error, but the position has been corrected, you have nothing to worry about."
        )
    }
}