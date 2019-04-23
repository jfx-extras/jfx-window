package jfxwindow.helpers

import javafx.scene.Cursor
import javafx.scene.Scene
import javafx.scene.input.MouseEvent
import javafx.stage.Screen
import javafx.stage.Stage
import jfxwindow.enums.ResizeDirection
import jfxwindow.parts.WindowPart

internal class WindowResizeHelper(private val windowPart: WindowPart) {
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var stage: Stage
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var scene: Scene
    private var isResizing = false
    private var resizeDirection: ResizeDirection? = null
    private var resizeMarginTop = 0.0
    private var resizeMarginRight = 0.0
    private var resizeMarginBottom = 0.0
    private var resizeMarginLeft = 0.0

    @JvmSynthetic
    internal fun changeResizeMargins(
        top: Double,
        right: Double,
        bottom: Double,
        left: Double
    ) {
        resizeMarginTop = top
        resizeMarginRight = right
        resizeMarginBottom = bottom
        resizeMarginLeft = left
    }

    @JvmSynthetic
    internal fun makeResizable(
        marginTop: Double = 19.0,
        marginRight: Double = 19.0,
        marginBottom: Double = 19.0,
        marginLeft: Double = 19.0
    ) {
        resizeMarginTop = marginTop
        resizeMarginRight = marginRight
        resizeMarginBottom = marginBottom
        resizeMarginLeft = marginLeft

        scene.addEventHandler(MouseEvent.MOUSE_MOVED) {
            if (windowPart.isResizable && !isResizing && !stage.isMaximized) {
                when (detectResizeDirection(it)) {
                    ResizeDirection.NORTH_WEST -> scene.cursor = Cursor.NW_RESIZE
                    ResizeDirection.NORTH_EAST -> scene.cursor = Cursor.NE_RESIZE
                    ResizeDirection.SOUTH_WEST -> scene.cursor = Cursor.SW_RESIZE
                    ResizeDirection.SOUTH_EAST -> scene.cursor = Cursor.SE_RESIZE
                    ResizeDirection.NORTH -> scene.cursor = Cursor.N_RESIZE
                    ResizeDirection.SOUTH -> scene.cursor = Cursor.S_RESIZE
                    ResizeDirection.WEST -> scene.cursor = Cursor.W_RESIZE
                    ResizeDirection.EAST -> scene.cursor = Cursor.E_RESIZE
                    else -> {
                        val cursors = listOf(
                            Cursor.NW_RESIZE,
                            Cursor.NE_RESIZE,
                            Cursor.SW_RESIZE,
                            Cursor.SE_RESIZE,
                            Cursor.N_RESIZE,
                            Cursor.S_RESIZE,
                            Cursor.W_RESIZE,
                            Cursor.E_RESIZE
                        )

                        if (cursors.contains(scene.cursor)) {
                            scene.cursor = Cursor.DEFAULT
                        }
                    }
                }
            }
        }

        var resizeStartFromSceneX = 0.0
        var resizeStartFromSceneY = 0.0
        var resizeStartFromScreenX = 0.0
        var resizeStartFromScreenY = 0.0
        var resizeStartStageWidth = 0.0
        var resizeStartStageHeight = 0.0

        scene.addEventHandler(MouseEvent.MOUSE_PRESSED) {
            if (windowPart.isResizable && !isResizing) {
                resizeDirection = detectResizeDirection(it)

                if (resizeDirection != null) {
                    isResizing = true

                    resizeStartFromScreenX = it.screenX
                    resizeStartFromScreenY = it.screenY
                    resizeStartFromSceneX = it.sceneX
                    resizeStartFromSceneY = it.sceneY
                    resizeStartStageWidth = stage.width
                    resizeStartStageHeight = stage.height
                }
            }
        }

        scene.addEventHandler(MouseEvent.MOUSE_DRAGGED) {
            if (isResizing) {
                if (resizeDirection == ResizeDirection.NORTH || resizeDirection == ResizeDirection.NORTH_WEST || resizeDirection == ResizeDirection.NORTH_EAST) {
                    val newHeight = ensureStageHeightIsWithinLimits(
                        resizeStartStageHeight + (resizeStartFromScreenY - it.screenY)
                    )
                    val newY = when (newHeight) {
                        stage.maxHeight, stage.minHeight -> stage.y
                        else -> it.screenY - resizeStartFromSceneY
                    }

                    stage.height = newHeight
                    stage.y = newY
                }

                if (resizeDirection == ResizeDirection.SOUTH || resizeDirection == ResizeDirection.SOUTH_WEST || resizeDirection == ResizeDirection.SOUTH_EAST) {
                    val newHeight = ensureStageHeightIsWithinLimits(
                        resizeStartStageHeight + (it.screenY - resizeStartFromScreenY)
                    )

                    stage.height = newHeight
                }

                if (resizeDirection == ResizeDirection.WEST || resizeDirection == ResizeDirection.NORTH_WEST || resizeDirection == ResizeDirection.SOUTH_WEST) {
                    val newWidth = ensureStageWidthIsWithinLimits(
                        resizeStartStageWidth + (resizeStartFromScreenX - it.screenX)
                    )
                    val newX = when (newWidth) {
                        stage.maxWidth, stage.minWidth -> stage.x
                        else -> it.screenX - resizeStartFromSceneX
                    }

                    stage.width = newWidth
                    stage.x = newX
                }

                if (resizeDirection == ResizeDirection.EAST || resizeDirection == ResizeDirection.NORTH_EAST || resizeDirection == ResizeDirection.SOUTH_EAST) {
                    val newWidth = ensureStageWidthIsWithinLimits(
                        resizeStartStageWidth + (it.screenX - resizeStartFromScreenX)
                    )

                    stage.width = newWidth
                }
            }
        }

        scene.addEventHandler(MouseEvent.MOUSE_RELEASED) {
            if (isResizing) isResizing = false
        }
    }

    private fun detectResizeDirection(event: MouseEvent): ResizeDirection? {
        val isNorthResize = event.sceneY <= resizeMarginTop
        val isSouthResize = scene.height - event.sceneY <= resizeMarginBottom
        val isWestResize = event.sceneX <= resizeMarginLeft
        val isEastResize = scene.width - event.sceneX <= resizeMarginRight
        val isNorthWestResize = isNorthResize && isWestResize
        val isNorthEastResize = isNorthResize && isEastResize
        val isSouthWestResize = isSouthResize && isWestResize
        val isSouthEastResize = isSouthResize && isEastResize

        return when {
            isNorthWestResize -> ResizeDirection.NORTH_WEST
            isNorthEastResize -> ResizeDirection.NORTH_EAST
            isSouthWestResize -> ResizeDirection.SOUTH_WEST
            isSouthEastResize -> ResizeDirection.SOUTH_EAST
            isNorthResize -> ResizeDirection.NORTH
            isSouthResize -> ResizeDirection.SOUTH
            isWestResize -> ResizeDirection.WEST
            isEastResize -> ResizeDirection.EAST
            else -> null
        }
    }

    // It need to compatibility with multi-screen.
    private fun ensureStageWidthIsWithinLimits(width: Double): Double {
        val screenBounds = Screen.getPrimary().visualBounds

        return when {
            width > stage.maxWidth -> stage.maxWidth
            width < stage.minWidth -> stage.minWidth
            width > screenBounds.width -> screenBounds.width
            else -> width
        }
    }

    private fun ensureStageHeightIsWithinLimits(height: Double): Double {
        val screenBounds = Screen.getPrimary().visualBounds

        return when {
            height > stage.maxHeight -> stage.maxHeight
            height < stage.minHeight -> stage.minHeight
            height > screenBounds.height -> screenBounds.height
            else -> height
        }
    }
}