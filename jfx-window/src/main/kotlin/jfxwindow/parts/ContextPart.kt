package jfxwindow.parts

import javafx.scene.Cursor
import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem
import javafx.scene.input.KeyCombination
import javafx.scene.shape.SVGPath
import jfxwindow.base.WindowOptions
import jfxwindow.base.WindowUi
import jfxwindow.consts.ContextIcons
import java.awt.Robot

class ContextPart {
    @get:JvmSynthetic
    @set:JvmSynthetic
    internal lateinit var windowUiInstance: WindowUi
    @get:JvmSynthetic
    @set:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions
    @get:JvmSynthetic
    @set:JvmSynthetic
    internal lateinit var windowPart: WindowPart
    private var contextMenu: Boolean = true
    @get:JvmSynthetic
    @set:JvmSynthetic
    internal var forceDisableMaximize: Boolean = false
    @get:JvmSynthetic
    @set:JvmSynthetic
    internal var forceDisableMinimize: Boolean = false
    @get:JvmSynthetic
    @set:JvmSynthetic
    internal var forceDisableClose: Boolean = false
    @get:JvmSynthetic
    @set:JvmSynthetic
    internal var forceDisableMove: Boolean = false
    @get:JvmSynthetic
    @set:JvmSynthetic
    internal var forceDisableResize: Boolean = false
    var spacing: String = "     "
    var spacingIsEnabled: Boolean = true

    private val restoreString = "Restore"
    private val moveString = "Move"
    private val sizeString = "Size"
    private val maximizeString = "Maximize"
    private val minimizeString = "Minimize"
    private val closeString = "Close"

    @JvmSynthetic
    internal fun applyContextMenuProperties() {
        contextMenu = windowOptionsInstance.contextMenuIsEnabled
        if (contextMenu) createContextMenu()
    }

    private fun createContextMenu() {
        removeContextMenu()

        val closeSvg = SVGPath()
        closeSvg.translateX = 5.0
        closeSvg.content = ContextIcons.win32Close

        val maxSvg = SVGPath()
        maxSvg.smoothProperty().value = false
        maxSvg.translateX = 4.0
        maxSvg.content = ContextIcons.win32Max

        val minSvg = SVGPath()
        minSvg.smoothProperty().value = false
        minSvg.translateX = 4.0
        minSvg.content = ContextIcons.win32Min

        val restoreSvg = SVGPath()
        restoreSvg.smoothProperty().value = false
        restoreSvg.translateX = 4.0
        restoreSvg.content = ContextIcons.win32Restore

        val contextMenu = ContextMenu()
        val restore = MenuItem(restoreString, restoreSvg)
        val move = MenuItem(moveString)
        val size = MenuItem(sizeString)
        val maximize = MenuItem(maximizeString, maxSvg)
        val minimize = MenuItem(minimizeString, minSvg)
        val close = MenuItem(closeString, closeSvg)
        close.accelerator = KeyCombination.keyCombination("ALT+F4")

        contextMenu.setOnShowing {
            contextMenu.items.clear()
            contextMenu.items.addAll(
                restore,
                move,
                size,
                minimize,
                maximize,
                SeparatorMenuItem(),
                close
            )

            if (spacingIsEnabled) {
                restore.text = spacing + restoreString
                move.text = spacing + moveString
                size.text = spacing + sizeString
                maximize.text = spacing + maximizeString
                minimize.text = spacing + minimizeString
                close.text = spacing + closeString
            } else {
                restore.text = restoreString
                move.text = moveString
                size.text = sizeString
                maximize.text = maximizeString
                minimize.text = minimizeString
                close.text = closeString
            }

            close.isDisable = forceDisableClose
            minimize.isDisable = forceDisableMinimize
            move.isDisable = forceDisableMove
            size.isDisable = forceDisableResize

            if (windowOptionsInstance.stage.isMaximized) {
                maximize.isDisable = true
            } else {
                maximize.isDisable = forceDisableMaximize
            }

            if (!windowOptionsInstance.stage.isMaximized) {
                restore.isDisable = true
            } else {
                restore.isDisable = forceDisableMaximize
            }

            if (windowOptionsInstance.stage.isMaximized) {
                size.isDisable = true
            } else {
                size.isDisable = forceDisableResize
            }

            if (!this.contextMenu) {
                contextMenu.items.clear()
            }
        }

        restore.setOnAction {
            windowOptionsInstance.stage.isMaximized = false
        }

        maximize.setOnAction {
            windowOptionsInstance.stage.isMaximized = true
        }

        close.setOnAction {
            windowOptionsInstance.stage.close()
        }

        minimize.setOnAction {
            windowOptionsInstance.stage.isIconified = true
        }

        move.setOnAction {
            windowOptionsInstance.stage.scene.cursor = Cursor.MOVE

            val stageX = windowOptionsInstance.stage.x
            val stageCenterX = windowOptionsInstance.stage.width
            val cursorCenterX = stageX + (stageCenterX / 2)

            val stageY = windowOptionsInstance.stage.y
            val cursorCenterY = stageY + 35

            Robot().mouseMove(cursorCenterX.toInt(), cursorCenterY.toInt())
        }

        size.setOnAction {
            windowOptionsInstance.stage.scene.cursor = Cursor.NW_RESIZE
            val stageX = windowOptionsInstance.stage.x + 18
            val stageY = windowOptionsInstance.stage.y + 18
            Robot().mouseMove(stageX.toInt(), stageY.toInt())
        }

        windowUiInstance.windowTitleBarPane.setOnContextMenuRequested { e ->
            contextMenu.show(windowOptionsInstance.stage, e.screenX, e.screenY)
        }
    }

    private fun removeContextMenu() {
        windowUiInstance.windowTitleBarPane.children.removeIf {
            it is ContextMenu
        }
    }

    var contextMenuIsEnabled
        get() = contextMenu
        set(value) {
            contextMenu = value
        }
}