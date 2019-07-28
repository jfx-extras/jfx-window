@file:Suppress("RedundantVisibilityModifier", "unused")

package jfxwindow.helpers

import javafx.scene.paint.Color

/**
 * Return true if color is dark, return false if color is light.
 *
 * @param color what need to calculate for getting result.
 * @return color isDark result as boolean value.
 */
public fun isDarkColor(color: Color): Boolean {
    return getBrightness(color) < 128
}

public fun isLightColor(color: Color): Boolean {
    return !isDarkColor(color)
}

public fun getBrightness(color: Color): Int {
    val rgbArray = toRGB(color)
    return (rgbArray[0] * 299 + rgbArray[1] * 587 + rgbArray[2] * 114) / 1000
}

public fun toRGB(color: Color): Array<Int> {
    val value = color.toString().split("x")[1]

    return when {
        value.length == 6 -> arrayOf(
            Integer.valueOf(value.substring(0, 2), 16),
            Integer.valueOf(value.substring(2, 4), 16),
            Integer.valueOf(value.substring(4, 6), 16)
        )
        value.length == 8 -> arrayOf(
            Integer.valueOf(value.substring(0, 2), 16),
            Integer.valueOf(value.substring(2, 4), 16),
            Integer.valueOf(value.substring(4, 6), 16),
            Integer.valueOf(value.substring(6, 8), 16)
        )
        else -> arrayOf(
            color.red.toInt(), color.green.toInt(), color.blue.toInt()
        )
    }

}

/**
 * Return WHITE if color is dark, return BLACK if color is light.
 *
 * **In general, I did not want to make this method public,
 * because it is used by the library, but this can be applied
 * in any other application where necessary.**
 *
 * @param color what need to calculate for getting result.
 * @return color which should be used depending on the topic.
 */
public fun getBlackOrWhiteByColor(color: Color): Color {
    return when {
        isDarkColor(color) -> Color.WHITE
        else -> Color.BLACK
    }
}
