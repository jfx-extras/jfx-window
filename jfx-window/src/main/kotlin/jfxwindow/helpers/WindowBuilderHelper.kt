package jfxwindow.helpers

import javafx.stage.Stage
import javafx.stage.StageStyle
import java.util.logging.Level
import java.util.logging.Logger

internal fun validateStage(stage: Stage) {
    validateJVMVersion()
    //validateStageStyle(stage)
}

private fun validateJVMVersion() {
    if (System.getProperty("java.specification.version") == "1.8") return

    Logger.getLogger("WindowBuilderHelperClass").log(
        Level.WARNING,
        "current version of jfx-window library only supports Java 8. You are using Java ${System.getProperty(
            "java.specification.version"
        )}!"
    )
}

private fun validateStageStyle(stage: Stage) {
    if (stage.style == StageStyle.TRANSPARENT) return

    throw IllegalStateException(
        "stage style must be \"TRANSPARENT\"! Otherwise stage can be created with some bugs. Current not correct stage style is ${stage.style}."
    )
}
