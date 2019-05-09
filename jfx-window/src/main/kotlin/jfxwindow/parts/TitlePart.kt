package jfxwindow.parts

import javafx.scene.text.Font
import jfxwindow.base.WindowBase
import jfxwindow.enums.TitleAlignment

/**
 * Contains some methods and properties allowing to
 * work with the window title.
 */
@Suppress(
    "RedundantVisibilityModifier",
    "MemberVisibilityCanBePrivate",
    "RedundantUnitReturnType"
)
public class TitlePart(private val windowBase: WindowBase) {
    private var titleAlignmentHelper: TitleAlignment = TitleAlignment.LEFT

    internal fun init(): Unit {
        titleAlignmentHelper = windowBase.windowOptions.titleAlignment
        titleIsVisible = windowBase.windowOptions.titleIsVisible
        titleAlignment = windowBase.windowOptions.titleAlignment
        titleText = windowBase.windowOptions.titleText
        titleTextFont = windowBase.windowOptions.titleTextFont
    }

    /**
     * Title alignment in title-bar space.
     */
    public var titleAlignment: TitleAlignment
        get() = titleAlignmentHelper
        set(side) {
            when (side) {
                TitleAlignment.LEFT -> {
                    if (titleIsVisible) {
                        windowBase.windowUi.titleCenter.isVisible = false
                        windowBase.windowUi.titleCenter.isManaged = false
                        windowBase.windowUi.title.isVisible = true
                        windowBase.windowUi.title.isManaged = true
                    }

                    titleAlignmentHelper = TitleAlignment.LEFT
                }
                TitleAlignment.CENTER -> {
                    if (titleIsVisible) {
                        windowBase.windowUi.titleCenter.isVisible = true
                        windowBase.windowUi.titleCenter.isManaged = true
                        windowBase.windowUi.title.isVisible = false
                        windowBase.windowUi.title.isManaged = false
                    }

                    titleAlignmentHelper = TitleAlignment.CENTER
                }
            }
        }

    /**
     * TitleBar title text or title content.
     */
    public var titleText: String
        get() = windowBase.windowUi.title.text
        set(text) {
            windowBase.windowUi.title.text = text
            windowBase.windowUi.titleCenter.text = text
            windowBase.windowOptions.stage.titleProperty().unbind()
            windowBase.windowOptions.stage.title = text
        }

    /**
     * TitleBar title text font family or just font name.
     */
    public var titleTextFont: Font
        get() = windowBase.windowUi.title.font
        set(font) {
            windowBase.windowUi.title.font = font
            windowBase.windowUi.titleCenter.font = font
        }

    /**
     * TitleBar title visibility status.
     */
    public var titleIsVisible: Boolean
        get() = if (titleAlignment == TitleAlignment.CENTER) {
            windowBase.windowUi.titleCenter.isVisible
        } else {
            windowBase.windowUi.title.isVisible
        }
        set(isVisible) {
            if (isVisible) {
                if (titleAlignment == TitleAlignment.CENTER) {
                    windowBase.windowUi.titleCenter.isVisible = isVisible
                    windowBase.windowUi.titleCenter.isManaged = isVisible
                    windowBase.windowUi.title.isVisible = false
                    windowBase.windowUi.title.isManaged = false
                } else {
                    windowBase.windowUi.titleCenter.isVisible = false
                    windowBase.windowUi.titleCenter.isManaged = false
                    windowBase.windowUi.title.isVisible = isVisible
                    windowBase.windowUi.title.isManaged = isVisible
                }
            } else {
                windowBase.windowUi.title.isVisible = false
                windowBase.windowUi.title.isManaged = false
                windowBase.windowUi.titleCenter.isVisible = false
                windowBase.windowUi.titleCenter.isManaged = false
            }
        }
}
