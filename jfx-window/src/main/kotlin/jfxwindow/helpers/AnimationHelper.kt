package jfxwindow.helpers

import javafx.animation.Animation
import javafx.animation.FillTransition
import javafx.animation.Interpolator
import javafx.geometry.Insets
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.Region
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.util.Duration
import jfxwindow.parts.WindowPart

/**
 * Animation helper class, contains methods what
 * simplify color interpolations.
 */
class AnimationHelper {
    internal lateinit var windowPart: WindowPart
    private val rectangle = Rectangle()
    private val fillTransition = FillTransition()
    /**
     * It extra variable, controlling and fix not fully animation playing.
     * **Change it only if you know what you do!**
     *
     * Default value is 0.2.
     */
    var animationModifier: Double = 0.2

    @JvmSynthetic
    internal fun animateRegionColor(control: Region, baseColor: Color, toColor: Color) {
        if (windowPart.smoothColorAnim) {
            rectangle.fill = baseColor
            fillTransition.shape = rectangle
            fillTransition.duration = windowPart.animationDuration
            fillTransition.fromValue = baseColor
            fillTransition.toValue = toColor

            if (fillTransition.status == Animation.Status.RUNNING) {
                fillTransition.stop()

                control.backgroundProperty().value = (Background(
                    BackgroundFill(toColor, CornerRadii.EMPTY, Insets.EMPTY)
                ))
            } else {
                fillTransition.interpolator = object : Interpolator() {
                    override fun curve(t: Double): Double {
                        control.backgroundProperty().value =
                            (Background(
                                BackgroundFill(rectangle.fill, CornerRadii.EMPTY, Insets.EMPTY)
                            ))
                        return t + animationModifier
                    }
                }

                fillTransition.play()
            }
        } else {
            control.backgroundProperty().value = (Background(
                BackgroundFill(toColor, CornerRadii.EMPTY, Insets.EMPTY)
            ))
        }
    }
}