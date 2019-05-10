package jfxwindow.helpers

import jfxwindow.base.WindowBase

internal const val shadowPadding = 18.0
internal const val windowButtonWidth = 47.0
internal const val windowButtonCounts = 4.0
internal const val shadowVertEdges = 2.0
internal const val titleBarHeight = 33.0

internal fun installDefaultSize(instance: WindowBase) {
    instance.windowOptions.stage.minHeight =
        titleBarHeight + (shadowPadding * 2)
    instance.windowOptions.stage.minWidth = instance.windowPart.getMinWidthSizeByTitleBar()
}

internal fun installCallbackSize(instance: WindowBase) {
    instance.windowOptions.stage.minWidthProperty().addListener { _,
                                                                  _,
                                                                  newValue ->
        if (newValue.toDouble() < (windowButtonWidth * windowButtonCounts) + (shadowPadding * shadowVertEdges)) {
            instance.windowOptions.stage.minWidth = instance.windowPart.getMinWidthSizeByTitleBar()
        }
    }

    instance.windowOptions.stage.minHeightProperty().addListener { _,
                                                                   _,
                                                                   newValue ->
        if (newValue.toDouble() < instance.windowUi.windowTitleBarPane.height + (shadowPadding * shadowVertEdges)) {
            instance.windowOptions.stage.minHeight =
                titleBarHeight + (shadowPadding * shadowVertEdges)
        }
    }
}
