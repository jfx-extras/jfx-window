package jfxwindow.base

import javafx.geometry.NodeOrientation
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.stage.Stage
import javafx.util.Duration
import jfxwindow.enums.ButtonStyle
import jfxwindow.enums.ShadowStyle
import jfxwindow.enums.TitleAlignment
import jfxwindow.enums.TitleShadowDepth
import java.io.File

internal class WindowOptions(stageInstance: Stage) {
    private val domain: String = File(
        WindowOptions::class.java.protectionDomain
            .codeSource
            .location.toURI()
            .path
    ).name

    @set:JvmSynthetic @get:JvmSynthetic
    internal var animationDuration: Duration = Duration.millis(200.0)
    @set:JvmSynthetic @get:JvmSynthetic
    internal var smoothColorAnimation: Boolean = true

    @set:JvmSynthetic @get:JvmSynthetic
    internal var borderIsVisible: Boolean = true
    @set:JvmSynthetic @get:JvmSynthetic
    internal var borderColor: Color = Color.web("#464646")
    @set:JvmSynthetic @get:JvmSynthetic
    internal var borderInactiveColor: Color = Color.web("#A5A5A5")

    @set:JvmSynthetic @get:JvmSynthetic
    internal var contextMenuIsEnabled: Boolean = true

    @set:JvmSynthetic @get:JvmSynthetic
    internal var icon: String = ""
    @set:JvmSynthetic @get:JvmSynthetic
    internal var iconIsVisible: Boolean = false

    @set:JvmSynthetic @get:JvmSynthetic
    internal var isClosable: Boolean = true
    @set:JvmSynthetic @get:JvmSynthetic
    internal var closeButtonIsVisible: Boolean = true
    @set:JvmSynthetic @get:JvmSynthetic
    internal var isMaximizable: Boolean = stageInstance.isResizable
    @set:JvmSynthetic @get:JvmSynthetic
    internal var maximizeButtonIsVisible: Boolean = true
    @set:JvmSynthetic @get:JvmSynthetic
    internal var isMinimizable: Boolean = true
    @set:JvmSynthetic @get:JvmSynthetic
    internal var minimizeButtonIsVisible: Boolean = true

    @set:JvmSynthetic @get:JvmSynthetic
    internal var isDraggable: Boolean = true
    @set:JvmSynthetic @get:JvmSynthetic
    internal var isResizable: Boolean = stageInstance.isResizable
    @set:JvmSynthetic @get:JvmSynthetic
    internal var resizeLimit: Boolean = true

    @set:JvmSynthetic @get:JvmSynthetic
    internal var saveWindowPosition: Boolean = false

    @set:JvmSynthetic @get:JvmSynthetic
    internal var stage: Stage = stageInstance

    @set:JvmSynthetic @get:JvmSynthetic
    internal var svgIconZoom: Double = 0.3

    @set:JvmSynthetic @get:JvmSynthetic
    internal var titleAlignment: TitleAlignment = TitleAlignment.LEFT
    @set:JvmSynthetic @get:JvmSynthetic
    internal var titleIsVisible: Boolean = true
    @set:JvmSynthetic @get:JvmSynthetic
    internal var titleText: String = if (!stageInstance.title.isNullOrEmpty()) stageInstance.title else domain
    @set:JvmSynthetic @get:JvmSynthetic
    internal var titleTextSize: Double = 12.0
    @set:JvmSynthetic @get:JvmSynthetic
    internal var titleTextFont: Font = Font.getDefault()

    @set:JvmSynthetic @get:JvmSynthetic
    internal var titleBarBackground: Color = Color.web("#FFFFFF")
    @set:JvmSynthetic @get:JvmSynthetic
    internal var titleBarInactiveBackground: Color = Color.web("#FFFFFF")
    @set:JvmSynthetic @get:JvmSynthetic
    internal var titleBarOrder: NodeOrientation = NodeOrientation.LEFT_TO_RIGHT
    @set:JvmSynthetic @get:JvmSynthetic
    internal var titleBarShadowDepth: TitleShadowDepth = TitleShadowDepth.DEPTH0
    @set:JvmSynthetic @get:JvmSynthetic
    internal var titleBarInactiveShadowDepth: TitleShadowDepth = TitleShadowDepth.DEPTH0
    @set:JvmSynthetic @get:JvmSynthetic
    internal var titleBarBottomBorderIsVisible: Boolean = false

    @set:JvmSynthetic @get:JvmSynthetic
    internal var toolButtonsStyle: ButtonStyle = ButtonStyle.WIN32
    @set:JvmSynthetic @get:JvmSynthetic
    internal var toolButtonsTooltipIsEnabled: Boolean = true
    @set:JvmSynthetic @get:JvmSynthetic
    internal var toolButtonsHoverColor: Color = Color.color(0.0, 0.0, 0.0, 0.1)
    @set:JvmSynthetic @get:JvmSynthetic
    internal var toolButtonsPressedColor: Color = Color.color(0.0, 0.0, 0.0, 0.2)

    @set:JvmSynthetic @get:JvmSynthetic
    internal var windowShadowIsEnabled: Boolean = true
    @set:JvmSynthetic @get:JvmSynthetic
    internal var windowShadowType: ShadowStyle = ShadowStyle.WIN32
}