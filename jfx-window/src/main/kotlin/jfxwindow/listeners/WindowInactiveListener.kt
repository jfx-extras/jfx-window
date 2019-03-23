package jfxwindow.listeners

import jfxwindow.base.WindowOptions
import jfxwindow.parts.BorderPart
import jfxwindow.parts.TitleBarPart

class WindowInactiveListener {
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var borderPartInstance: BorderPart
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var titleBarPart: TitleBarPart

    @JvmSynthetic
    internal fun addWindowUnActiveListener() {
        windowOptionsInstance.stage.focusedProperty().addListener { _, _, newValue ->
            if (newValue) {
                borderPartInstance.borderColor = borderPartInstance.borderActiveColor
                titleBarPart.titleBackground = titleBarPart.titleActiveColor
                titleBarPart.shadowDepth = titleBarPart.titleActiveShadow
            } else {
                borderPartInstance.borderActiveColor = borderPartInstance.borderColor
                borderPartInstance.borderColor = borderPartInstance.borderInactiveColor

                titleBarPart.titleActiveColor = titleBarPart.titleBackground
                titleBarPart.titleBackground = titleBarPart.titleInactiveBackground

                titleBarPart.titleActiveShadow = titleBarPart.shadowDepth
                titleBarPart.shadowDepth = titleBarPart.titleInactiveShadow
            }
        }
    }
}