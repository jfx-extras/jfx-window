package jfxwindow.listeners

import com.sun.javafx.cursor.CursorType
import com.sun.javafx.cursor.StandardCursorFrame
import com.sun.jna.Pointer
import com.sun.jna.platform.win32.User32
import com.sun.jna.platform.win32.WinDef
import com.sun.jna.platform.win32.WinUser
import javafx.scene.Cursor
import javafx.scene.input.MouseButton
import jfxwindow.base.WindowOptions
import jfxwindow.base.WindowUi
import jfxwindow.parts.WindowPart
import com.sun.jna.platform.win32.WinDef.HWND



class WindowBaseListener {
    private var xOffset: Double = 0.0
    private var yOffset: Double = 0.0
    @set:JvmSynthetic
    @get:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions
    @set:JvmSynthetic
    @get:JvmSynthetic
    internal lateinit var windowUiInstance: WindowUi
    @set:JvmSynthetic
    @get:JvmSynthetic
    internal lateinit var windowPart: WindowPart

    // todo: fix not correct window restoring by mouse move when window maximized.
    @JvmSynthetic
    internal fun addTitleMoveListener() {
        windowOptionsInstance.stage.scene.cursor = Cursor.DEFAULT

        windowUiInstance.windowTitleBarPane.setOnMousePressed {
            if (windowPart.isDraggable) {
                if (it.target == windowUiInstance.windowTitleBarPane) {
                    if (!StandardCursorFrame(CursorType.valueOf(windowOptionsInstance.stage.scene.cursor.toString())).cursorType.name.contains(
                            "RESIZE"
                        )
                    ) {
                        if (it.button == MouseButton.PRIMARY) {
                            if (windowOptionsInstance.stage.isMaximized && windowPart.isMaximizable) {
                                xOffset = windowOptionsInstance.stage.x - it.screenX
                                yOffset = windowOptionsInstance.stage.y - 30
                            } else {
                                if (!windowOptionsInstance.stage.isMaximized) {
                                    xOffset = windowOptionsInstance.stage.x - it.screenX
                                    yOffset = windowOptionsInstance.stage.y - it.screenY
                                }
                            }
                        }
                    }
                }
            }
        }

        windowUiInstance.windowTitleBarPane.setOnMouseDragged {
            if (windowPart.isDraggable) {
                if (it.target == windowUiInstance.windowTitleBarPane) {
                    if (!StandardCursorFrame(CursorType.valueOf(windowOptionsInstance.stage.scene.cursor.toString())).cursorType.name.contains(
                            "RESIZE"
                        )
                    ) {
                        if (it.button == MouseButton.PRIMARY) {
                            if (windowOptionsInstance.stage.isMaximized && windowPart.isMaximizable) {
                                windowOptionsInstance.stage.isMaximized = false
                                windowOptionsInstance.stage.x = it.screenY + yOffset
                                windowOptionsInstance.stage.y = it.screenY + yOffset
                            } else {
                                if (!windowOptionsInstance.stage.isMaximized) {
                                    val lhwnd = com.sun.glass.ui.Window.getFocusedWindow().nativeWindow
                                    val lpVoid = Pointer(lhwnd)
                                    val hwnd = WinDef.HWND(lpVoid)
                                    val user32 = User32.INSTANCE
                                    user32.SetWindowPos(
                                        hwnd,
                                        WinDef.HWND(Pointer(0)),
                                        (it.screenX + xOffset).toInt(),
                                        (it.screenY + yOffset).toInt(),
                                        windowOptionsInstance.stage.width.toInt(),
                                        windowOptionsInstance.stage.height.toInt(),
                                        0x0040 or 0x0020
                                    )

                                    user32.MoveWindow(
                                        hwnd,
                                        (it.screenX + xOffset).toInt(),
                                        (it.screenY + yOffset).toInt(),
                                        windowOptionsInstance.stage.width.toInt(),
                                        windowOptionsInstance.stage.height.toInt(),
                                        true
                                    )
//
                                    user32.SendMessage(hwnd, 0x0083, WinDef.WPARAM(), WinDef.LPARAM())
//
//                                    windowOptionsInstance.stage.x = it.screenX + xOffset
//                                    windowOptionsInstance.stage.y = it.screenY + yOffset
                                    windowOptionsInstance.stage.scene.cursor = Cursor.DEFAULT
                                }
                            }
                        }
                    }
                }
            }
        }

        windowUiInstance.windowTitleBarPane.setOnMouseClicked {
            if (windowPart.isMaximizable) {
                if (it.target == windowUiInstance.windowTitleBarPane) {
                    if (!StandardCursorFrame(CursorType.valueOf(windowOptionsInstance.stage.scene.cursor.toString())).cursorType.name.contains(
                            "RESIZE"
                        )
                    ) {
                        if (it.button == MouseButton.PRIMARY) {
                            if (it.clickCount == 2) {
                                windowOptionsInstance.stage.isMaximized =
                                    !windowOptionsInstance.stage.isMaximized
                            }
                        }
                    }
                }
            }
        }
    }
}
