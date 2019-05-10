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
import jfxwindow.base.WindowBase

/**
 * A class that helps in playing the animation of some elements,
 * but from the public only an extra animation modifier is available.
 */
@Suppress("RedundantVisibilityModifier", "RedundantUnitReturnType")
public class AnimationHelper(private val windowBase: WindowBase) {
    private val rectangle = Rectangle()
    private val fillTransition = FillTransition()
    /**
     * It extra variable, controlling and fix not fully animation playing.
     * **Change it only if you know what you do!**
     *
     * Default value is 0.2.
     */
    public var animationModifier: Double = 0.2

    internal fun animateRegionColor(
        control: Region,
        baseColor: Color,
        toColor: Color
    ): Unit {
        if (windowBase.windowPart.smoothColorAnim) {
            rectangle.fill = baseColor
            fillTransition.shape = rectangle
            fillTransition.duration = windowBase.windowPart.animationDuration
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
