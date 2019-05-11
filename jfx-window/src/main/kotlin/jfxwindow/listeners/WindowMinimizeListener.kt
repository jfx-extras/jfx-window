package jfxwindow.listeners

import com.sun.jna.Pointer
import com.sun.jna.platform.win32.User32
import com.sun.jna.platform.win32.WinDef
import com.sun.jna.platform.win32.WinUser.GWL_STYLE
import javafx.stage.Screen
import jfxwindow.base.WindowBase
import java.util.logging.Level
import java.util.logging.Logger

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

        setMinimizableInTaskBar()
    }

    private fun setMinimizableInTaskBar() {
        try {
            val lhwnd = com.sun.glass.ui.Window.getWindows()[0].nativeWindow
            val lpVoid = Pointer(lhwnd)
            val hwnd = WinDef.HWND(lpVoid)
            val user32 = User32.INSTANCE
            val oldStyle = user32.GetWindowLong(hwnd, GWL_STYLE)
            val newStyle = oldStyle or 0x00020000
            user32.SetWindowLong(hwnd, GWL_STYLE, newStyle)
        } catch (ex: Exception) {
            Logger.getLogger(javaClass.name).log(
                Level.WARNING,
                "It was not possible to add the ability to minimize the window through the taskbar. Perhaps not used by Windows, or the old version of Windows."
            )
        }
    }
}
