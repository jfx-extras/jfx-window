package jfxwindow.listeners

import jfxwindow.base.WindowBase

@Suppress("RedundantUnitReturnType")
internal class WindowInactiveListener(private val windowBase: WindowBase) {
    internal fun init(): Unit {
        windowBase.windowOptions.stage.focusedProperty().addListener { _,
                                                                       _,
                                                                       isActive ->
            switchTitleBarShadow(isActive)
            switchBarBackgroundColor(isActive)
            switchBorderColor(isActive)
            switchTitleOpacity(isActive)
        }
    }

    private fun switchTitleBarShadow(isActive: Boolean): Unit {
        if (isActive) {
            windowBase.titleBarPart.shadowDepth = windowBase.titleBarPart.temporaryTitleShadow
        } else {
            windowBase.titleBarPart.temporaryTitleShadow = windowBase.titleBarPart.shadowDepth
            windowBase.titleBarPart.shadowDepth = windowBase.titleBarPart.titleInactiveShadow
        }
    }

    private fun switchBarBackgroundColor(isActive: Boolean): Unit {
        if (isActive) {
            windowBase.titleBarPart.titleBackground =
                windowBase.titleBarPart.temporaryTitleColor
        } else {
            windowBase.titleBarPart.temporaryTitleColor =
                windowBase.titleBarPart.titleBackground
            windowBase.titleBarPart.titleBackground =
                windowBase.titleBarPart.titleInactiveBackground
        }
    }

    private fun switchBorderColor(isActive: Boolean): Unit {
        if (isActive) {
            windowBase.borderPart.borderColor = windowBase.borderPart.borderActiveColor
        } else {
            windowBase.borderPart.borderActiveColor = windowBase.borderPart.borderColor
            windowBase.borderPart.borderColor = windowBase.borderPart.borderInactiveColor
        }
    }

    private fun switchTitleOpacity(isActive: Boolean): Unit {
        if (isActive) {
            windowBase.titlePart.titleOpacity = windowBase.titlePart.temporaryTitleOpacity
        } else {
            windowBase.titlePart.temporaryTitleOpacity = windowBase.titlePart.titleOpacity
            windowBase.titlePart.titleOpacity = windowBase.titlePart.titleInactiveOpacity
        }
    }
}
