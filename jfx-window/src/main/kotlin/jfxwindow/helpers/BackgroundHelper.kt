package jfxwindow.helpers

import javafx.geometry.Insets
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.Region
import javafx.scene.paint.Color

@Suppress("RedundantUnitReturnType")
internal class BackgroundHelper {
    internal fun changeRegionBackground(region: Region, color: Color): Unit {
        region.backgroundProperty().value = (Background(
            BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)
        ))
    }
}
