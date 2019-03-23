package jfxwindow.parts

import javafx.geometry.Insets
import javafx.scene.layout.*
import javafx.scene.paint.Color
import jfxwindow.base.WindowOptions
import jfxwindow.base.WindowUi
import jfxwindow.listeners.WindowStateListener

class BorderPart {
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowUiInstance: WindowUi
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var stateListener: WindowStateListener
    @set:JvmSynthetic @get:JvmSynthetic
    internal var borderIsVisibleHelper: Boolean = true
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var borderActiveColor: Color
    lateinit var borderInactiveColor: Color
    private var borderWidths: BorderWidths = BorderWidths(1.0, 0.0, 0.0, 0.0)

    @JvmSynthetic
    internal fun applyBorderProperties() {
        windowUiInstance.windowTitleBarPane.border = (Border(BorderStroke(windowOptionsInstance.borderColor, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths(1.0, 0.0, 0.0, 0.0))))
        windowUiInstance.leftBorder.background = (Background(BackgroundFill(windowOptionsInstance.borderColor, CornerRadii.EMPTY, Insets.EMPTY)))
        windowUiInstance.rightBorder.background = (Background(BackgroundFill(windowOptionsInstance.borderColor, CornerRadii.EMPTY, Insets.EMPTY)))
        windowUiInstance.bottomBorder.background = (Background(BackgroundFill(windowOptionsInstance.borderColor, CornerRadii.EMPTY, Insets.EMPTY)))
        borderIsVisible = windowOptionsInstance.borderIsVisible
        borderActiveColor = borderColor
        borderInactiveColor = windowOptionsInstance.borderInactiveColor
        bottomBorderIsVisible = windowOptionsInstance.borderIsVisible
        applyBorderInsets()
    }

    var bottomBorderIsVisible: Boolean
        get() {
            return borderWidths == BorderWidths(0.0, 0.0, 1.0, 0.0) || borderWidths == BorderWidths(1.0, 0.0, 1.0, 0.0)
        }
        set(isVisible) = if (isVisible) {
            borderWidths = BorderWidths(1.0, 0.0, 1.0, 0.0)
            setBottomBorderIsVisible(BorderWidths(1.0, 0.0, 1.0, 0.0))
        } else {
            borderWidths = BorderWidths(1.0, 0.0, 0.0, 0.0)
            setBottomBorderIsVisible(BorderWidths(1.0, 0.0, 0.0, 0.0))
        }

    var borderColor: Color
        get() = Color.web(windowUiInstance.leftBorder.background.fills[0].fill.toString())
        set(color) {
            windowUiInstance.windowTitleBarPane.borderProperty().value = Border(BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, borderWidths))
            windowUiInstance.leftBorder.backgroundProperty().value = (Background(BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)))
            windowUiInstance.rightBorder.backgroundProperty().value = (Background(BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)))
            windowUiInstance.bottomBorder.backgroundProperty().value = (Background(BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)))
        }

    var borderIsVisible: Boolean
        get() = borderIsVisibleHelper
        set(isVisible) {
            if (!windowOptionsInstance.stage.isMaximized) {
                stateListener.borderOnState(!isVisible)

                if (isVisible) {
                    if (bottomBorderIsVisible) {
                        setBottomBorderIsVisible(BorderWidths(1.0, 0.0, 1.0, 0.0))
                    } else {
                        setBottomBorderIsVisible(BorderWidths(1.0, 0.0, 0.0, 0.0))
                    }
                } else {
                    if (bottomBorderIsVisible) {
                        setBottomBorderIsVisible(BorderWidths(0.0, 0.0, 1.0, 0.0))
                    } else {
                        setBottomBorderIsVisible(BorderWidths(0.0))
                    }
                }
            }

            borderIsVisibleHelper = isVisible
        }

    private fun applyBorderInsets() = if (windowOptionsInstance.titleBarBottomBorderIsVisible) {
        borderWidths = BorderWidths(1.0, 0.0, 1.0, 0.0)
        bottomBorderIsVisible = windowOptionsInstance.titleBarBottomBorderIsVisible
    } else {
        borderWidths = BorderWidths(1.0, 0.0, 0.0, 0.0)
        bottomBorderIsVisible = windowOptionsInstance.titleBarBottomBorderIsVisible
    }

    @JvmSynthetic
    internal fun setBottomBorderIsVisible(borderWidths: BorderWidths) {
        windowUiInstance.windowTitleBarPane.border = Border(BorderStroke(windowUiInstance.windowTitleBarPane.border.strokes[0].topStroke, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, borderWidths))
        this.borderWidths = borderWidths
    }
}