package com.mairwunnx.kdemo

import javafx.geometry.Insets
import javafx.scene.control.TextField
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import tornadofx.*
import com.mairwunnx.kdemo.Application.Companion.windowInstance as window

class ButtonView : View() {
    private lateinit var buttonHoverColorResult: TextField
    private lateinit var buttonHoverColor: TextField
    private lateinit var buttonPressedColorResult: TextField
    private lateinit var buttonPressedColor: TextField

    override val root: VBox = vbox {
        minHeight = 10.0
        prefWidth = 161.0
        hgrow = Priority.ALWAYS

        style {
            backgroundColor = MultiValue(arrayOf(c("#fff")))
        }

        label("Button") {
            font = Font.font("Segoe UI Semilight", 29.0)
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 20.0))
        }

        button("get button hover color") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                buttonHoverColorResult.text = window.windowBase.buttonPart.buttonHoverColor.toString()
            }
        }

        buttonHoverColorResult = textfield {
            promptText = "button hover color result"
        }

        button("set button hover color") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                window.windowBase.buttonPart.buttonHoverColor = c(buttonHoverColor.text)
            }
        }

        buttonHoverColor = textfield {
            promptText = "type here button hover color"
        }

        button("get button pressed color") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                buttonPressedColorResult.text = window.windowBase.buttonPart.buttonPressedColor.toString()
            }
        }

        buttonPressedColorResult = textfield {
            promptText = "button pressed color result"
        }

        button("set button pressed color") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                window.windowBase.buttonPart.buttonPressedColor = c(buttonPressedColor.text)
            }
        }

        buttonPressedColor = textfield {
            promptText = "type here button pressed color"
        }

        togglebutton("switch button tooltips") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                window.windowBase.buttonPart.tooltipIsEnabled = this.isSelected
            }
        }

        togglebutton("close button is visible") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0

            setOnAction {
                window.windowBase.buttonPart.closeButtonIsVisible = this.isSelected
            }
        }

        togglebutton("max button is visible") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0

            setOnAction {
                window.windowBase.buttonPart.maxButtonIsVisible = this.isSelected
            }
        }

        togglebutton("min button is visible") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0

            setOnAction {
                window.windowBase.buttonPart.minButtonIsVisible = this.isSelected
            }
        }
    }
}