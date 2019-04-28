package com.mairwunnx.kdemo

import javafx.geometry.Insets
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import tornadofx.*

class TitleView : View() {
    private lateinit var titleTextResult: TextField
    private lateinit var titleText: TextField
    private lateinit var titleAlignmentResult: TextField
    private lateinit var titleAlignment: TextField
    private lateinit var titleTextFontResult: TextArea
    private lateinit var titleTextFont: TextField

    override val root: VBox = vbox {
        minHeight = 10.0
        prefWidth = 161.0
        hgrow = Priority.ALWAYS

        style {
            backgroundColor = MultiValue(arrayOf(c("#fff")))
        }

        label("Title") {
            font = Font.font("Segoe UI Semilight", 29.0)
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 20.0))
        }

        button("get title text") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                titleTextResult.text = Application.windowInstance.instance.titlePart.titleText
            }
        }

        titleTextResult = textfield {
            promptText = "title text result"
        }

        button("set title text") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                Application.windowInstance.instance.titlePart.titleText = titleText.text
            }
        }

        titleText = textfield {
            promptText = "type here new title text"
        }

        togglebutton("switch title visibility") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                Application.windowInstance.instance.titlePart.titleIsVisible = this.isSelected
            }
        }

        button("get title alignment") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                titleAlignmentResult.text = Application.windowInstance.instance.titlePart.titleAlignment.name
            }
        }

        titleAlignmentResult = textfield {
            promptText = "title alignment result"
        }

        button("set title alignment") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                Application.windowInstance.instance.titlePart.titleAlignment = enumValueOf(titleAlignment.text)
            }
        }

        titleAlignment = textfield {
            promptText = "type here title alignment"
        }

        button("get title text font") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                titleTextFontResult.text = Application.windowInstance.instance.titlePart.titleTextFont.toString()
            }
        }

        titleTextFontResult = textarea {
            promptText = "get title text font result"
        }

        button("set title text font") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                Application.windowInstance.instance.titlePart.titleTextFont =
                    Font.font(
                        titleTextFont.text.split(';')[0],
                        titleTextFont.text.split(';')[1].toDouble()
                    )
            }
        }

        titleTextFont = textfield {
            promptText = "type here title text font"
        }

        label("Type font as Segoe UI;16 - When Segoe UI is font, 16 is font size.") {
            isWrapText = true
            VBox.setMargin(this, Insets(5.0, 0.0, 0.0, 5.0))
        }
    }
}