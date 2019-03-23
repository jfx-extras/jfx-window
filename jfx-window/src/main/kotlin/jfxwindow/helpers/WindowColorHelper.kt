package jfxwindow.helpers

import javafx.geometry.Insets
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.Region
import javafx.scene.paint.Color

class WindowColorHelper {
    companion object {
        fun getCalculatedColor(color: Color): Color {
            val value = color.toString().split("x")[1]

            val red = Integer.parseInt(value.substring(1, 1 + 2), 16)
            val green = Integer.parseInt(value.substring(3, 3 + 2), 16)
            val blue = Integer.parseInt(value.substring(5, 5 + 2), 16)

            return if (red + green + blue <= 0xff * 3 / 2) Color.WHITE else Color.BLACK
        }

        @JvmSynthetic
        internal fun changeRegionBackground(region: Region, color: Color) {
            region.backgroundProperty().value = (Background(
                    BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)
            ))
        }
    }
}