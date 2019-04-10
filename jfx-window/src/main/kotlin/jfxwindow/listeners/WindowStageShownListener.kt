package jfxwindow.listeners

import jfxwindow.base.WindowOptions

internal class WindowStageShownListener {
    @set:JvmSynthetic @get:JvmSynthetic
    internal var defaultSizeWidth = 300.0
    @set:JvmSynthetic @get:JvmSynthetic
    internal var defaultSizeHeight = 200.0
    @set:JvmSynthetic @get:JvmSynthetic
    internal var sizes: Array<Double> = arrayOf(defaultSizeWidth, defaultSizeHeight)
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions

    internal fun addShownListener() {
        windowOptionsInstance.stage.setOnShown {
            val titleBarHeight = 32.0
            val shadowMaxZoneRadius = 18.0

            when {
                windowOptionsInstance.stage.width + shadowMaxZoneRadius * 2 < defaultSizeWidth -> sizes[0] = defaultSizeWidth
                else -> sizes[0] = windowOptionsInstance.stage.width + shadowMaxZoneRadius * 2
            }

            when {
                windowOptionsInstance.stage.height + titleBarHeight + shadowMaxZoneRadius * 2 < defaultSizeHeight -> sizes[1] = defaultSizeHeight
                else -> sizes[1] = windowOptionsInstance.stage.height + titleBarHeight + shadowMaxZoneRadius * 2
            }
        }
    }
}