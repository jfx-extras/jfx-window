@file:Suppress("RedundantVisibilityModifier", "unused")

package jfxwindow.helpers

import javafx.scene.paint.Color

/**
 * Return true if color is dark, return false if color is light.
 *
 * @param color what need to calculate for getting result.
 * @return color isDark result as boolean value.
 */
public fun Color.isDarkColor(color: Color): Boolean {
    val value = color.toString().split("x")[1]

    val red = Integer.parseInt(value.substring(1, 1 + 2), 16)
    val green = Integer.parseInt(value.substring(3, 3 + 2), 16)
    val blue = Integer.parseInt(value.substring(5, 5 + 2), 16)

    return red + green + blue <= 0xff * 3 / 2
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
public fun Color.getBlackOrWhiteByColor(color: Color): Color {
    val value = color.toString().split("x")[1]

    val red = Integer.parseInt(value.substring(1, 1 + 2), 16)
    val green = Integer.parseInt(value.substring(3, 3 + 2), 16)
    val blue = Integer.parseInt(value.substring(5, 5 + 2), 16)

    return if (red + green + blue <= 0xff * 3 / 2) Color.WHITE else Color.BLACK
}
