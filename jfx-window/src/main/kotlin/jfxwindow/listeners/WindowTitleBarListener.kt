package jfxwindow.listeners

import com.sun.javafx.cursor.CursorType
import com.sun.javafx.cursor.StandardCursorFrame
import javafx.scene.Cursor
import javafx.scene.input.MouseButton
import jfxwindow.base.WindowOptions
import jfxwindow.base.WindowUi
import jfxwindow.parts.WindowPart

class WindowTitleBarListener {
    private var xOffset: Double = 0.0
    private var yOffset: Double = 0.0
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowUiInstance: WindowUi
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowPart: WindowPart

    @JvmSynthetic
    internal fun addResizeListeners() {
        windowOptionsInstance.stage.widthProperty().addListener { _, _, _ ->
            windowUiInstance.windowShadowPane.setPrefSize(windowOptionsInstance.stage.width, windowOptionsInstance.stage.height)
            windowUiInstance.windowPane.setPrefSize(windowOptionsInstance.stage.width, windowOptionsInstance.stage.height)
        }

        windowOptionsInstance.stage.heightProperty().addListener { _, _, _ ->
            windowUiInstance.windowShadowPane.setPrefSize(windowOptionsInstance.stage.width, windowOptionsInstance.stage.height)
            windowUiInstance.windowPane.setPrefSize(windowOptionsInstance.stage.width, windowOptionsInstance.stage.height)
        }
    }

    // todo: fix not correct window restoring by mouse move when window maximized.
    @JvmSynthetic
    internal fun addTitleMoveListener() {
        windowOptionsInstance.stage.scene.cursor = Cursor.DEFAULT

        windowUiInstance.windowTitleBarPane.setOnMousePressed {
            if (windowPart.isDraggable) {
                if (it.target == windowUiInstance.windowTitleBarPane) {
                    if (!StandardCursorFrame(CursorType.valueOf(windowOptionsInstance.stage.scene.cursor.toString())).cursorType.name.contains("RESIZE")) {
                        if (it.button == MouseButton.PRIMARY) {
                            if (windowOptionsInstance.stage.isMaximized) {
                                xOffset = windowOptionsInstance.stage.x - it.screenX
                                yOffset = windowOptionsInstance.stage.y - 30
                            } else {
                                xOffset = windowOptionsInstance.stage.x - it.screenX
                                yOffset = windowOptionsInstance.stage.y - it.screenY
                            }
                        }
                    }
                }
            }
        }

        windowUiInstance.windowTitleBarPane.setOnMouseDragged {
            if (windowPart.isDraggable) {
                if (it.target == windowUiInstance.windowTitleBarPane) {
                    if (!StandardCursorFrame(CursorType.valueOf(windowOptionsInstance.stage.scene.cursor.toString())).cursorType.name.contains("RESIZE")) {
                        if (it.button == MouseButton.PRIMARY) {
                            if (windowOptionsInstance.stage.isMaximized) {
                                windowOptionsInstance.stage.isMaximized = false
                                windowOptionsInstance.stage.x = it.screenY + yOffset
                                windowOptionsInstance.stage.y = it.screenY + yOffset
                            } else {
                                windowOptionsInstance.stage.x = it.screenX + xOffset
                                windowOptionsInstance.stage.y = it.screenY + yOffset
                                windowOptionsInstance.stage.scene.cursor = Cursor.DEFAULT
                            }
                        }
                    }
                }
            }
        }

        windowUiInstance.windowTitleBarPane.setOnMouseClicked {
            if (windowPart.isMaximizable) {
                if (it.target == windowUiInstance.windowTitleBarPane) {
                    if (!StandardCursorFrame(CursorType.valueOf(windowOptionsInstance.stage.scene.cursor.toString())).cursorType.name.contains("RESIZE")) {
                        if (it.button == MouseButton.PRIMARY) {
                            if (it.clickCount == 2) {
                                windowOptionsInstance.stage.isMaximized = !windowOptionsInstance.stage.isMaximized
                            }
                        }
                    }
                }
            }
        }
    }
}