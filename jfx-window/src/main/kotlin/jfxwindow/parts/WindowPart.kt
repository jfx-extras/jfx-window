package jfxwindow.parts

import javafx.util.Duration
import jfxwindow.base.WindowBase
import jfxwindow.base.WindowOptions
import jfxwindow.base.WindowUi
import jfxwindow.listeners.WindowDataListener
import kotlin.properties.Delegates

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

    var defaultOpacity: Double = 1.0
    var disabledOpacity: Double = 0.4
    var animationDuration: Duration = Duration.millis(200.0)
    var smoothColorAnim: Boolean = true
    var saveWindowPosition: Boolean
        get() = WindowDataListener.savePosIsEnabled
        set(isEnabled) {
            WindowDataListener.savePosIsEnabled = isEnabled
        }
    var isResizable: Boolean by Delegates.observable(true) { _, _, newValue ->
        contextPart.forceDisableResize = !newValue
    }
    var isDraggable: Boolean by Delegates.observable(true) { _, _, newValue ->
        contextPart.forceDisableMove = !newValue
    }
    var isMaximizable by Delegates.observable(true) { _, _, newValue ->
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
    var isMinimizable by Delegates.observable(true) { _, _, newValue ->
        windowUiInstance.win32MinButton.isDisable = !newValue
        contextPart.forceDisableMinimize = !newValue

        if (newValue) {
            windowUiInstance.win32MinButton.opacity = defaultOpacity
        } else {
            windowUiInstance.win32MinButton.opacity = disabledOpacity
        }
    }
    var isClosable by Delegates.observable(true) { _, _, newValue ->
        windowUiInstance.win32CloseButton.isDisable = !newValue
        contextPart.forceDisableClose = !newValue

        if (newValue) {
            windowUiInstance.win32CloseButton.opacity = defaultOpacity
        } else {
            windowUiInstance.win32CloseButton.opacity = disabledOpacity
        }
    }
    var useMinSizeAsContentSize: Boolean
        get() = useMinSizeAsContentSizeHelper
        set(isEnabled) {
            if (isEnabled) {
                windowOptionsInstance.stage.minWidth = windowBaseInstance.windowStageShownListener.sizes[0]
                windowOptionsInstance.stage.minHeight = windowBaseInstance.windowStageShownListener.sizes[1]
            } else {
                windowOptionsInstance.stage.minWidth = windowBaseInstance.windowStageShownListener.defaultSizeWidth
                windowOptionsInstance.stage.minHeight = windowBaseInstance.windowStageShownListener.defaultSizeHeight
            }
        }

    // todo: add kdoc for it method.
    fun calculateMinWidthSizeByTitleBar() {
        windowOptionsInstance.stage.minWidth =
            windowUiInstance.title.width + windowUiInstance.title.padding.left + (47 * 4) + 36
    }
}