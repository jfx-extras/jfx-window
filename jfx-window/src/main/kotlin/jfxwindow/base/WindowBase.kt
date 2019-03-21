package jfxwindow.base

import javafx.stage.Stage
import jfxwindow.parts.ContentPart

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
}