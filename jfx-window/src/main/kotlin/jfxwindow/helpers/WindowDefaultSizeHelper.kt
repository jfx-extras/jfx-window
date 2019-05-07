package jfxwindow.helpers

import jfxwindow.base.WindowBase
import jfxwindow.base.WindowOptions

internal class WindowDefaultSizeHelper {
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowBaseInstance: WindowBase

    @JvmSynthetic
    internal fun setDefaultMinSize() {
        windowOptionsInstance.stage.minHeight = 33.0 + 36.0
        windowOptionsInstance.stage.minWidth = windowBaseInstance.windowPart.getMinWidthSizeByTitleBar()
    }
}
