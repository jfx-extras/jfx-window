package jfxwindow.parts

import com.sun.javafx.cursor.CursorType
import com.sun.javafx.cursor.StandardCursorFrame
import javafx.geometry.Insets
import javafx.scene.control.Tooltip
import javafx.scene.input.MouseButton
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import jfxwindow.base.WindowOptions
import jfxwindow.base.WindowUi
import jfxwindow.helpers.WindowColorHelper.Companion.changeRegionBackground
import jfxwindow.helpers.WindowColorHelper.Companion.getCalculatedColor

class ButtonPart {
    lateinit var buttonHoverColor: Color
    lateinit var buttonPressedColor: Color
    private var exitIsEnabled: Boolean = true
    private var maxIsEnabled: Boolean = true
    private var unMaxIsEnabled: Boolean = true
    private var minIsEnabled: Boolean = true
    private var tooltipIsEnabledHelper: Boolean = true
    @get:JvmSynthetic @set:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions
    @get:JvmSynthetic @set:JvmSynthetic
    internal lateinit var windowUiInstance: WindowUi
    @get:JvmSynthetic @set:JvmSynthetic
    internal lateinit var titleBarPart: TitleBarPart

    @JvmSynthetic
    internal fun applyButtonProperties() {
        exitIsEnabled = windowOptionsInstance.isClosable
        maxIsEnabled = windowOptionsInstance.isMaximizable
        unMaxIsEnabled = windowOptionsInstance.isMaximizable
        minIsEnabled = windowOptionsInstance.isMinimizable

        applyTransparentButton()
        applyButtonExitProperties()
        applyButtonMaxProperties()
        applyButtonUnMaxProperties()
        applyButtonMinProperties()

        tooltipIsEnabled = windowOptionsInstance.toolButtonsTooltipIsEnabled
    }

    private fun applyTransparentButton() {
        windowUiInstance.win32CloseButton.backgroundProperty().value = (Background(BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)))
        windowUiInstance.win32MaxButton.backgroundProperty().value = (Background(BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)))
        windowUiInstance.win32UnMaxButton.backgroundProperty().value = (Background(BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)))
        windowUiInstance.win32MinButton.backgroundProperty().value = (Background(BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)))
    }

    private fun applyButtonExitProperties() {
        windowUiInstance.win32CloseButton.setOnMouseClicked {
            if (!StandardCursorFrame(CursorType.valueOf(windowOptionsInstance.stage.scene.cursor.toString())).cursorType.name.contains("RESIZE")) {
                if (it.button == MouseButton.PRIMARY) {
                    windowOptionsInstance.stage.close()
                }
            }
        }

        windowUiInstance.win32CloseButton.setOnMouseEntered {
            if (windowUiInstance.win32CloseButton.isPressed) {
                changeRegionBackground(windowUiInstance.win32CloseButton, Color.web("#F1707A"))
                windowUiInstance.win32CloseIcon.fill = Color.web("#000")
            } else {
                changeRegionBackground(windowUiInstance.win32CloseButton, Color.web("#E81123"))
                windowUiInstance.win32CloseIcon.fill = Color.web("#fff")
            }
        }

        windowUiInstance.win32CloseButton.setOnMouseExited {
            changeRegionBackground(windowUiInstance.win32CloseButton, Color.TRANSPARENT)
            windowUiInstance.win32CloseIcon.fill = getCalculatedColor(titleBarPart.titleBackground)
        }

        windowUiInstance.win32CloseButton.setOnMousePressed {
            if (!StandardCursorFrame(CursorType.valueOf(windowOptionsInstance.stage.scene.cursor.toString())).cursorType.name.contains("RESIZE")) {
                if (it.button == MouseButton.PRIMARY) {
                    changeRegionBackground(windowUiInstance.win32CloseButton, Color.web("#F1707A"))
                    windowUiInstance.win32CloseIcon.fill = Color.web("#000")
                }
            }
        }
    }

    private fun applyButtonMaxProperties() {
        windowUiInstance.win32MaxButton.setOnMouseClicked {
            if (it.button == MouseButton.PRIMARY) {
                windowOptionsInstance.stage.isMaximized = true
            }
        }

        windowUiInstance.win32MaxButton.setOnMouseEntered {
            if (windowUiInstance.win32MaxButton.isPressed) {
                changeRegionBackground(windowUiInstance.win32MaxButton, buttonPressedColor)
            } else {
                changeRegionBackground(windowUiInstance.win32MaxButton, buttonHoverColor)
            }
        }

        windowUiInstance.win32MaxButton.setOnMouseExited {
            changeRegionBackground(windowUiInstance.win32MaxButton, Color.TRANSPARENT)
        }

        windowUiInstance.win32MaxButton.setOnMousePressed {
            if (it.button == MouseButton.PRIMARY) {
                changeRegionBackground(windowUiInstance.win32MaxButton, buttonPressedColor)
            }
        }
    }

    private fun applyButtonUnMaxProperties() {
        windowUiInstance.win32UnMaxButton.setOnMouseClicked {
            if (it.button == MouseButton.PRIMARY) {
                windowOptionsInstance.stage.isMaximized = false
            }
        }

        windowUiInstance.win32UnMaxButton.setOnMouseEntered {
            if (windowUiInstance.win32UnMaxButton.isPressed) {
                changeRegionBackground(windowUiInstance.win32UnMaxButton, buttonPressedColor)
            } else {
                changeRegionBackground(windowUiInstance.win32UnMaxButton, buttonHoverColor)
            }
        }

        windowUiInstance.win32UnMaxButton.setOnMouseExited {
            changeRegionBackground(windowUiInstance.win32UnMaxButton, Color.TRANSPARENT)
        }

        windowUiInstance.win32UnMaxButton.setOnMousePressed {
            if (it.button == MouseButton.PRIMARY) {
                changeRegionBackground(windowUiInstance.win32UnMaxButton, buttonPressedColor)
            }
        }
    }

    private fun applyButtonMinProperties() {
        windowUiInstance.win32MinButton.setOnMouseClicked {
            if (it.button == MouseButton.PRIMARY) {
                windowOptionsInstance.stage.isIconified = true
            }
        }

        windowUiInstance.win32MinButton.setOnMouseEntered {
            if (windowUiInstance.win32MinButton.isPressed) {
                changeRegionBackground(windowUiInstance.win32MinButton, buttonPressedColor)
            } else {
                changeRegionBackground(windowUiInstance.win32MinButton, buttonHoverColor)
            }
        }

        windowUiInstance.win32MinButton.setOnMouseExited {
            changeRegionBackground(windowUiInstance.win32MinButton, Color.TRANSPARENT)
        }

        windowUiInstance.win32MinButton.setOnMousePressed {
            if (it.button == MouseButton.PRIMARY) {
                changeRegionBackground(windowUiInstance.win32MinButton, buttonPressedColor)
            }
        }
    }

    var closeButtonIsVisible: Boolean
        get() = windowUiInstance.win32CloseButton.isVisible
        set(isVisible) {
            windowUiInstance.win32CloseButton.isVisible = isVisible
            windowUiInstance.win32CloseButton.isManaged = isVisible
        }

    // todo: fix not correct behavior when changed maximized and when it false. lol
    var maxButtonIsVisible: Boolean
        get() = windowUiInstance.win32MaxButton.isVisible
        set(isVisible) {
            if (windowOptionsInstance.stage.isMaximized) {
                windowUiInstance.win32UnMaxButton.isVisible = isVisible
                windowUiInstance.win32UnMaxButton.isManaged = isVisible
            } else {
                windowUiInstance.win32MaxButton.isVisible = isVisible
                windowUiInstance.win32MaxButton.isManaged = isVisible
            }
        }

    var minButtonIsVisible: Boolean
        get() = windowUiInstance.win32MinButton.isVisible
        set(isVisible) {
            windowUiInstance.win32MinButton.isVisible = isVisible
            windowUiInstance.win32MinButton.isManaged = isVisible
        }

    var tooltipIsEnabled: Boolean
        get() = tooltipIsEnabledHelper
        set(isEnabled) {
            tooltipIsEnabledHelper = if (isEnabled) {
                Tooltip.install(windowUiInstance.win32CloseButton, Tooltip("close"))
                Tooltip.install(windowUiInstance.win32MinButton, Tooltip("minimize"))
                Tooltip.install(windowUiInstance.win32UnMaxButton, Tooltip("restore down"))
                Tooltip.install(windowUiInstance.win32MaxButton, Tooltip("maximize"))
                true
            } else {
                Tooltip.uninstall(windowUiInstance.win32CloseButton, Tooltip("close"))
                Tooltip.uninstall(windowUiInstance.win32MinButton, Tooltip("minimize"))
                Tooltip.uninstall(windowUiInstance.win32UnMaxButton, Tooltip("restore down"))
                Tooltip.uninstall(windowUiInstance.win32MaxButton, Tooltip("maximize"))
                false
            }
        }
}