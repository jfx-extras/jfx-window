package jfxwindow.parts

import javafx.geometry.Insets
import javafx.geometry.NodeOrientation
import javafx.geometry.Pos
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import javafx.stage.Screen
import jfxwindow.base.WindowOptions
import jfxwindow.base.WindowUi
import jfxwindow.enums.TitleShadowDepth
import jfxwindow.helpers.AnimationHelper
import jfxwindow.helpers.WindowColorHelper

class TitleBarPart {
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var animHelperInstance: AnimationHelper
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowUiInstance: WindowUi
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowPart: WindowPart
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var titleActiveColor: Color
    lateinit var titleInactiveBackground: Color
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var titleActiveShadow: TitleShadowDepth
    lateinit var titleInactiveShadow: TitleShadowDepth

    @JvmSynthetic
    internal fun updateTitleBarFills(color: Color) {
        windowUiInstance.win32CloseIcon.fill = WindowColorHelper.getCalculatedColor(color)
        windowUiInstance.win32MaxIcon.fill = WindowColorHelper.getCalculatedColor(color)
        windowUiInstance.win32UnMaxIcon.fill = WindowColorHelper.getCalculatedColor(color)
        windowUiInstance.win32MinIcon.fill = WindowColorHelper.getCalculatedColor(color)
        windowUiInstance.title.textFill = WindowColorHelper.getCalculatedColor(color)
        windowUiInstance.titleCenter.textFill = WindowColorHelper.getCalculatedColor(color)
    }

    @JvmSynthetic
    internal fun applyResizeProperties() {
        if (windowOptionsInstance.resizeLimit) if (windowOptionsInstance.stage.minHeight < 65.0) windowOptionsInstance.stage.minHeight = 65.0
        if (windowOptionsInstance.resizeLimit) if (windowOptionsInstance.stage.minWidth < 135.0) windowOptionsInstance.stage.minWidth = 145.0
    }

    @JvmSynthetic
    internal fun applyTitleBarProperties() {
        windowUiInstance.windowPane.setPrefSize(windowOptionsInstance.stage.width, windowOptionsInstance.stage.height)
        order = windowOptionsInstance.titleBarOrder

        titleActiveColor = titleBackground
        titleInactiveBackground = windowOptionsInstance.titleBarInactiveBackground

        applyMaximizedProperties()
        applyShadowProperties()

        titleActiveShadow = shadowDepth
        titleInactiveShadow = windowOptionsInstance.titleBarInactiveShadowDepth
    }

    @JvmSynthetic
    internal fun applyShadowProperties() {
        when {
            windowOptionsInstance.titleBarShadowDepth == TitleShadowDepth.DEPTH0 -> windowUiInstance.windowTitleBarPane.effect =
                    jfxwindow.consts.ShadowDepth.DEPTH0
            windowOptionsInstance.titleBarShadowDepth == TitleShadowDepth.DEPTH1 -> windowUiInstance.windowTitleBarPane.effect =
                    jfxwindow.consts.ShadowDepth.DEPTH1
            windowOptionsInstance.titleBarShadowDepth == TitleShadowDepth.DEPTH2 -> windowUiInstance.windowTitleBarPane.effect =
                    jfxwindow.consts.ShadowDepth.DEPTH2
            windowOptionsInstance.titleBarShadowDepth == TitleShadowDepth.DEPTH3 -> windowUiInstance.windowTitleBarPane.effect =
                    jfxwindow.consts.ShadowDepth.DEPTH3
            windowOptionsInstance.titleBarShadowDepth == TitleShadowDepth.DEPTH4 -> windowUiInstance.windowTitleBarPane.effect =
                    jfxwindow.consts.ShadowDepth.DEPTH4
            windowOptionsInstance.titleBarShadowDepth == TitleShadowDepth.DEPTH5 -> windowUiInstance.windowTitleBarPane.effect =
                    jfxwindow.consts.ShadowDepth.DEPTH5
        }
    }

    @JvmSynthetic
    internal fun applyMaximizedProperties() {
        if (windowOptionsInstance.stage.isMaximized) {
            val screen = Screen.getPrimary()
            val bounds = screen.visualBounds

            windowOptionsInstance.stage.x = bounds.minX
            windowOptionsInstance.stage.y = bounds.minY
            windowOptionsInstance.stage.width = bounds.width
            windowOptionsInstance.stage.height = bounds.height

            windowUiInstance.buttonContainer.alignment = Pos.CENTER_RIGHT
            windowUiInstance.win32MaxButton.isManaged = false
            windowUiInstance.win32MaxButton.isVisible = false
        } else {
            windowUiInstance.win32UnMaxButton.isManaged = false
            windowUiInstance.win32UnMaxButton.isVisible = false
        }
    }

    @JvmSynthetic
    internal fun applyTitleBarColor() {
        windowUiInstance.windowTitleBarPane.background = (Background(BackgroundFill(windowOptionsInstance.titleBarBackground, CornerRadii.EMPTY, Insets.EMPTY)))
        updateTitleBarFills(windowOptionsInstance.titleBarBackground)
    }

    var titleBackground: Color
        get() = Color.web(windowUiInstance.windowTitleBarPane.background.fills[0].fill.toString())
        set(backgroundColor) {
            animHelperInstance.animateRegionColor(windowUiInstance.windowTitleBarPane, titleBackground, backgroundColor)
            updateTitleBarFills(backgroundColor)
        }

    var order: NodeOrientation
        get() = windowUiInstance.windowTitleBarPane.nodeOrientation
        set(order) {
            windowUiInstance.windowTitleBarPane.nodeOrientation = order
        }

    var shadowDepth: TitleShadowDepth
        get() {
            when {
                windowUiInstance.windowTitleBarPane.effect == jfxwindow.consts.ShadowDepth.DEPTH0 -> return TitleShadowDepth.DEPTH0
                windowUiInstance.windowTitleBarPane.effect == jfxwindow.consts.ShadowDepth.DEPTH1 -> return TitleShadowDepth.DEPTH1
                windowUiInstance.windowTitleBarPane.effect == jfxwindow.consts.ShadowDepth.DEPTH2 -> return TitleShadowDepth.DEPTH2
                windowUiInstance.windowTitleBarPane.effect == jfxwindow.consts.ShadowDepth.DEPTH3 -> return TitleShadowDepth.DEPTH3
                windowUiInstance.windowTitleBarPane.effect == jfxwindow.consts.ShadowDepth.DEPTH4 -> return TitleShadowDepth.DEPTH4
                windowUiInstance.windowTitleBarPane.effect == jfxwindow.consts.ShadowDepth.DEPTH5 -> return TitleShadowDepth.DEPTH5
            }

            return TitleShadowDepth.DEPTH0
        }
        set(depth) {
            when (depth) {
                TitleShadowDepth.DEPTH0 -> windowUiInstance.windowTitleBarPane.effect =
                        jfxwindow.consts.ShadowDepth.DEPTH0
                TitleShadowDepth.DEPTH1 -> windowUiInstance.windowTitleBarPane.effect =
                        jfxwindow.consts.ShadowDepth.DEPTH1
                TitleShadowDepth.DEPTH2 -> windowUiInstance.windowTitleBarPane.effect =
                        jfxwindow.consts.ShadowDepth.DEPTH2
                TitleShadowDepth.DEPTH3 -> windowUiInstance.windowTitleBarPane.effect =
                        jfxwindow.consts.ShadowDepth.DEPTH3
                TitleShadowDepth.DEPTH4 -> windowUiInstance.windowTitleBarPane.effect =
                        jfxwindow.consts.ShadowDepth.DEPTH4
                TitleShadowDepth.DEPTH5 -> windowUiInstance.windowTitleBarPane.effect =
                        jfxwindow.consts.ShadowDepth.DEPTH5
            }
        }
}
