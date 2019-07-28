@file:Suppress("RedundantUnitReturnType")

package jfxwindow.helpers

import javafx.scene.layout.BorderWidths
import jfxwindow.base.WindowBase

internal fun installBorderStateHelper(windowBase: WindowBase): Unit {
    windowBase.windowUi.windowTitleBarPane.borderProperty().addListener { _,
                                                                          _,
                                                                          _ ->
        if (windowBase.borderPart.borderChangeRestricted) {
            if (windowBase.borderPart.bottomBorderIsVisible) {
                windowBase.borderPart.setBottomBorderIsVisible(
                    BorderWidths(
                        0.0, 0.0, 1.0, 0.0
                    )
                )
            } else {
                windowBase.borderPart.setBottomBorderIsVisible(BorderWidths(0.0))
            }
        }
    }
}
