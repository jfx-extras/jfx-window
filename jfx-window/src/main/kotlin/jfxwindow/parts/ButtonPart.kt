package jfxwindow.parts

import javafx.scene.control.Tooltip
import javafx.scene.input.MouseButton
import javafx.scene.paint.Color
import jfxwindow.base.WindowBase
import jfxwindow.enums.TitleBarTheme
import jfxwindow.helpers.changeRegionBackground
import jfxwindow.helpers.getBlackOrWhiteByColor
import jfxwindow.helpers.isCursorResize

/**
 *
 */
public class ButtonPart(private val windowBase: WindowBase) {
    private var tooltipIsEnabledHelper: Boolean = true
    private var maxButtonIsVisibleHelper: Boolean = true

    /**
     *
     */
    public var buttonHoverColor: Color = Color.color(0.0, 0.0, 0.0, 0.1)
    /**
     *
     */
    public var buttonPressedColor: Color = Color.color(0.0, 0.0, 0.0, 0.2)

    internal fun init(): Unit {
        initButtonExit()
        initButtonMaximize()
    }

    private fun initButtonExit(): Unit {
        windowBase.windowUi.win32CloseButton.setOnMouseClicked {
            if (!isCursorResize(windowBase.windowOptions.stage.scene.cursor) &&
                it.button == MouseButton.PRIMARY
            ) {
                windowBase.windowOptions.stage.close()
            }
        }

        windowBase.windowUi.win32CloseButton.setOnMouseEntered {
            if (windowBase.windowUi.win32CloseButton.isPressed) {
                changeRegionBackground(
                    windowBase.windowUi.win32CloseButton,
                    Color.web("#F1707A")
                )
                windowBase.windowUi.win32CloseIcon.fill = Color.web("#000")
            } else {
                changeRegionBackground(
                    windowBase.windowUi.win32CloseButton,
                    Color.web("#E81123")
                )
                windowBase.windowUi.win32CloseIcon.fill = Color.web("#fff")
            }
        }

        windowBase.windowUi.win32CloseButton.setOnMousePressed {
            if (!isCursorResize(windowBase.windowOptions.stage.scene.cursor) &&
                it.button == MouseButton.PRIMARY
            ) {
                changeRegionBackground(
                    windowBase.windowUi.win32CloseButton,
                    Color.web("#F1707A")
                )
                windowBase.windowUi.win32CloseIcon.fill = Color.web("#000")
            }
        }

        windowBase.windowUi.win32CloseButton.setOnMouseExited {
            changeRegionBackground(
                windowBase.windowUi.win32CloseButton,
                Color.TRANSPARENT
            )
            when {
                windowBase.titleBarPart.theme == TitleBarTheme.AUTO ->
                    windowBase.windowUi.win32CloseIcon.fill =
                        getBlackOrWhiteByColor(
                            windowBase.titleBarPart.titleBackground
                        )
                windowBase.titleBarPart.theme == TitleBarTheme.LIGHT ->
                    windowBase.windowUi.win32CloseIcon.fill = Color.WHITE
                windowBase.titleBarPart.theme == TitleBarTheme.DARK ->
                    windowBase.windowUi.win32CloseIcon.fill = Color.BLACK
            }
        }
    }

    private fun initButtonMaximize(): Unit {
        windowBase.windowUi.win32MaxButton.setOnMouseClicked {
            if (!isCursorResize(windowBase.windowOptions.stage.scene.cursor) &&
                it.button == MouseButton.PRIMARY
            ) {
                windowBase.windowOptions.stage.isMaximized = true
            }
        }

        windowBase.windowUi.win32MaxButton.setOnMouseEntered {
            if (windowBase.windowUi.win32MaxButton.isPressed) {
                changeRegionBackground(
                    windowBase.windowUi.win32MaxButton,
                    buttonPressedColor
                )
            } else {
                changeRegionBackground(
                    windowBase.windowUi.win32MaxButton,
                    buttonHoverColor
                )
            }
        }

        windowBase.windowUi.win32MaxButton.setOnMousePressed {
            if (!isCursorResize(windowBase.windowOptions.stage.scene.cursor) &&
                it.button == MouseButton.PRIMARY
            ) {
                changeRegionBackground(
                    windowBase.windowUi.win32MaxButton,
                    buttonPressedColor
                )
            }
        }

        windowBase.windowUi.win32MaxButton.setOnMouseExited {
            changeRegionBackground(
                windowBase.windowUi.win32MaxButton,
                Color.TRANSPARENT
            )
        }
    }

    internal fun applyButtonProperties() {
        applyButtonUnMaxProperties()
        applyButtonMinProperties()

        tooltipIsEnabled = windowBase.windowOptions.toolButtonsTooltipIsEnabled
    }

    private fun applyButtonUnMaxProperties() {
        windowBase.windowUi.win32UnMaxButton.setOnMouseClicked {
            if (it.button == MouseButton.PRIMARY) {
                windowBase.windowOptions.stage.isMaximized = false
            }
        }

        windowBase.windowUi.win32UnMaxButton.setOnMouseEntered {
            if (windowBase.windowUi.win32UnMaxButton.isPressed) {
                changeRegionBackground(
                    windowBase.windowUi.win32UnMaxButton,
                    buttonPressedColor
                )
            } else {
                changeRegionBackground(
                    windowBase.windowUi.win32UnMaxButton,
                    buttonHoverColor
                )
            }
        }

        windowBase.windowUi.win32UnMaxButton.setOnMouseExited {
            changeRegionBackground(
                windowBase.windowUi.win32UnMaxButton,
                Color.TRANSPARENT
            )
        }

        windowBase.windowUi.win32UnMaxButton.setOnMousePressed {
            if (it.button == MouseButton.PRIMARY) {
                changeRegionBackground(
                    windowBase.windowUi.win32UnMaxButton,
                    buttonPressedColor
                )
            }
        }
    }

    private fun applyButtonMinProperties() {
        windowBase.windowUi.win32MinButton.setOnMouseClicked {
            if (it.button == MouseButton.PRIMARY) {
                windowBase.windowOptions.stage.isIconified = true
            }
        }

        windowBase.windowUi.win32MinButton.setOnMouseEntered {
            if (windowBase.windowUi.win32MinButton.isPressed) {
                changeRegionBackground(
                    windowBase.windowUi.win32MinButton,
                    buttonPressedColor
                )
            } else {
                changeRegionBackground(
                    windowBase.windowUi.win32MinButton,
                    buttonHoverColor
                )
            }
        }

        windowBase.windowUi.win32MinButton.setOnMouseExited {
            changeRegionBackground(
                windowBase.windowUi.win32MinButton,
                Color.TRANSPARENT
            )
        }

        windowBase.windowUi.win32MinButton.setOnMousePressed {
            if (it.button == MouseButton.PRIMARY) {
                changeRegionBackground(
                    windowBase.windowUi.win32MinButton,
                    buttonPressedColor
                )
            }
        }
    }

    /**
     *
     */
    public var closeButtonIsVisible: Boolean
        get() = windowBase.windowUi.win32CloseButton.isVisible
        set(isVisible) {
            windowBase.windowUi.win32CloseButton.isVisible = isVisible
            windowBase.windowUi.win32CloseButton.isManaged = isVisible
        }

    /**
     *
     */
    public var maxButtonIsVisible: Boolean
        get() = maxButtonIsVisibleHelper
        set(isVisible) {
            maxButtonIsVisibleHelper = isVisible
            if (windowBase.windowOptions.stage.isMaximized) {
                windowBase.windowUi.win32UnMaxButton.isVisible = isVisible
                windowBase.windowUi.win32UnMaxButton.isManaged = isVisible
            } else {
                windowBase.windowUi.win32MaxButton.isVisible = isVisible
                windowBase.windowUi.win32MaxButton.isManaged = isVisible
            }
        }

    /**
     *
     */
    public var minButtonIsVisible: Boolean
        get() = windowBase.windowUi.win32MinButton.isVisible
        set(isVisible) {
            windowBase.windowUi.win32MinButton.isVisible = isVisible
            windowBase.windowUi.win32MinButton.isManaged = isVisible
        }

    /**
     *
     */
    public var tooltipIsEnabled: Boolean
        get() = tooltipIsEnabledHelper
        set(isEnabled) {
            tooltipIsEnabledHelper = if (isEnabled) {
                Tooltip.install(windowBase.windowUi.win32CloseButton, Tooltip("close"))
                Tooltip.install(windowBase.windowUi.win32MinButton, Tooltip("minimize"))
                Tooltip.install(windowBase.windowUi.win32UnMaxButton, Tooltip("restore down"))
                Tooltip.install(windowBase.windowUi.win32MaxButton, Tooltip("maximize"))
                true
            } else {
                Tooltip.uninstall(windowBase.windowUi.win32CloseButton, Tooltip("close"))
                Tooltip.uninstall(windowBase.windowUi.win32MinButton, Tooltip("minimize"))
                Tooltip.uninstall(windowBase.windowUi.win32UnMaxButton, Tooltip("restore down"))
                Tooltip.uninstall(windowBase.windowUi.win32MaxButton, Tooltip("maximize"))
                false
            }
        }
}
