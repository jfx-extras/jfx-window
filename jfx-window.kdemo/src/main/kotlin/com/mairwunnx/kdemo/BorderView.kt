package com.mairwunnx.kdemo

import javafx.geometry.Insets
import javafx.scene.control.TextField
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import tornadofx.*

class BorderView : View() {
    private lateinit var borderColorResult: TextField
    private lateinit var borderColor: TextField
    private lateinit var borderInactiveColorResult: TextField
    private lateinit var borderInactiveColor: TextField

    override val root: VBox = vbox {
        minHeight = 10.0
        prefWidth = 161.0
        hgrow = Priority.ALWAYS

        style {
            backgroundColor = MultiValue(arrayOf(c("#fff")))
        }

        label("Border") {
            font = Font.font("Segoe UI Semilight", 29.0)
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 20.0))
        }

        button("get border color") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                borderColorResult.text = Application.windowInstance.windowBase.borderPart.borderColor.toString()
            }
        }

        borderColorResult = textfield {
            promptText = "border color result"
        }

        button("set border color") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                Application.windowInstance.windowBase.borderPart.borderColor = c(borderColor.text)
            }
        }

        borderColor = textfield {
            promptText = "type here border color"
        }

        button("get border inactive color") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                borderInactiveColorResult.text = Application.windowInstance.windowBase.borderPart.borderInactiveColor.toString()
            }
        }

        borderInactiveColorResult = textfield {
            promptText = "border inactive color result"
        }

        button("set border inactive color") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                Application.windowInstance.windowBase.borderPart.borderInactiveColor = c(borderInactiveColor.text)
            }
        }

        borderInactiveColor = textfield {
            promptText = "type here border inactive color"
        }

        togglebutton("switch bottom border visible") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0

            setOnAction {
                Application.windowInstance.windowBase.borderPart.bottomBorderIsVisible = this.isSelected
            }
        }

        togglebutton("switch border visible") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0

            setOnAction {
                Application.windowInstance.windowBase.borderPart.borderIsVisible = this.isSelected
            }
        }
    }
}