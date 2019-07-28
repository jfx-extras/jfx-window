package jfxwindow.listeners

import com.sun.jna.Pointer
import com.sun.jna.platform.win32.User32
import com.sun.jna.platform.win32.WinDef
import com.sun.jna.platform.win32.WinUser.*
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
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                com.sun.glass.ui.Window.getWindows().forEach {
                    val lpVoid = Pointer(it.nativeWindow)
                    val hwnd = WinDef.HWND(lpVoid)
                    val user32 = User32.INSTANCE
                    //val oldStyle = user32.GetWindowLong(hwnd, GWL_STYLE)
                    var newStyle = WS_CAPTION or
                            WS_POPUP or
                            WS_VISIBLE or
                            WS_CLIPSIBLINGS or
                            WS_CLIPSIBLINGS or
                            WS_SYSMENU or
                            WS_THICKFRAME or
                            WS_MAXIMIZEBOX or
                            WS_MINIMIZEBOX

                    var newStyle1 = 0x00000000 or
                            0x00000100
                    user32.SetWindowLong(hwnd, GWL_STYLE, newStyle)
                    user32.SetWindowLong(hwnd, GWL_EXSTYLE, newStyle1)
                    //newStyle = newStyle and WS_THICKFRAME.inv()

                }

            }
        } catch (ex: Exception) {
            Logger.getLogger(javaClass.name).log(
                Level.WARNING,
                "It was not possible to add the ability to minimize the window through the taskbar. Perhaps not used by Windows, or the old version of Windows."
            )

            throw ex
        }
    }
}
