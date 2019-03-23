package jfxwindow.base

import javafx.stage.Stage
import jfxwindow.helpers.AnimationHelper
import jfxwindow.helpers.WindowResizeHelper
import jfxwindow.parts.ContentPart
import jfxwindow.parts.ContextPart
import jfxwindow.parts.TitlePart
import jfxwindow.parts.WindowPart

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
    var titlePart = TitlePart()
    var animationHelper = AnimationHelper()
    @set:JvmSynthetic @get:JvmSynthetic
    internal var windowResizeHelper = WindowResizeHelper(windowPart)
}