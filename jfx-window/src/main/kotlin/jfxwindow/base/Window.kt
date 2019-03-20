package jfxwindow.base

import javafx.stage.Stage

/**
 * Base jfx-window library window constructor and builder.
 *
 * @param [stage] application window stage in which the window will be created.
 */
class Window(private val stage: Stage) {
    val windowBase: WindowBase = WindowBase(stage)
}