package jfxwindow.parts

import javafx.util.Duration
import jfxwindow.base.WindowBase
import jfxwindow.helpers.shadowPadding
import jfxwindow.helpers.shadowVertEdges
import jfxwindow.helpers.windowButtonCounts
import jfxwindow.helpers.windowButtonWidth
import jfxwindow.listeners.WindowDataListener
import kotlin.properties.Delegates.observable

/**
 * Contains some methods and properties allowing to
 * work with the window.
 */
@Suppress(
    "RedundantVisibilityModifier",
    "RedundantUnitReturnType",
    "MemberVisibilityCanBePrivate",
    "unused"
)
public class WindowPart(private val windowBase: WindowBase) {
    internal fun init(): Unit {
        isResizable = windowBase.windowOptions.isResizable
        isDraggable = windowBase.windowOptions.isDraggable
        isClosable = windowBase.windowOptions.isClosable
        isMaximizable = windowBase.windowOptions.isMaximizable
        isMinimizable = windowBase.windowOptions.isMinimizable
        animationDuration = windowBase.windowOptions.animationDuration
        smoothColorAnim = windowBase.windowOptions.smoothColorAnimation
        saveWindowPosition = windowBase.windowOptions.saveWindowPosition
    }

    /**
     * Default opacity value for window buttons.
     *
     * **NOTE: It value be used when some window button
     * enabled.**
     */
    public var defaultOpacity: Double by observable(1.0) { _,
                                                           _,
                                                           newValue ->
        if (newValue < 0.0 || newValue > 1.0) {
            throw IllegalArgumentException("Default transparency value should be no more than 1.0 and no less than 0.0")
        } else {
            if (isClosable) windowBase.windowUi.win32CloseButton.opacity = newValue
            if (isMaximizable) windowBase.windowUi.win32MaxButton.opacity = newValue
            if (isMinimizable) windowBase.windowUi.win32MinButton.opacity = newValue
        }
    }
    /**
     * Disabled opacity value for window buttons.
     *
     * **NOTE: It value be used when some window button
     * disabled.**
     */
    public var disabledOpacity: Double by observable(0.4) { _,
                                                            _,
                                                            newValue ->
        if (newValue < 0.0 || newValue > 1.0) {
            throw IllegalArgumentException("Disabled transparency value should be no more than 1.0 and no less than 0.0")
        } else {
            if (!isClosable) windowBase.windowUi.win32CloseButton.opacity = newValue
            if (!isMaximizable) windowBase.windowUi.win32MaxButton.opacity = newValue
            if (!isMinimizable) windowBase.windowUi.win32MinButton.opacity = newValue
        }
    }
    /**
     * Animation duration for background color changing
     * of title-bar zone.
     */
    public var animationDuration: Duration = Duration.millis(200.0)
    /**
     * Responsible for the animation when changing the
     * title-bar color.
     */
    public var smoothColorAnim: Boolean = true
    /**
     * Responsible for saving window position \ state \ size data.
     *
     * **WARN: Data saving in system temp directory!**
     */
    public var saveWindowPosition: Boolean
        get() = WindowDataListener.savePosIsEnabled
        set(isEnabled) {
            WindowDataListener.savePosIsEnabled = isEnabled
        }
    /**
     * Responsible for ability to resize window.
     *
     * **WARN: Disabling isResizable not responsible for
     * disabling isMaximizable, if you need fully disable
     * ability to resize then also disable isMaximizable.**
     */
    public var isResizable: Boolean by observable(true) { _,
                                                          _,
                                                          newValue ->
        windowBase.contextPart.forceDisableResize = !newValue
    }
    /**
     * Responsible for ability to move window in screen space.
     */
    public var isDraggable: Boolean by observable(true) { _,
                                                          _,
                                                          newValue ->
        windowBase.contextPart.forceDisableMove = !newValue
    }
    /**
     * Responsible for ability to maximize window.
     *
     * **NOTE: By default it parameter inherit stage
     * isMaximizable parameter.**
     */
    public var isMaximizable by observable(true) { _,
                                                   _,
                                                   newValue ->
        windowBase.windowUi.win32MaxButton.isDisable = !newValue
        windowBase.windowUi.win32UnMaxButton.isDisable = !newValue
        windowBase.contextPart.forceDisableMaximize = !newValue

        if (newValue) {
            windowBase.windowUi.win32MaxButton.opacity = defaultOpacity
            windowBase.windowUi.win32UnMaxButton.opacity = defaultOpacity
        } else {
            windowBase.windowUi.win32MaxButton.opacity = disabledOpacity
            windowBase.windowUi.win32UnMaxButton.opacity = disabledOpacity
        }
    }
    /**
     * Responsible for ability to minimize window.
     */
    public var isMinimizable by observable(true) { _,
                                                   _,
                                                   newValue ->
        windowBase.windowUi.win32MinButton.isDisable = !newValue
        windowBase.contextPart.forceDisableMinimize = !newValue

        if (newValue) {
            windowBase.windowUi.win32MinButton.opacity = defaultOpacity
        } else {
            windowBase.windowUi.win32MinButton.opacity = disabledOpacity
        }
    }
    /**
     * Responsible for ability to close window.
     */
    public var isClosable by observable(true) { _,
                                                _,
                                                newValue ->
        windowBase.windowUi.win32CloseButton.isDisable = !newValue
        windowBase.contextPart.forceDisableClose = !newValue

        if (newValue) {
            windowBase.windowUi.win32CloseButton.opacity = defaultOpacity
        } else {
            windowBase.windowUi.win32CloseButton.opacity = disabledOpacity
        }
    }

    /**
     * Sets stage minimal size by title-bar width.
     *
     * **NOTE: Minimal size not binging to it method
     * after every changing data in title-bar you need
     * re-calculate data and set again. Or set and binding
     * minimal size self - just use [getMinWidthSizeByTitleBar]
     * method.**
     */
    public fun setMinWidthSizeByTitleBar(): Unit {
        windowBase.windowOptions.stage.minWidth =
            ((windowButtonWidth * windowButtonCounts) + (shadowPadding * shadowVertEdges))
    }

    /**
     * Return calculated minimal size by title-bar width
     * for setting minimal size for stage.
     *
     * Use it if you needed often use it value
     * or binding to someone.
     *
     * @return min-width size as double value.
     */
    public fun getMinWidthSizeByTitleBar(): Double =
        ((windowButtonWidth * windowButtonCounts) + (shadowPadding * shadowVertEdges))
}
