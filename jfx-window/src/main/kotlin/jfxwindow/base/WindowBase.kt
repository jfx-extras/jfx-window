package jfxwindow.base

import javafx.stage.Stage

class WindowBase(stage: Stage) {
    @set:JvmSynthetic @get:JvmSynthetic
    internal var windowOptions = WindowOptions(stage)
}