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
        /*
        ↓ It is necessary in order to have the opportunity
        to set a shadow for the window, in case you make
        a mistake or comment out the line above, an exception
        will be thrown.
         */
        stage.initStyle(StageStyle.TRANSPARENT)

        /*
        ↓ It window instance, it need because it instance
        will used for creating window after creating stage.

        Or it also can use for further use in controllers.
         */
        val window = Window(stage)
            .titleTextFont(
                Font.loadFont(
                    javaClass.classLoader.getResource("segoeui.ttf").toString(),
                    12.0
                )
            )
            .titleText("jfx-window")
            .saveWindowPosition(true)
            .borderColor(Color.BLACK)
            .borderInactiveColor(Color.DARKGRAY)
            .windowRootElement(HBox())
            .build()

        windowInstance = window
        super.start(stage)
        /*
        ↓ It line just do creating window, but it need
         use after line upper ↑ (after creating stage).
         */
        window.create()
        /*
        ↓ it test of exhibiting incompatible size for stage.
        if size so small, it make stage with default min size.

        but for it comment addListeners(stage) line for
        see effect after uncomment ↓ line.
         */
        // stage.minWidth = 0.0
    }

    companion object {
        lateinit var windowInstance: Window
    }
}
