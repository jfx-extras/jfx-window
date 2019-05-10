package jfxwindow.parts

import javafx.geometry.Insets
import javafx.geometry.NodeOrientation
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import jfxwindow.base.WindowBase
import jfxwindow.enums.TitleShadowDepth

/**
 * Contains some methods and properties allowing to
 * work with the window title-bar.
 */
@Suppress(
    "RedundantVisibilityModifier",
    "RedundantUnitReturnType",
    "MemberVisibilityCanBePrivate"
)
public class TitleBarPart(private val windowBase: WindowBase) {
    internal lateinit var temporaryTitleColor: Color
    internal lateinit var temporaryTitleShadow: TitleShadowDepth

    internal fun init(): Unit {
        temporaryTitleColor = windowBase.windowOptions.titleBarBackground
        titleInactiveBackground = windowBase.windowOptions.titleBarInactiveBackground
        shadowDepth = windowBase.windowOptions.titleBarShadowDepth
        temporaryTitleShadow = windowBase.windowOptions.titleBarShadowDepth
        titleInactiveShadow = windowBase.windowOptions.titleBarInactiveShadowDepth
        order = windowBase.windowOptions.titleBarOrder
        windowBase.windowUi.windowTitleBarPane.background = (Background(
            BackgroundFill(
                windowBase.windowOptions.titleBarBackground,
                CornerRadii.EMPTY,
                Insets.EMPTY
            )
        ))
        windowBase.titleBarFillsHelper.updateFills(
            windowBase.windowOptions.titleBarBackground
        )
    }

    /**
     * Inactive title-bar background fill color.
     */
    public lateinit var titleInactiveBackground: Color
    /**
     * TitleBar bar shadow depth (not window shadow)
     * for not inactive window.
     */
    public lateinit var titleInactiveShadow: TitleShadowDepth

    /**
     * TitleBar background fill color.
     */
    public var titleBackground: Color
        get() = Color.web(
            windowBase.windowUi.windowTitleBarPane.background.fills[0].fill.toString()
        )
        set(backgroundColor) {
            windowBase.animationHelper.animateRegionColor(
                windowBase.windowUi.windowTitleBarPane,
                titleBackground,
                backgroundColor
            )
            windowBase.titleBarFillsHelper.updateFills(backgroundColor)
        }

    /**
     * TitleBar ui elements order (orientation).
     */
    public var order: NodeOrientation
        get() = windowBase.windowUi.windowTitleBarPane.nodeOrientation
        set(order) {
            windowBase.windowUi.windowTitleBarPane.nodeOrientation = order
        }

    /**
     * TitleBar bar shadow depth (not window shadow).
     */
    public var shadowDepth: TitleShadowDepth
        get() {
            when {
                windowBase.windowUi.windowTitleBarPane.effect ==
                        jfxwindow.consts.ShadowDepth.DEPTH0 -> return TitleShadowDepth.DEPTH0
                windowBase.windowUi.windowTitleBarPane.effect ==
                        jfxwindow.consts.ShadowDepth.DEPTH1 -> return TitleShadowDepth.DEPTH1
                windowBase.windowUi.windowTitleBarPane.effect ==
                        jfxwindow.consts.ShadowDepth.DEPTH2 -> return TitleShadowDepth.DEPTH2
                windowBase.windowUi.windowTitleBarPane.effect ==
                        jfxwindow.consts.ShadowDepth.DEPTH3 -> return TitleShadowDepth.DEPTH3
                windowBase.windowUi.windowTitleBarPane.effect ==
                        jfxwindow.consts.ShadowDepth.DEPTH4 -> return TitleShadowDepth.DEPTH4
                windowBase.windowUi.windowTitleBarPane.effect ==
                        jfxwindow.consts.ShadowDepth.DEPTH5 -> return TitleShadowDepth.DEPTH5
            }

            return TitleShadowDepth.DEPTH0
        }
        set(depth) {
            when (depth) {
                TitleShadowDepth.DEPTH0 -> windowBase.windowUi.windowTitleBarPane.effect =
                    jfxwindow.consts.ShadowDepth.DEPTH0
                TitleShadowDepth.DEPTH1 -> windowBase.windowUi.windowTitleBarPane.effect =
                    jfxwindow.consts.ShadowDepth.DEPTH1
                TitleShadowDepth.DEPTH2 -> windowBase.windowUi.windowTitleBarPane.effect =
                    jfxwindow.consts.ShadowDepth.DEPTH2
                TitleShadowDepth.DEPTH3 -> windowBase.windowUi.windowTitleBarPane.effect =
                    jfxwindow.consts.ShadowDepth.DEPTH3
                TitleShadowDepth.DEPTH4 -> windowBase.windowUi.windowTitleBarPane.effect =
                    jfxwindow.consts.ShadowDepth.DEPTH4
                TitleShadowDepth.DEPTH5 -> windowBase.windowUi.windowTitleBarPane.effect =
                    jfxwindow.consts.ShadowDepth.DEPTH5
            }
        }
}
