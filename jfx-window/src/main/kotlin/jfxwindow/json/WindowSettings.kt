package jfxwindow.json

import kotlinx.serialization.*

@Serializable
data class WindowSettings(
    val window: Window
) {
    @Serializable
    data class Window(
        val positions: Positions,
        val sizes: Sizes,
        val states: States
    ) {
        @Serializable
        data class Sizes(
            val height: String,
            val width: String
        )

        @Serializable
        data class Positions(
            val x: String,
            val y: String
        )

        @Serializable
        data class States(
            val isMaximized: String,
            val isMinimized: String
        )
    }
}
