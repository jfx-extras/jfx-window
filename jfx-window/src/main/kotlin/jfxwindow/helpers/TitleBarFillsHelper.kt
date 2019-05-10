package jfxwindow.helpers

import javafx.scene.paint.Color
import jfxwindow.base.WindowBase

@Suppress("RedundantUnitReturnType")
internal class TitleBarFillsHelper(private val windowBase: WindowBase) {
    internal fun updateFills(color: Color): Unit {
        windowBase.windowUi.win32CloseIcon.fill = color.getBlackOrWhiteByColor(color)
        windowBase.windowUi.win32MaxIcon.fill = color.getBlackOrWhiteByColor(color)
        windowBase.windowUi.win32UnMaxIcon.fill = color.getBlackOrWhiteByColor(color)
        windowBase.windowUi.win32MinIcon.fill = color.getBlackOrWhiteByColor(color)
        windowBase.windowUi.title.textFill = color.getBlackOrWhiteByColor(color)
        windowBase.windowUi.titleCenter.textFill = color.getBlackOrWhiteByColor(color)
    }
}
