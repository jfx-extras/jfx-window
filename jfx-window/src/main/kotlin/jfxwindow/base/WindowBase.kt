package jfxwindow.base

import javafx.stage.Stage
import jfxwindow.helpers.AnimationHelper
import jfxwindow.helpers.WindowDefaultSizeHelper
import jfxwindow.helpers.WindowResizeHelper
import jfxwindow.listeners.WindowInactiveListener
import jfxwindow.listeners.WindowStageShownListener
import jfxwindow.listeners.WindowStateListener
import jfxwindow.listeners.WindowTitleBarListener
import jfxwindow.parts.*

/**
 * It class contains window ui elements instances.
 *
 * @param [stage] application window stage.
 */
class WindowBase(stage: Stage) {
    @set:JvmSynthetic @get:JvmSynthetic
    internal var windowOptions = WindowOptions(stage)
    @set:JvmSynthetic @get:JvmSynthetic
    internal var windowUi = WindowUi()
    var contentPart = ContentPart(windowUi)
    var contextPart = ContextPart()
    var windowPart = WindowPart()
    var borderPart = BorderPart()
    var titlePart = TitlePart()
    var iconPart = IconPart()
    var titleBarPart = TitleBarPart()
    var buttonPart = ButtonPart()
    var animationHelper = AnimationHelper()
    var windowTitleBarListener = WindowTitleBarListener()
    @set:JvmSynthetic @get:JvmSynthetic
    internal var windowResizeHelper = WindowResizeHelper(windowPart)
    @set:JvmSynthetic @get:JvmSynthetic
    internal var windowStateListener = WindowStateListener()
    @set:JvmSynthetic @get:JvmSynthetic
    internal var windowInactiveListener = WindowInactiveListener()
    @set:JvmSynthetic @get:JvmSynthetic
    internal var windowStageShownListener = WindowStageShownListener()
    @set:JvmSynthetic @get:JvmSynthetic
    internal var windowDefaultSizeListener = WindowDefaultSizeHelper()
}