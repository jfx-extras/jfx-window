package com.mairwunnx.kdemo

import javafx.scene.layout.HBox
import tornadofx.View
import tornadofx.hbox
import tornadofx.plusAssign
import com.mairwunnx.kdemo.Application.Companion.windowInstance as window

class BaseView : View("jfx-window") {
    private val titleView: TitleView by inject()
    private val iconView: IconView by inject()
    private val windowView: WindowView by inject()
    override val root: HBox = hbox()

    init {
        root += titleView
        root += iconView
        root += windowView
    }
}