package com.mairwunnx.kdemo

import javafx.geometry.Insets
import javafx.scene.control.TextField
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.util.Duration
import tornadofx.*
import com.mairwunnx.kdemo.Application.Companion.windowInstance as window

class WindowView : View() {
    private lateinit var animationDurationResult: TextField
    private lateinit var animationDuration: TextField
    private lateinit var disabledOpacityResult: TextField
    private lateinit var disabledOpacity: TextField

    override val root: VBox = vbox {
        minHeight = 10.0
        prefWidth = 161.0
        hgrow = Priority.ALWAYS

        style {
            backgroundColor = MultiValue(arrayOf(c("#fff")))
        }

        label("Window") {
            font = Font.font("Segoe UI Semilight", 29.0)
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 20.0))
        }

        button("get animation duration") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                animationDurationResult.text = window.windowBase.windowPart.animationDuration.toString()
            }
        }

        animationDurationResult = textfield {
            promptText = "anim. duration result"
        }

        button("set animation duration") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                window.windowBase.windowPart.animationDuration = Duration.millis(animationDuration.text.toDouble())
            }
        }

        animationDuration = textfield {
            promptText = "type here duration in millis"
        }

        togglebutton("switch enable animation") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                window.windowBase.windowPart.smoothColorAnim = this.isSelected
            }
        }

        togglebutton("switch saving position") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0

            setOnAction {
                window.windowBase.windowPart.saveWindowPosition = this.isSelected
            }
        }

        togglebutton("switch is resizable") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0

            setOnAction {
                window.windowBase.windowPart.isResizable = this.isSelected
            }
        }

        togglebutton("switch is draggable") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0

            setOnAction {
                window.windowBase.windowPart.isDraggable = this.isSelected
            }
        }

        togglebutton("switch is maximizable") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0

            setOnAction {
                window.windowBase.windowPart.isMaximizable = this.isSelected
            }
        }

        togglebutton("switch is minimizable") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0

            setOnAction {
                window.windowBase.windowPart.isMinimizable = this.isSelected
            }
        }

        togglebutton("switch is closable") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0

            setOnAction {
                window.windowBase.windowPart.isClosable = this.isSelected
            }
        }

        button("get btn disabled opacity") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                disabledOpacityResult.text = window.windowBase.windowPart.disabledOpacity.toString()
            }
        }

        disabledOpacityResult = textfield {
            promptText = "btn disabled opacity result"
        }

        button("set btn disabled opacity") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                window.windowBase.windowPart.disabledOpacity = disabledOpacity.text.toDouble()
            }
        }

        disabledOpacity = textfield {
            promptText = "type here new btn disabled opacity"
        }
    }
}