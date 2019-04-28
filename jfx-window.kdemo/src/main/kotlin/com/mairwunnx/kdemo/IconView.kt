package com.mairwunnx.kdemo

import javafx.geometry.Insets
import javafx.scene.control.TextField
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import tornadofx.*
import com.mairwunnx.kdemo.Application.Companion.windowInstance as window

class IconView : View() {
    private lateinit var iconSourceResult: TextField
    private lateinit var iconSource: TextField
    private lateinit var iconIsSvgResult: TextField
    private lateinit var svgIconZoomResult: TextField
    private lateinit var svgIconZoom: TextField

    override val root: VBox = vbox {
        minHeight = 10.0
        prefWidth = 161.0
        hgrow = Priority.ALWAYS

        style {
            backgroundColor = MultiValue(arrayOf(c("#fff")))
        }

        label("Icon") {
            font = Font.font("Segoe UI Semilight", 29.0)
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 20.0))
        }

        button("get icon source") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                iconSourceResult.text = window.instance.iconPart.icon
            }
        }

        iconSourceResult = textfield {
            promptText = "icon source result"
        }

        button("set icon source") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                window.instance.iconPart.icon = iconSource.text
            }
        }

        iconSource = textfield {
            promptText = "type here new icon source"
        }

        togglebutton("switch icon visibility") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                window.instance.iconPart.iconIsVisible = this.isSelected
            }
        }

        button("get icon is svg") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                iconIsSvgResult.text = window.instance.iconPart.iconIsSvg.toString()
            }
        }

        iconIsSvgResult = textfield {
            promptText = "icon is svg result"
        }

        button("get svg icon zoom") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                svgIconZoomResult.text = window.instance.iconPart.svgIconZoom.toString()
            }
        }

        svgIconZoomResult = textfield {
            promptText = "svg icon zoom result"
        }

        button("set svg icon zoom") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                window.instance.iconPart.svgIconZoom = svgIconZoom.text.toDouble()
            }
        }

        svgIconZoom = textfield {
            promptText = "type here new svg icon zoom"
        }

        button("remove icon") {
            isFocusTraversable = false
            isMnemonicParsing = false
            maxHeight = Double.MAX_VALUE
            maxWidth = Double.MAX_VALUE
            prefHeight = 25.0
            prefWidth = 170.0
            VBox.setMargin(this, Insets(10.0, 0.0, 0.0, 0.0))

            setOnAction {
                window.instance.iconPart.removeIcon()
            }
        }

        label("If you remove icon, then you need set new icon, for new icon.") {
            isWrapText = true
            VBox.setMargin(this, Insets(5.0, 0.0, 0.0, 5.0))
        }
    }
}