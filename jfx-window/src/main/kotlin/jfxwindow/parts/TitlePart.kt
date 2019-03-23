package jfxwindow.parts

import javafx.scene.text.Font
import jfxwindow.base.WindowOptions
import jfxwindow.base.WindowUi
import jfxwindow.enums.TitleAlignment

class TitlePart {
    private var titleAlign: TitleAlignment = TitleAlignment.LEFT
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowUiInstance: WindowUi

    @JvmSynthetic
    internal fun applyTitleProperties() {
        titleAlign = windowOptionsInstance.titleAlignment
        titleIsVisible = windowOptionsInstance.titleIsVisible
        titleText = windowOptionsInstance.titleText
        titleAlignment = windowOptionsInstance.titleAlignment
        titleTextFont = windowOptionsInstance.titleTextFont
    }

    var titleAlignment: TitleAlignment
        get() = if (titleAlign == TitleAlignment.CENTER) TitleAlignment.CENTER else TitleAlignment.LEFT
        set(side) {
            when (side) {
                TitleAlignment.LEFT -> {
                    if (titleIsVisible) {
                        windowUiInstance.titleCenter.isVisible = false
                        windowUiInstance.titleCenter.isManaged = false
                        windowUiInstance.title.isVisible = true
                        windowUiInstance.title.isManaged = true
                    }

                    titleAlign = TitleAlignment.LEFT
                }
                TitleAlignment.CENTER -> {
                    if (titleIsVisible) {
                        windowUiInstance.titleCenter.isVisible = true
                        windowUiInstance.titleCenter.isManaged = true
                        windowUiInstance.title.isVisible = false
                        windowUiInstance.title.isManaged = false
                    }

                    titleAlign = TitleAlignment.CENTER
                }
            }
        }

    var titleText: String
        get() = windowUiInstance.title.text
        set(text) {
            windowUiInstance.title.text = text
            windowUiInstance.titleCenter.text = text
        }

    var titleTextFont: Font
        get() = windowUiInstance.title.font
        set(font) {
            windowUiInstance.title.font = font
            windowUiInstance.titleCenter.font = font
        }

    var titleIsVisible: Boolean
        get() = if (titleAlignment == TitleAlignment.CENTER) {
            windowUiInstance.titleCenter.isVisible
        } else {
            windowUiInstance.title.isVisible
        }
        set(isVisible) {
            if (isVisible) {
                if (titleAlignment == TitleAlignment.CENTER) {
                    windowUiInstance.titleCenter.isVisible = isVisible
                    windowUiInstance.titleCenter.isManaged = isVisible
                    windowUiInstance.title.isVisible = false
                    windowUiInstance.title.isManaged = false
                } else {
                    windowUiInstance.titleCenter.isVisible = false
                    windowUiInstance.titleCenter.isManaged = false
                    windowUiInstance.title.isVisible = isVisible
                    windowUiInstance.title.isManaged = isVisible
                }
            } else {
                windowUiInstance.title.isVisible = false
                windowUiInstance.title.isManaged = false
                windowUiInstance.titleCenter.isVisible = false
                windowUiInstance.titleCenter.isManaged = false
            }
        }
}