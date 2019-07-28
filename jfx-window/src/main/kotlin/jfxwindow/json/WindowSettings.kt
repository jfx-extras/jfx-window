package jfxwindow.json

import kotlinx.serialization.Serializable

@Serializable
internal data class WindowSettings(
    internal val window: Window
) {
    @Serializable
    internal data class Window(
        internal val positions: Positions,
        internal val sizes: Sizes,
        internal val states: States
    ) {
        @Serializable
        internal data class Sizes(
            internal val height: String,
            internal val width: String
        )

        @Serializable
        internal data class Positions(
            internal val x: String,
            internal val y: String
        )

        @Serializable
        internal data class States(
            internal val isMaximized: String,
            internal val isMinimized: String
        )
    }
}
