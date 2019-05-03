package jfxwindow.parts

import javafx.scene.Cursor
import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem
import javafx.scene.input.KeyCombination
import javafx.scene.shape.SVGPath
import jfxwindow.base.WindowBase
import jfxwindow.consts.ContextIcons
import jfxwindow.helpers.contextMenuBundle
import java.awt.Robot

@Suppress(
    "RedundantVisibilityModifier",
    "MemberVisibilityCanBePrivate",
    "RedundantUnitReturnType",
    "unused"
)
/**
 * Contains some methods and properties allowing to
 * work with the context menu of the window.
 */
public class ContextPart(private val windowBase: WindowBase) {
    private companion object {
        private var restoreString = contextMenuBundle.getString("RestoreString")
        private var moveString = contextMenuBundle.getString("MoveString")
        private var sizeString = contextMenuBundle.getString("SizeString")
        private var maximizeString = contextMenuBundle.getString("MaximizeString")
        private var minimizeString = contextMenuBundle.getString("MinimizeString")
        private var closeString = contextMenuBundle.getString("CloseString")
    }

    internal var forceDisableMaximize: Boolean = false
    internal var forceDisableMinimize: Boolean = false
    internal var forceDisableClose: Boolean = false
    internal var forceDisableMove: Boolean = false
    internal var forceDisableResize: Boolean = false

    private val closeSvg = buildCloseSvg()
    private val maxSvg = buildMaxSvg()
    private val minSvg = buildMinSvg()
    private val restoreSvg = buildRestoreSvg()

    private val contextMenu = ContextMenu()
    private val restore = MenuItem(restoreString, restoreSvg)
    private val move = MenuItem(moveString)
    private val size = MenuItem(sizeString)
    private val maximize = MenuItem(maximizeString, maxSvg)
    private val minimize = MenuItem(minimizeString, minSvg)
    private val close = MenuItem(closeString, closeSvg)

    /**
     * Controlling ability to open context menu,
     * if it property is false then you can't open
     * context menu.
     */
    public var contextMenuIsEnabled: Boolean = true
    /**
     * Context menu spacing add empty spaces to menu
     * item text, it need in order to context menu
     * looked fine.
     *
     * You can change spacing value for changing
     * left text padding in menu item.
     *
     * **Default spaces count is 5 chars**
     */
    public var spacing: String = "     "
    /**
     * Controlling adding spacing to menu items text.
     * If it property is false you then when you
     * open context menu you not see left text padding.
     */
    public var spacingIsEnabled: Boolean = true
    /**
     * It property contains string key combination
     * for closing stage.
     *
     * **I do not know how it will work on different systems!
     * By default, the Windows key combination (ALT + F4) will
     * be used by default.**
     */
    public var closeKeyCombination: String = "ALT+F4"

    internal fun init(): Unit {
        contextMenuIsEnabled = windowBase.windowOptions.contextMenuIsEnabled
        registerActions()
        onShowingContextMenu()
    }

    private fun registerActions(): Unit {
        restore.setOnAction {
            windowBase.windowOptions.stage.isMaximized = false
        }

        maximize.setOnAction {
            windowBase.windowOptions.stage.isMaximized = true
        }

        close.setOnAction {
            windowBase.windowOptions.stage.close()
        }

        minimize.setOnAction {
            windowBase.windowOptions.stage.isIconified = true
        }

        move.setOnAction {
            windowBase.windowOptions.stage.scene.cursor = Cursor.MOVE

            val stageX = windowBase.windowOptions.stage.x
            val stageCenterX = windowBase.windowOptions.stage.width
            val cursorCenterX = stageX + (stageCenterX / 2)

            val stageY = windowBase.windowOptions.stage.y
            val cursorCenterY = stageY + 35

            Robot().mouseMove(cursorCenterX.toInt(), cursorCenterY.toInt())
        }

        size.setOnAction {
            windowBase.windowOptions.stage.scene.cursor = Cursor.NW_RESIZE
            val stageX = windowBase.windowOptions.stage.x + 18
            val stageY = windowBase.windowOptions.stage.y + 18
            Robot().mouseMove(stageX.toInt(), stageY.toInt())
        }
    }

    private fun onShowingContextMenu(): Unit {
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
            close.accelerator = KeyCombination.keyCombination(closeKeyCombination)
            processSpaces()

            close.isDisable = forceDisableClose
            minimize.isDisable = forceDisableMinimize
            move.isDisable = forceDisableMove
            size.isDisable = forceDisableResize

            if (windowBase.windowOptions.stage.isMaximized) {
                maximize.isDisable = true
                restore.isDisable = forceDisableMaximize
                size.isDisable = true
            } else {
                maximize.isDisable = forceDisableMaximize
                restore.isDisable = true
                size.isDisable = forceDisableResize
            }
        }

        windowBase.windowUi.windowTitleBarPane.setOnContextMenuRequested { e ->
            if (contextMenuIsEnabled) {
                contextMenu.show(windowBase.windowOptions.stage, e.screenX, e.screenY)
            } else {
                e.consume()
            }
        }
    }

    private fun processSpaces(): Unit {
        when {
            spacingIsEnabled -> {
                restore.text = spacing + restoreString
                move.text = spacing + moveString
                size.text = spacing + sizeString
                maximize.text = spacing + maximizeString
                minimize.text = spacing + minimizeString
                close.text = spacing + closeString
            }
            else -> {
                restore.text = restoreString
                move.text = moveString
                size.text = sizeString
                maximize.text = maximizeString
                minimize.text = minimizeString
                close.text = closeString
            }
        }
    }

    /**
     * @return the current state of the configured context
     * menu in the scene.
     */
    public fun getContextMenu(): ContextMenu = contextMenu

    private fun buildCloseSvg(): SVGPath {
        val closeSvg = SVGPath()
        closeSvg.translateX = 5.0
        closeSvg.content = ContextIcons.win32Close
        return closeSvg
    }

    private fun buildMaxSvg(): SVGPath {
        val maxSvg = SVGPath()
        maxSvg.smoothProperty().value = false
        maxSvg.translateX = 4.0
        maxSvg.content = ContextIcons.win32Max
        return maxSvg
    }

    private fun buildMinSvg(): SVGPath {
        val minSvg = SVGPath()
        minSvg.smoothProperty().value = false
        minSvg.translateX = 4.0
        minSvg.content = ContextIcons.win32Min
        return minSvg
    }

    private fun buildRestoreSvg(): SVGPath {
        val restoreSvg = SVGPath()
        restoreSvg.smoothProperty().value = false
        restoreSvg.translateX = 4.0
        restoreSvg.content = ContextIcons.win32Restore
        return restoreSvg
    }
}
