package jfxwindow.listeners

import jfxwindow.base.WindowOptions

internal class WindowStageShownListener {
    @set:JvmSynthetic @get:JvmSynthetic
    internal var sizes: Array<Double> = arrayOf(300.0, 200.0)
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions

    internal fun addShownListener() {
        windowOptionsInstance.stage.setOnShown {
            val titleBarHeight = 32.0
            val shadowMaxZoneRadius = 18.0
            sizes[0] = windowOptionsInstance.stage.width + shadowMaxZoneRadius * 2
            sizes[1] = windowOptionsInstance.stage.height + titleBarHeight + shadowMaxZoneRadius * 2
        }
    }
}