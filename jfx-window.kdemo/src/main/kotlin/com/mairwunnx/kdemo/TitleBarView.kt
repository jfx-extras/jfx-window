package com.mairwunnx.kdemo

import javafx.geometry.Insets
import javafx.geometry.NodeOrientation
import javafx.scene.control.TextField
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import jfxwindow.enums.TitleBarTheme
import tornadofx.*
import com.mairwunnx.kdemo.Application.Companion.windowInstance as window

class TitleBarView : View() {
    private lateinit var barBackgroundColorResult: TextField
    private lateinit var barBackgroundColor: TextField
    private lateinit var barShadowDepthResult: TextField
    private lateinit var barShadowDepth: TextField

    override val root: VBox = vbox {
        minHeight = 10.0
        prefWidth = 161.0
        hgrow = Priority.ALWAYS

        style {
            backgroundColor = MultiValue(arrayOf(c("#fff")))
        }

        label("TitleBar") {
            font = Font.font("Segoe UI Semilight", 29.0)
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 20.0))
        }

        button("get bar background color") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                barBackgroundColorResult.text =
                    window.instance.titleBarPart.titleBackground.toString()
            }
        }

        barBackgroundColorResult = textfield {
            promptText = "bar background color result"
        }

        button("set bar background color") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                window.instance.titleBarPart.titleBackground = c(barBackgroundColor.text)
            }
        }

        barBackgroundColor = textfield {
            promptText = "bar background color"
        }

        togglebutton("switch bar order") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                when {
                    this.isSelected -> window.instance.titleBarPart.order =
                        NodeOrientation.RIGHT_TO_LEFT
                    else -> window.instance.titleBarPart.order = NodeOrientation.LEFT_TO_RIGHT
                }
            }
        }

        togglebutton("switch context menu is enabled") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0

            setOnAction {
                window.instance.contextPart.contextMenuIsEnabled = this.isSelected
            }
        }

        togglebutton("switch context menu spacing") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0

            setOnAction {
                window.instance.contextPart.spacingIsEnabled = this.isSelected
            }
        }

        var iterations = 0

        button("switch theme") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0

            setOnAction {
                if (iterations == 0) {
                    window.instance.titleBarPart.theme = TitleBarTheme.AUTO
                    iterations =+ 1
                    this.text = "theme: AUTO"
                } else if (iterations == 1) {
                    window.instance.titleBarPart.theme = TitleBarTheme.LIGHT
                    iterations =+ 2
                    this.text = "theme: LIGHT"
                } else if (iterations == 2) {
                    window.instance.titleBarPart.theme = TitleBarTheme.DARK
                    iterations = 0
                    this.text = "theme: DARK"
                }
            }
        }

        button("get bar shadow depth") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                barShadowDepthResult.text = window.instance.titleBarPart.shadowDepth.name
            }
        }

        barShadowDepthResult = textfield {
            promptText = "bar shadow depth result"
        }

        button("set bar shadow depth") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                window.instance.titleBarPart.shadowDepth =
                    enumValueOf("DEPTH${barShadowDepth.text}")
            }
        }

        barShadowDepth = textfield {
            promptText = "type here bar shadow depth"
        }

        label("Type shadow depth as 0 - 5. e.g \"2\". For disable type 0. Without quotes!") {
            isWrapText = true
            VBox.setMargin(this, Insets(5.0, 0.0, 0.0, 5.0))
        }
    }
}
