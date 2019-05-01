package com.mairwunnx.kdemo

import javafx.geometry.Insets
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import jfxwindow.enums.ShadowStyle
import tornadofx.*

class ShadowView : View() {
    override val root: VBox = vbox {
        minHeight = 10.0
        prefWidth = 161.0
        hgrow = Priority.ALWAYS

        style {
            backgroundColor = MultiValue(arrayOf(c("#fff")))
        }

        label("Shadow") {
            font = Font.font("Segoe UI Semilight", 29.0)
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 20.0))
        }

        togglebutton("switch shadow isEnabled") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                Application.windowInstance.instance.shadowPart.windowShadowIsEnabled = this.isSelected
            }
        }

        togglebutton("switch shadow type") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                when {
                    this.isSelected -> Application.windowInstance.instance.shadowPart.windowShadowType =
                        ShadowStyle.WIN32
                    else -> Application.windowInstance.instance.shadowPart.windowShadowType = ShadowStyle.MATERIAL
                }
            }
        }
    }
}