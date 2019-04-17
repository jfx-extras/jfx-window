package com.mairwunnx.kdemo

import javafx.scene.layout.HBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.stage.Stage
import javafx.stage.StageStyle
import jfxwindow.base.Window
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

        stage.widthProperty().addListener { observableValue, _, _ ->
            window.windowBase.windowPart.calculateMinWidthSizeByTitleBar()
        }

        stage.heightProperty().addListener { observableValue, _, _ ->
            window.windowBase.windowPart.calculateMinWidthSizeByTitleBar()
        }
    }

    companion object {
        lateinit var windowInstance: Window
    }
}