package jfxwindow.parts

import javafx.util.Duration
import jfxwindow.base.WindowBase
import jfxwindow.base.WindowOptions
import jfxwindow.base.WindowUi
import jfxwindow.listeners.WindowDataListener
import kotlin.properties.Delegates.observable

/**
 * It class contains variables for controlling window state,
 * (e.g: [defaultOpacity], [smoothColorAnim] and others ...)
 */
class WindowPart {
    @get:JvmSynthetic @set:JvmSynthetic
    internal lateinit var windowUiInstance: WindowUi
    @get:JvmSynthetic @set:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions
    @get:JvmSynthetic @set:JvmSynthetic
    internal lateinit var windowBaseInstance: WindowBase
    @get:JvmSynthetic @set:JvmSynthetic
    internal lateinit var contextPart: ContextPart
    @get:JvmSynthetic @set:JvmSynthetic
    internal var useMinSizeAsContentSizeHelper: Boolean = false

    var defaultOpacity: Double by observable(1.0) { _, oldValue, newValue ->
        if (newValue < 0.0 || newValue > 1.0) {
            throw IllegalArgumentException("Default transparency value should be no more than 1.0 and no less than 0.0")
        } else {
            if (isClosable) {
                windowUiInstance.win32CloseButton.opacity = newValue
            }

            if (isMaximizable) {
                windowUiInstance.win32MaxButton.opacity = newValue
            }

            if (isMinimizable) {
                windowUiInstance.win32MinButton.opacity = newValue
            }
        }
    }
    var disabledOpacity: Double by observable(0.4) { _, oldValue, newValue ->
        if (newValue < 0.0 || newValue > 1.0) {
            throw IllegalArgumentException("Disabled transparency value should be no more than 1.0 and no less than 0.0")
        } else {
            if (!isClosable) {
                windowUiInstance.win32CloseButton.opacity = newValue
            }

            if (!isMaximizable) {
                windowUiInstance.win32MaxButton.opacity = newValue
            }

            if (!isMinimizable) {
                windowUiInstance.win32MinButton.opacity = newValue
            }
        }
    }
    var animationDuration: Duration = Duration.millis(200.0)
    var smoothColorAnim: Boolean = true
    var saveWindowPosition: Boolean
        get() = WindowDataListener.savePosIsEnabled
        set(isEnabled) {
            WindowDataListener.savePosIsEnabled = isEnabled
        }
    var isResizable: Boolean by observable(true) { _, _, newValue ->
        contextPart.forceDisableResize = !newValue

//        if (isMaximizable && !newValue) {
//            isMaximizableOldValueHelper = isMaximizable
//            isMaximizable = false
//        } else {
//            isMaximizable = isMaximizableOldValueHelper
//        }
    }
    var isDraggable: Boolean by observable(true) { _, _, newValue ->
        contextPart.forceDisableMove = !newValue
    }
    var isMaximizable by observable(true) { _, _, newValue ->
        windowUiInstance.win32MaxButton.isDisable = !newValue
        windowUiInstance.win32UnMaxButton.isDisable = !newValue
        contextPart.forceDisableMaximize = !newValue

        if (newValue) {
            windowUiInstance.win32MaxButton.opacity = defaultOpacity
            windowUiInstance.win32UnMaxButton.opacity = defaultOpacity
        } else {
            windowUiInstance.win32MaxButton.opacity = disabledOpacity
            windowUiInstance.win32UnMaxButton.opacity = disabledOpacity
        }
    }
    var isMinimizable by observable(true) { _, _, newValue ->
        windowUiInstance.win32MinButton.isDisable = !newValue
        contextPart.forceDisableMinimize = !newValue

        if (newValue) {
            windowUiInstance.win32MinButton.opacity = defaultOpacity
        } else {
            windowUiInstance.win32MinButton.opacity = disabledOpacity
        }
    }
    var isClosable by observable(true) { _, _, newValue ->
        windowUiInstance.win32CloseButton.isDisable = !newValue
        contextPart.forceDisableClose = !newValue

        if (newValue) {
            windowUiInstance.win32CloseButton.opacity = defaultOpacity
        } else {
            windowUiInstance.win32CloseButton.opacity = disabledOpacity
        }
    }

    // todo: add kdoc for it method.
    fun calculateMinWidthSizeByTitleBar() {
        windowOptionsInstance.stage.minWidth =
            windowUiInstance.title.width + windowUiInstance.title.padding.left + (47 * 4) + 36 + windowUiInstance.title.layoutX
    }

    fun returnMinWidthSizeByTitleBar(): Double =
        windowUiInstance.title.width + windowUiInstance.title.padding.left + (47 * 4) + 36 + windowUiInstance.title.layoutX
}