package jfxwindow.parts

import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.effect.Effect
import javafx.scene.paint.Color
import jfxwindow.base.WindowOptions
import jfxwindow.base.WindowUi
import jfxwindow.enums.ShadowStyle

class ShadowPart {
    @get:JvmSynthetic
    @set:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions
    @get:JvmSynthetic
    @set:JvmSynthetic
    internal lateinit var windowUiInstance: WindowUi

    private lateinit var windowShadowStyleHelper: ShadowStyle
    private var windowShadowIsEnabledHelper: Boolean = false
    private var savedShadow: Effect? = null

    @JvmSynthetic
    internal fun applyShadowProperties() {
        windowOptionsInstance.stage.scene.root.style = "-fx-background: #fff;"
        windowUiInstance.windowShadowPane.style = "-fx-background-color: transparent;"

        windowOptionsInstance.stage.scene.fill = Color.TRANSPARENT
        windowShadowStyleHelper = windowOptionsInstance.windowShadowType
        windowShadowIsEnabledHelper = windowOptionsInstance.windowShadowIsEnabled
        windowShadowIsEnabled = windowOptionsInstance.windowShadowIsEnabled
        windowShadowType = windowOptionsInstance.windowShadowType
    }

    var windowShadowType: ShadowStyle
        get() = windowShadowStyleHelper
        set(shadowStyle) {
            windowShadowStyleHelper = shadowStyle

            if (!windowShadowIsEnabledHelper) {
                savedShadow = when (shadowStyle) {
                    ShadowStyle.WIN32 -> DropShadow(BlurType.GAUSSIAN, Color(0.0, 0.0, 0.0, 0.1), 30.0, 0.5, 0.0, 0.0)
                    else -> DropShadow(BlurType.GAUSSIAN, Color(0.0, 0.0, 0.0, 0.2), 10.0, 0.5, 0.0, 0.0)
                }
            } else {
                return when (shadowStyle) {
                    ShadowStyle.WIN32 -> windowUiInstance.windowPane.effect =
                        DropShadow(BlurType.GAUSSIAN, Color(0.0, 0.0, 0.0, 0.1), 30.0, 0.5, 0.0, 0.0)
                    else -> windowUiInstance.windowPane.effect =
                        DropShadow(BlurType.GAUSSIAN, Color(0.0, 0.0, 0.0, 0.2), 10.0, 0.5, 0.0, 0.0)
                }
            }
        }

    var windowShadowIsEnabled: Boolean
        get() = windowShadowIsEnabledHelper
        set(isEnabled) {
            windowShadowIsEnabledHelper = isEnabled

            if (isEnabled) {
                if (savedShadow != null) windowUiInstance.windowPane.effect = savedShadow
            } else {
                savedShadow = windowUiInstance.windowPane.effect
                windowUiInstance.windowPane.effect =
                    DropShadow(BlurType.GAUSSIAN, Color(0.0, 0.0, 0.0, 0.0), 0.0, 0.0, 0.0, 0.0)
            }
        }
}
