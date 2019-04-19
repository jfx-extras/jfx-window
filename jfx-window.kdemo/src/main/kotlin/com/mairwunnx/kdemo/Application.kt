package com.mairwunnx.kdemo

import javafx.scene.layout.HBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.stage.Stage
import javafx.stage.StageStyle
import jfxwindow.base.Window
import jfxwindow.enums.TitleAlignment
import tornadofx.App

class Application : App(BaseView::class) {
    override fun start(stage: Stage) {
        stage.initStyle(StageStyle.TRANSPARENT)

        val window = Window(stage)
            .titleTextFont(Font.loadFont(javaClass.classLoader.getResource("segoeui.ttf").toString(), 12.0))
            .titleText("jfx-window")
            .saveWindowPosition(true)
            .borderColor(Color.BLACK)
            .borderInactiveColor(Color.DARKGRAY)
            .windowRootElement(HBox())
            .build()

        windowInstance = window
        super.start(stage)
        window.create()

        stage.widthProperty().addListener { newValue ->
            width = java.lang.Double.parseDouble(
                newValue.toString().split("value: ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1].replace(
                    "]",
                    ""
                )
            )
            calculateSize()
        }
        stage.heightProperty().addListener { newValue ->
            height = java.lang.Double.parseDouble(
                newValue.toString().split("value: ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1].replace(
                    "]",
                    ""
                )
            )
            calculateSize()
        }

        //stage.minWidth = 0.0
        // ↑ it test of exhibiting incompatible size for stage.
        // if size so small, it make stage with default min size.
    }

    private fun calculateSize() {
        windowInstance.windowBase.titlePart.titleText = "Size: $width x $height"
        windowInstance.windowBase.windowPart.calculateMinWidthSizeByTitleBar()
        // ↑ It can be applied if you want to set min width size (label width + button widths)
        // just comment 54 line for see what be if disable it, and you can also change "Size:" to another text.
        // but you can just set fixed minWidth on stage.
    }

    companion object {
        lateinit var windowInstance: Window
        var width: Double = 0.0
        var height: Double = 0.0
    }
}