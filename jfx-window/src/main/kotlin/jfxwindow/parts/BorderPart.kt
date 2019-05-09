package jfxwindow.parts

import javafx.geometry.Insets
import javafx.scene.layout.*
import javafx.scene.paint.Color
import jfxwindow.base.WindowBase

/**
 * Contains some methods and properties allowing to
 * work with the border of window.
 */
@Suppress("RedundantVisibilityModifier", "RedundantUnitReturnType")
public class BorderPart(private val windowBase: WindowBase) {
    private var borderIsVisibleHelper: Boolean = true
    internal var borderActiveColor: Color = Color.web("#707070")
    internal var borderChangeRestricted: Boolean = false
    private var borderWidths: BorderWidths = BorderWidths(1.0, 0.0, 0.0, 0.0)
    /**
     * Border fill color of unfocused application window color.
     */
    public var borderInactiveColor: Color = Color.web("#AAAAAA")

    private val backgroundFill: BackgroundFill by lazy {
        BackgroundFill(
            windowBase.windowOptions.borderColor,
            CornerRadii.EMPTY,
            Insets.EMPTY
        )
    }

    internal fun init(): Unit {
        windowBase.windowUi.windowTitleBarPane.border = (Border(
            BorderStroke(
                windowBase.windowOptions.borderColor,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths(1.0, 0.0, 0.0, 0.0)
            )
        ))
        windowBase.windowUi.leftBorder.background = (Background(
            backgroundFill
        ))
        windowBase.windowUi.rightBorder.background = (Background(
            backgroundFill
        ))
        windowBase.windowUi.bottomBorder.background = (Background(
            backgroundFill
        ))
        borderActiveColor = borderColor
        borderInactiveColor = windowBase.windowOptions.borderInactiveColor
        borderIsVisibleHelper = windowBase.windowOptions.borderIsVisible
        borderIsVisible = windowBase.windowOptions.borderIsVisible
        bottomBorderIsVisible = windowBase.windowOptions.borderIsVisible
        applyBorderInsets()
    }

    private fun applyBorderInsets(): Unit {
        borderWidths = if (windowBase.windowOptions.titleBarBottomBorderIsVisible) {
            BorderWidths(1.0, 0.0, 1.0, 0.0)
        } else {
            BorderWidths(1.0, 0.0, 0.0, 0.0)
        }
        bottomBorderIsVisible = windowBase.windowOptions.titleBarBottomBorderIsVisible
    }

    /**
     * Controlling bottom border of title-bar visibility.
     */
    public var bottomBorderIsVisible: Boolean
        get() {
            return borderWidths == BorderWidths(
                0.0, 0.0, 1.0, 0.0
            ) || borderWidths == BorderWidths(
                1.0,
                0.0,
                1.0,
                0.0
            )
        }
        set(isVisible) = if (isVisible) {
            if (borderIsVisible) {
                borderWidths = BorderWidths(1.0, 0.0, 1.0, 0.0)
                setBottomBorderIsVisible(borderWidths)
            } else {
                borderWidths = BorderWidths(0.0, 0.0, 1.0, 0.0)
                setBottomBorderIsVisible(borderWidths)
            }
        } else {
            if (borderIsVisible) {
                borderWidths = BorderWidths(1.0, 0.0, 0.0, 0.0)
                setBottomBorderIsVisible(borderWidths)
            } else {
                borderWidths = BorderWidths(0.0, 0.0, 0.0, 0.0)
                setBottomBorderIsVisible(borderWidths)
            }
        }

    /**
     * Border fill color of application window color.
     */
    public var borderColor: Color
        get() = Color.web(windowBase.windowUi.leftBorder.background.fills[0].fill.toString())
        set(color) {
            windowBase.windowUi.windowTitleBarPane.borderProperty().value = Border(
                BorderStroke(
                    color,
                    BorderStrokeStyle.SOLID,
                    CornerRadii.EMPTY,
                    borderWidths
                )
            )
            windowBase.windowUi.leftBorder.backgroundProperty().value =
                (Background(BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)))
            windowBase.windowUi.rightBorder.backgroundProperty().value =
                (Background(BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)))
            windowBase.windowUi.bottomBorder.backgroundProperty().value =
                (Background(BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)))
        }

    /**
     * Border visibility status of application window border.
     */
    public var borderIsVisible: Boolean
        get() = borderIsVisibleHelper
        set(isVisible) {
            if (!windowBase.windowOptions.stage.isMaximized) {
                borderOnState(!isVisible)

                if (isVisible) {
                    if (bottomBorderIsVisible) {
                        setBottomBorderIsVisible(
                            BorderWidths(1.0, 0.0, 1.0, 0.0)
                        )
                    } else {
                        setBottomBorderIsVisible(
                            BorderWidths(1.0, 0.0, 0.0, 0.0)
                        )
                    }
                } else {
                    if (bottomBorderIsVisible) {
                        setBottomBorderIsVisible(
                            BorderWidths(0.0, 0.0, 1.0, 0.0)
                        )
                    } else {
                        setBottomBorderIsVisible(BorderWidths(0.0))
                    }
                }
            }

            borderIsVisibleHelper = isVisible
        }

    internal fun setBottomBorderIsVisible(borderWidths: BorderWidths): Unit {
        windowBase.windowUi.windowTitleBarPane.border = Border(
            BorderStroke(
                windowBase.windowUi.windowTitleBarPane.border.strokes[0].topStroke,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                borderWidths
            )
        )
        this.borderWidths = borderWidths
    }

    internal fun borderOnState(remove: Boolean): Unit {
        windowBase.windowUi.bottomBorder.isVisible = !remove
        windowBase.windowUi.bottomBorder.isManaged = !remove
        windowBase.windowUi.leftBorder.isVisible = !remove
        windowBase.windowUi.leftBorder.isManaged = !remove
        windowBase.windowUi.rightBorder.isVisible = !remove
        windowBase.windowUi.rightBorder.isManaged = !remove
    }
}
