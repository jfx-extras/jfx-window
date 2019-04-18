package com.mairwunnx.kdemo

import javafx.scene.layout.HBox
import tornadofx.View

class BaseView : View("jfx-window") {
    override val root: HBox by fxml("/demo.fxml")
}