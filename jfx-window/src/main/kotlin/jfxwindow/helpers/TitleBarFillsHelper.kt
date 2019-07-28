package jfxwindow.helpers

import javafx.scene.paint.Color
import jfxwindow.base.WindowBase
import jfxwindow.enums.TitleBarTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.javafx.JavaFx as Main

@Suppress("RedundantUnitReturnType")
internal class TitleBarFillsHelper(private val windowBase: WindowBase) {
    internal fun updateFills(color: Color): Unit {
        GlobalScope.launch(Dispatchers.Main) {
            val temporaryColor: Color = when {
                windowBase.titleBarPart.theme == TitleBarTheme.DARK ->
                    Color.WHITE
                windowBase.titleBarPart.theme == TitleBarTheme.LIGHT ->
                    Color.BLACK
                else -> color
            }
            windowBase.windowUi.win32CloseIcon.fill =
                getBlackOrWhiteByColor(temporaryColor)
            windowBase.windowUi.win32MaxIcon.fill =
                getBlackOrWhiteByColor(temporaryColor)
            windowBase.windowUi.win32UnMaxIcon.fill =
                getBlackOrWhiteByColor(temporaryColor)
            windowBase.windowUi.win32MinIcon.fill =
                getBlackOrWhiteByColor(temporaryColor)
            windowBase.windowUi.title.textFill =
                getBlackOrWhiteByColor(temporaryColor)
            windowBase.windowUi.titleCenter.textFill =
                getBlackOrWhiteByColor(temporaryColor)
        }
    }
}
