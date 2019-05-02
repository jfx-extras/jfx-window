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
import jfxwindow.helpers.WindowBuilderHelper
import jfxwindow.listeners.WindowDataListener

/**
 * Base jfx-window library window constructor and builder.
 *
 * @param [stage] application window stage in which
 * the window will be created.
 */
@Suppress(
    "RedundantVisibilityModifier",
    "MemberVisibilityCanBePrivate",
    "unused",
    "RedundantUnitReturnType"
)
public class Window(private val stage: Stage) {
    /**
     * jfx-window WindowBase class instance.
     */
    public val instance: WindowBase = WindowBase(stage)

    /**
     * Animation duration for background color changing of title-bar zone.
     *
     * @param [duration] animation duration time.
     * @return [Window] instance of window builder.
     */
    public fun animationDuration(duration: Duration): Window {
        instance.windowOptions.animationDuration = duration
        return this
    }

    /**
     * Animation enabled status for background color changing of title-bar zone.
     *
     * @param [isEnabled] enabled status color animation for background color
     * changing of title-bar zone.
     *
     * @return [Window] instance of window builder.
     */
    public fun smoothColorAnimation(isEnabled: Boolean): Window {
        instance.windowOptions.smoothColorAnimation = isEnabled
        return this
    }

    /**
     * Border visibility status of application window border.
     *
     * @param [isVisible] visibility status of application window border.
     * @return [Window] instance of window builder.
     */
    public fun borderIsVisible(isVisible: Boolean): Window {
        instance.windowOptions.borderIsVisible = isVisible
        return this
    }

    /**
     * Border fill color of application window color.
     *
     * @param [fillColor] color for fill border.
     * @return [Window] instance of window builder.
     */
    public fun borderColor(fillColor: Color): Window {
        instance.windowOptions.borderColor = fillColor
        return this
    }

    /**
     * Border fill color of unfocused application window color.
     *
     * @param [fillColor] color for fill border.
     * @return [Window] instance of window builder.
     */
    public fun borderInactiveColor(fillColor: Color): Window {
        instance.windowOptions.borderInactiveColor = fillColor
        return this
    }

    /**
     * TitleBar context-menu enabled state for current instance.
     *
     * @param [isEnabled] enabled state of context-menu.
     * @return [Window] instance of window builder.
     */
    public fun contextMenuIsEnabled(isEnabled: Boolean): Window {
        instance.windowOptions.contextMenuIsEnabled = isEnabled
        return this
    }

    /**
     * TitleBar context-menu enabled state for spacing.
     *
     * **This can be useful if you use some kind of
     * graphical libraries and they add indents themselves.**
     *
     * @param [isEnabled] enabled state of context-menu.
     * @return [Window] instance of window builder.
     */
    public fun contextMenuSpacingIsEnabled(isEnabled: Boolean): Window {
        instance.windowOptions.contextMenuSpacingIsEnabled = isEnabled
        return this
    }

    /**
     * TitleBar icon also support SVG (Beta) images.
     * Probably you must use [svgIconZoom] for better result with svg.
     *
     * @param [iconPath] path to icon, if icon path contains .svg ext, then be
     * applied SVG icon.
     * @return [Window] instance of window builder.
     */
    public fun icon(iconPath: String): Window {
        instance.windowOptions.icon = iconPath
        return this
    }

    /**
     * TitleBar icon visibility status in title-bar.
     *
     * @param [isVisible] visibility status for title-bar icon.
     * @return [Window] instance of window builder.
     */
    public fun iconIsVisible(isVisible: Boolean): Window {
        instance.windowOptions.iconIsVisible = isVisible
        return this
    }

    /**
     * Controlling ability to close window with button or
     * closing with context-menu.
     *
     * **WARN: It not restrict Alt + F4 key's, if you need
     * restrict it - make it self.**
     *
     * @param [isAble] ability status for close window.
     * @return [Window] instance of window builder.
     */
    public fun isClosable(isAble: Boolean): Window {
        instance.windowOptions.isClosable = isAble
        return this
    }

    /**
     * Controlling visibility of window close button.
     *
     * @param [isVisibility] visibility status of close button.
     * @return [Window] instance of window builder.
     */
    public fun closeButtonIsVisible(isVisibility: Boolean): Window {
        instance.windowOptions.closeButtonIsVisible = isVisibility
        return this
    }

    /**
     * Controlling ability to maximize window with button or
     * maximize with context-menu.
     *
     * @param [isAble] ability status for maximize window.
     * @return [Window] instance of window builder.
     */
    public fun isMaximizable(isAble: Boolean): Window {
        instance.windowOptions.isMaximizable = isAble
        return this
    }

    /**
     * Controlling visibility of window maximize button.
     *
     * @param [isVisibility] visibility status of maximize button.
     * @return [Window] instance of window builder.
     */
    public fun maximizeButtonIsVisible(isVisibility: Boolean): Window {
        instance.windowOptions.maximizeButtonIsVisible = isVisibility
        return this
    }

    /**
     * Controlling ability to minimize window with button or
     * minimize with context-menu.
     *
     * @param [isAble] ability status for minimize window.
     * @return [Window] instance of window builder.
     */
    public fun isMinimizable(isAble: Boolean): Window {
        instance.windowOptions.isMinimizable = isAble
        return this
    }

    /**
     * Controlling visibility of window minimize button.
     *
     * @param [isVisibility] visibility status of minimize button.
     * @return [Window] instance of window builder.
     */
    public fun minimizeButtonIsVisible(isVisibility: Boolean): Window {
        instance.windowOptions.minimizeButtonIsVisible = isVisibility
        return this
    }

    /**
     * Controlling ability to drag window in screen space.
     *
     * @param [isAllowed] enabled state for draggable property.
     * @return [Window] instance of window builder.
     */
    public fun isDraggable(isAllowed: Boolean): Window {
        instance.windowOptions.isDraggable = isAllowed
        return this
    }

    /**
     * Controlling ability to resize window.
     *
     * @param [isAllowed] enabled state for resizable property.
     * @return [Window] instance of window builder.
     */
    public fun isResizable(isAllowed: Boolean): Window {
        instance.windowOptions.isResizable = isAllowed
        return this
    }

    /**
     * Window resize limit, i.e you not can set size if
     * new size < stage title-bar height.
     *
     * @param [isEnabled] enabled state for resize limit property.
     * @return [Window] instance of window builder.
     */
    public fun resizeLimit(isEnabled: Boolean): Window {
        instance.windowOptions.resizeLimit = isEnabled
        return this
    }

    /**
     * Save window position data in user temp folder.
     * **WARN: Data saving in system temp directory!**
     *
     * @param [isEnabled] enabled state for saving window position.
     * @return [Window] instance of window builder.
     */
    public fun saveWindowPosition(isEnabled: Boolean): Window {
        instance.windowOptions.saveWindowPosition = isEnabled
        return this
    }

    /**
     * Controlling svg icon zoom or size.
     * It can be applied when your SVG image so large or small.
     *
     * By default it value ~ 0.3 - 0.4.
     *
     * @param [zoom] zoom modifier for SVG image.
     * @return [Window] instance of window builder.
     */
    public fun svgIconZoom(zoom: Double): Window {
        instance.windowOptions.svgIconZoom = zoom
        return this
    }

    /**
     * Title alignment in title-bar space.
     *
     * @param [alignment] title alignment in title-bar space.
     * @return [Window] instance of window builder.
     */
    public fun titleAlignment(alignment: TitleAlignment): Window {
        instance.windowOptions.titleAlignment = alignment
        return this
    }

    /**
     * TitleBar title visibility status.
     *
     * @param [isVisible] visibility status for title.
     * @return [Window] instance of window builder.
     */
    public fun titleIsVisible(isVisible: Boolean): Window {
        instance.windowOptions.titleIsVisible = isVisible
        return this
    }

    /**
     * TitleBar title text or title content.
     *
     * @param [text] text for title or just new title.
     * @return [Window] instance of window builder.
     */
    public fun titleText(text: String): Window {
        instance.windowOptions.titleText = text
        return this
    }

    /**
     * TitleBar title text font family or just font name.
     *
     * @param [font] font name of text for title.
     * @return [Window] instance of window builder.
     */
    public fun titleTextFont(font: Font): Window {
        instance.windowOptions.titleTextFont = font
        return this
    }

    /**
     * TitleBar background fill color.
     *
     * @param [backgroundColor] color for fill title-bar.
     * @return [Window] instance of window builder.
     */
    public fun titleBarBackground(backgroundColor: Color): Window {
        instance.windowOptions.titleBarBackground = backgroundColor
        return this
    }

    /**
     * Inactive title-bar background fill color.
     *
     * @param [backgroundColor] color for fill inactive title-bar.
     * @return [Window] instance of window builder.
     */
    public fun titleBarUnActiveBackground(backgroundColor: Color): Window {
        instance.windowOptions.titleBarInactiveBackground = backgroundColor
        return this
    }

    /**
     * TitleBar ui elements order (orientation).
     *
     * @param [order] ui elements order (LTR or RTL).
     * @return [Window] instance of window builder.
     */
    public fun titleBarOrder(order: NodeOrientation): Window {
        instance.windowOptions.titleBarOrder = order
        return this
    }

    /**
     * TitleBar bar shadow depth (not window shadow).
     *
     * @param [depth] depth of shadow what applied on bar.
     * @return [Window] instance of window builder.
     */
    public fun titleBarShadowDepth(depth: TitleShadowDepth): Window {
        instance.windowOptions.titleBarShadowDepth = depth
        return this
    }

    /**
     * TitleBar bar shadow depth (not window shadow)
     * for not inactive window.
     *
     * @param [depth] depth of shadow what applied on inactive bar.
     * @return [Window] instance of window builder.
     */
    public fun titleBarInactiveShadowDepth(depth: TitleShadowDepth): Window {
        instance.windowOptions.titleBarInactiveShadowDepth = depth
        return this
    }

    /**
     * Controlling bottom border of title-bar visibility.
     *
     * @param [isVisible] visibility status for bar bottom border.
     * @return [Window] instance of window builder.
     */
    public fun titleBarBottomBorderIsVisible(isVisible: Boolean): Window {
        instance.windowOptions.titleBarBottomBorderIsVisible = isVisible
        return this
    }

    /**
     * Window buttons style i.e Close, Minimize ... buttons.
     *
     * @param [style] window buttons style.
     * @return [Window] instance of window builder.
     */
    public fun toolButtonsStyle(style: ButtonStyle): Window {
        instance.windowOptions.toolButtonsStyle = style
        return this
    }

    /**
     * Window buttons tooltip enabled state.
     *
     * @param [isEnabled] tooltip enabled state.
     * @return [Window] instance of window builder.
     */
    public fun toolButtonsTooltipIsEnabled(isEnabled: Boolean): Window {
        instance.windowOptions.toolButtonsTooltipIsEnabled = isEnabled
        return this
    }

    /**
     * Window buttons (un/maximized, minimized) hover color.
     *
     * @param [color] button hover color.
     * @return [Window] instance of window builder.
     */
    public fun toolButtonsHoverColor(color: Color): Window {
        instance.windowOptions.toolButtonsHoverColor = color
        return this
    }

    /**
     * Window buttons (un/maximized, minimized) pressed color.
     *
     * @param [color] button pressed color.
     * @return [Window] instance of window builder.
     */
    public fun toolButtonsPressedColor(color: Color): Window {
        instance.windowOptions.toolButtonsPressedColor = color
        return this
    }

    /**
     * Enabling auto-calculating min sizes for window by content size.
     *
     * @param [isEnabled] auto-calculating min sizes status.
     * @return [Window] instance of window builder.
     */
    public fun useMinSizeAsContentSize(isEnabled: Boolean): Window {
        instance.windowOptions.useMinSizeAsContentSize = isEnabled
        return this
    }

    /**
     * Window shadow enabled \ visible status.
     *
     * @param [isEnabled] window shadow enabled status.
     * @return [Window] instance of window builder.
     */
    public fun windowShadowIsEnabled(isEnabled: Boolean): Window {
        instance.windowOptions.windowShadowIsEnabled = isEnabled
        return this
    }

    /**
     * Window shadow style \ type what be applied to window.
     *
     * @param [type] window shadow style or type.
     * @return [Window] instance of window builder.
     */
    public fun windowShadowType(type: ShadowStyle): Window {
        instance.windowOptions.windowShadowType = type
        return this
    }

    /**
     * Controlling base window root element where will
     * placed used content.
     *
     * #### By default value is VBox.
     *
     * @param [node] root element as node.
     * @return [Window] instance of window builder.
     */
    public fun windowRootElement(node: Node): Window {
        instance.windowOptions.windowRootElement = node
        return this
    }

    /**
     * It method do some checks on compatibility and set stage value
     * to default options instance.
     *
     * **WARN: It method recommended use BEFORE creating \ showing stage!!!**
     *
     * After calling [build] method, you must call [create] method for
     * creating jfx-window.
     *
     * @return [Window] instance of window builder.
     */
    public fun build(): Window {
        WindowBuilderHelper.validateJVMVersion()
        WindowBuilderHelper.validateStageOnNull(stage)
        WindowBuilderHelper.validateStageStyle(stage)
        instance.windowOptions.stage = stage
        instance.windowStageShownListener.windowOptionsInstance = instance.windowOptions
        instance.windowStageShownListener.addShownListener()
        return this
    }

    /**
     * It method create jfx-window and base tasks to
     * produce great and cool window for you ^_^
     *
     * **IMPORTANT: This method requires calling [build] method!!!**
     *
     * **WARN: It method must called AFTER creating \ showing stage!!!**
     *
     * @return [Window] instance of window builder.
     */
    public fun create(): Window {
        instance.contentPart.prepareUserWorkspace(stage)
        instance.windowUi.assignBaseUi(stage)
        applyCreateProperties()
        callInitMethods()
        instance.contentPart.returnUserContent()
        if (!savePosIsInitialized) {
            WindowDataListener.loadWindowSettings()
            savePosIsInitialized = true
        }
        return this
    }

    private fun applyCreateProperties(): Unit {
        instance.animationHelper.windowPart = instance.windowPart

        instance.contentPart.windowOptionsInstance = instance.windowOptions

        instance.windowDefaultSizeListener.windowBaseInstance = instance
        instance.windowDefaultSizeListener.windowOptionsInstance = instance.windowOptions

        instance.windowPart.windowUiInstance = instance.windowUi
        instance.windowPart.windowOptionsInstance = instance.windowOptions
        instance.windowPart.windowBaseInstance = instance
        instance.windowPart.contextPart = instance.contextPart
        instance.windowPart.isResizable = instance.windowOptions.isResizable
        instance.windowPart.isDraggable = instance.windowOptions.isDraggable
        instance.windowPart.isMaximizable = instance.windowOptions.isMaximizable
        instance.windowPart.isMinimizable = instance.windowOptions.isMinimizable
        instance.windowPart.isClosable = instance.windowOptions.isClosable
        instance.windowPart.animationDuration = instance.windowOptions.animationDuration
        instance.windowPart.smoothColorAnim = instance.windowOptions.smoothColorAnimation
        instance.windowPart.useMinSizeAsContentSize = instance.windowOptions.useMinSizeAsContentSize
        instance.windowPart.useMinSizeAsContentSizeHelper =
            instance.windowOptions.useMinSizeAsContentSize

        instance.windowResizeHelper.stage = instance.windowOptions.stage
        instance.windowResizeHelper.scene = instance.windowOptions.stage.scene

        instance.windowStateListener.borderInstance = instance.borderPart
        instance.windowStateListener.windowOptionsInstance = instance.windowOptions
        instance.windowStateListener.windowUiInstance = instance.windowUi
        instance.windowStateListener.windowInstance = instance.windowPart
        instance.windowStateListener.buttonPartInstance = instance.buttonPart

        instance.windowInactiveListener.borderPartInstance = instance.borderPart
        instance.windowInactiveListener.titleBarPart = instance.titleBarPart
        instance.windowInactiveListener.windowOptionsInstance = instance.windowOptions

        instance.borderPart.windowOptionsInstance = instance.windowOptions
        instance.borderPart.windowUiInstance = instance.windowUi
        instance.borderPart.stateListener = instance.windowStateListener
        instance.borderPart.borderIsVisibleHelper = instance.windowOptions.borderIsVisible

        instance.titlePart.windowOptionsInstance = instance.windowOptions
        instance.titlePart.windowUiInstance = instance.windowUi

        instance.iconPart.windowOptionsInstance = instance.windowOptions
        instance.iconPart.windowUiInstance = instance.windowUi

        instance.titleBarPart.animHelperInstance = instance.animationHelper
        instance.titleBarPart.windowUiInstance = instance.windowUi
        instance.titleBarPart.windowOptionsInstance = instance.windowOptions
        instance.titleBarPart.windowPart = instance.windowPart

        instance.buttonPart.titleBarPart = instance.titleBarPart
        instance.buttonPart.windowOptionsInstance = instance.windowOptions
        instance.buttonPart.windowUiInstance = instance.windowUi
        instance.buttonPart.buttonHoverColor = instance.windowOptions.toolButtonsHoverColor
        instance.buttonPart.buttonPressedColor = instance.windowOptions.toolButtonsPressedColor

        instance.windowTitleBarListener.windowOptionsInstance = instance.windowOptions
        instance.windowTitleBarListener.windowUiInstance = instance.windowUi
        instance.windowTitleBarListener.windowPart = instance.windowPart

        instance.contextPart.windowUiInstance = instance.windowUi
        instance.contextPart.windowOptionsInstance = instance.windowOptions
        instance.contextPart.windowPart = instance.windowPart

        instance.shadowPart.windowOptionsInstance = instance.windowOptions
        instance.shadowPart.windowUiInstance = instance.windowUi
    }

    private fun callInitMethods(): Unit {
        instance.windowResizeHelper.makeResizable()
        instance.windowStateListener.addBorderChangeListener()
        instance.windowStateListener.addWindowMaximizeListener()
        instance.windowStateListener.addWindowMinimizeListener()
        instance.contextPart.applyContextMenuProperties()
        instance.titlePart.applyTitleProperties()
        instance.iconPart.applyIconProperties()
        instance.borderPart.applyBorderProperties()
        instance.titleBarPart.applyTitleBarColor()
        instance.titleBarPart.applyTitleBarProperties()
        instance.titleBarPart.applyResizeProperties()
        instance.buttonPart.applyButtonProperties()
        instance.shadowPart.applyShadowProperties()
        instance.windowTitleBarListener.addResizeListeners()
        instance.windowTitleBarListener.addTitleMoveListener()
        instance.windowInactiveListener.addWindowUnActiveListener()

        if (!savePosIsInitialized) {
            WindowDataListener.stage = instance.windowOptions.stage
            WindowDataListener.savePosIsEnabled = instance.windowOptions.saveWindowPosition
            WindowDataListener.addPosListener()
        }
    }

    private companion object {
        @JvmStatic
        private var savePosIsInitialized: Boolean = false
    }
}
