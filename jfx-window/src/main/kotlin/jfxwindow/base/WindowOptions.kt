package jfxwindow.base

import javafx.geometry.NodeOrientation
import javafx.scene.Node
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.stage.Stage
import javafx.util.Duration
import jfxwindow.enums.ButtonStyle
import jfxwindow.enums.ShadowStyle
import jfxwindow.enums.TitleAlignment
import jfxwindow.enums.TitleShadowDepth

@Suppress("RedundantVisibilityModifier")
internal data class WindowOptions(
    internal val stage: Stage,
    internal val animationDuration: Duration,
    internal val smoothColorAnimation: Boolean,
    internal val borderIsVisible: Boolean,
    internal val borderColor: Color,
    internal val borderInactiveColor: Color,
    internal val contextMenuIsEnabled: Boolean,
    internal val contextMenuSpacingIsEnabled: Boolean,
    internal val icon: String,
    internal val iconIsVisible: Boolean,
    internal val isClosable: Boolean,
    internal val closeButtonIsVisible: Boolean,
    internal val isMaximizable: Boolean,
    internal val maximizeButtonIsVisible: Boolean,
    internal val isMinimizable: Boolean,
    internal val minimizeButtonIsVisible: Boolean,
    internal val isDraggable: Boolean,
    internal val isResizable: Boolean,
    internal val resizeLimit: Boolean,
    internal val saveWindowPosition: Boolean,
    internal val svgIconZoom: Double,
    internal val titleAlignment: TitleAlignment,
    internal val titleIsVisible: Boolean,
    internal val titleText: String,
    internal val titleTextFont: Font,
    internal val titleOpacity: Double,
    internal val titleInactiveOpacity: Double,
    internal val titleBarBackground: Color,
    internal val titleBarInactiveBackground: Color,
    internal val titleBarOrder: NodeOrientation,
    internal val titleBarShadowDepth: TitleShadowDepth,
    internal val titleBarInactiveShadowDepth: TitleShadowDepth,
    internal val titleBarBottomBorderIsVisible: Boolean,
    internal val toolButtonsStyle: ButtonStyle,
    internal val toolButtonsTooltipIsEnabled: Boolean,
    internal val toolButtonsHoverColor: Color,
    internal val toolButtonsPressedColor: Color,
    internal val windowShadowIsEnabled: Boolean,
    internal val windowShadowType: ShadowStyle,
    internal val windowRootElement: Node
)
