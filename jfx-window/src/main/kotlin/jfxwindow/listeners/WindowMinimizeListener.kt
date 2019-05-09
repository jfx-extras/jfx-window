package jfxwindow.listeners

import javafx.stage.Screen
import jfxwindow.base.WindowBase

@Suppress("RedundantUnitReturnType")
internal class WindowMinimizeListener(private val windowBase: WindowBase) {
    internal fun init(): Unit {
        windowBase.windowOptions.stage.iconifiedProperty().addListener { _,
                                                                         _,
                                                                         newValue ->
            if (!newValue) {
                if (windowBase.windowOptions.stage.isMaximized) {
                    windowBase.windowOptions.stage.height = Screen.getPrimary().visualBounds.height
                }
            }
        }
    }
}
