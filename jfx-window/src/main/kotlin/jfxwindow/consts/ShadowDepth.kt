package jfxwindow.consts

import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color

@Deprecated("in jfx-window-8.0.3.X-beta version it be moved to just file.")
internal class ShadowDepth {
    companion object {
        val DEPTH0 = DropShadow(BlurType.GAUSSIAN, Color(0.0, 0.0, 0.0, 0.0), 0.0, 0.0, 0.0, 0.0)
        val DEPTH1 = DropShadow(BlurType.GAUSSIAN, Color(0.0, 0.0, 0.0, 0.3), 5.0, 0.3, 0.0, 1.0)
        val DEPTH2 = DropShadow(BlurType.GAUSSIAN, Color(0.0, 0.0, 0.0, 0.3), 8.0, 0.2, 0.0, 1.0)
        val DEPTH3 = DropShadow(BlurType.GAUSSIAN, Color(0.0, 0.0, 0.0, 0.5), 12.0, 0.2, 0.0, 1.0)
        val DEPTH4 = DropShadow(BlurType.GAUSSIAN, Color(0.0, 0.0, 0.0, 0.4), 15.0, 0.2, 0.0, 1.0)
        val DEPTH5 = DropShadow(BlurType.GAUSSIAN, Color(0.0, 0.0, 0.0, 0.5), 19.0, 0.2, 0.0, 1.0)
    }
}
