package com.mairwunnx.kdemo

import javafx.scene.layout.HBox
import tornadofx.View

class BaseView : View() {
    override val root: HBox by fxml("/demo.fxml")
}