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
 * @param [stage] application window stage in which the window will be created.
 */
class Window(private val stage: Stage) {
    val windowBase: WindowBase = WindowBase(stage)

    /**
     * Animation duration for background color changing of title-bar zone.
     *
     * @param [duration] animation duration time.
     * @return [Window] instance of window builder.
     */
    fun animationDuration(duration: Duration): Window {
        windowBase.windowOptions.animationDuration = duration
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
    fun smoothColorAnimation(isEnabled: Boolean): Window {
        windowBase.windowOptions.smoothColorAnimation = isEnabled
        return this
    }

    /**
     * Border visibility status of application window border.
     *
     * @param [isVisible] visibility status of application window border.
     * @return [Window] instance of window builder.
     */
    fun borderIsVisible(isVisible: Boolean): Window {
        windowBase.windowOptions.borderIsVisible = isVisible
        return this
    }

    /**
     * Border fill color of application window color.
     *
     * @param [fillColor] color for fill border.
     * @return [Window] instance of window builder.
     */
    fun borderColor(fillColor: Color): Window {
        windowBase.windowOptions.borderColor = fillColor
        return this
    }

    /**
     * Border fill color of unfocused application window color.
     *
     * @param [fillColor] color for fill border.
     * @return [Window] instance of window builder.
     */
    fun borderInactiveColor(fillColor: Color): Window {
        windowBase.windowOptions.borderInactiveColor = fillColor
        return this
    }

    /**
     * TitleBar context-menu enabled state for current instance.
     *
     * @param [isEnabled] enabled state of context-menu.
     * @return [Window] instance of window builder.
     */
    fun contextMenuIsEnabled(isEnabled: Boolean): Window {
        windowBase.windowOptions.contextMenuIsEnabled = isEnabled
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
    fun icon(iconPath: String): Window {
        windowBase.windowOptions.icon = iconPath
        return this
    }

    /**
     * TitleBar icon visibility status in titlebar.
     *
     * @param [isVisible] visibility status for titlebar icon.
     * @return [Window] instance of window builder.
     */
    fun iconIsVisible(isVisible: Boolean): Window {
        windowBase.windowOptions.iconIsVisible = isVisible
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
    fun isClosable(isAble: Boolean): Window {
        windowBase.windowOptions.isClosable = isAble
        return this
    }

    /**
     * Controlling visibility of window close button.
     *
     * @param [isVisibility] visibility status of close button.
     * @return [Window] instance of window builder.
     */
    fun closeButtonIsVisibile(isVisibility: Boolean): Window {
        windowBase.windowOptions.closeButtonIsVisible = isVisibility
        return this
    }

    /**
     * Controlling ability to maximize window with button or
     * maximize with context-menu.
     *
     * @param [isAble] ability status for maximize window.
     * @return [Window] instance of window builder.
     */
    fun isMaximizable(isAble: Boolean): Window {
        windowBase.windowOptions.isMaximizable = isAble
        return this
    }

    /**
     * Controlling visibility of window maximize button.
     *
     * @param [isVisibility] visibility status of maximize button.
     * @return [Window] instance of window builder.
     */
    fun maximizeButtonIsVisibile(isVisibility: Boolean): Window {
        windowBase.windowOptions.maximizeButtonIsVisible = isVisibility
        return this
    }

    /**
     * Controlling ability to minimize window with button or
     * minimize with context-menu.
     *
     * @param [isAble] ability status for minimize window.
     * @return [Window] instance of window builder.
     */
    fun isMinimizable(isAble: Boolean): Window {
        windowBase.windowOptions.isMinimizable = isAble
        return this
    }

    /**
     * Controlling visibility of window minimize button.
     *
     * @param [isVisibility] visibility status of minimize button.
     * @return [Window] instance of window builder.
     */
    fun minimizeButtonIsVisibile(isVisibility: Boolean): Window {
        windowBase.windowOptions.minimizeButtonIsVisible = isVisibility
        return this
    }

    /**
     * Controlling ability to drag window in screen space.
     *
     * @param [isAllowed] enabled state for draggable property.
     * @return [Window] instance of window builder.
     */
    fun isDraggable(isAllowed: Boolean): Window {
        windowBase.windowOptions.isDraggable = isAllowed
        return this
    }

    /**
     * Controlling ability to resize window.
     *
     * @param [isAllowed] enabled state for resizable property.
     * @return [Window] instance of window builder.
     */
    fun isResizable(isAllowed: Boolean): Window {
        windowBase.windowOptions.isResizable = isAllowed
        return this
    }

    /**
     * Window resize limit, i.e you not can set size if
     * new size < stage title-bar height.
     *
     * @param [isEnabled] enabled state for resize limit property.
     * @return [Window] instance of window builder.
     */
    fun resizeLimit(isEnabled: Boolean): Window {
        windowBase.windowOptions.resizeLimit = isEnabled
        return this
    }

    /**
     * Save window position data in user temp folder.
     * **WARN: Data saving in system temp directory!**
     *
     * @param [isEnabled] enabled state for saving window position.
     * @return [Window] instance of window builder.
     */
    fun saveWindowPosition(isEnabled: Boolean): Window {
        windowBase.windowOptions.saveWindowPosition = isEnabled
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
    fun svgIconZoom(zoom: Double): Window {
        windowBase.windowOptions.svgIconZoom = zoom
        return this
    }

    /**
     * Title alignment in title-bar space.
     *
     * @param [alignment] title alignment in titlebar space.
     * @return [Window] instance of window builder.
     */
    fun titleAlignment(alignment: TitleAlignment): Window {
        windowBase.windowOptions.titleAlignment = alignment
        return this
    }

    /**
     * TitleBar title visibility status.
     *
     * @param [isVisible] visibility status for title.
     * @return [Window] instance of window builder.
     */
    fun titleIsVisible(isVisible: Boolean): Window {
        windowBase.windowOptions.titleIsVisible = isVisible
        return this
    }

    /**
     * TitleBar title text or title content.
     *
     * @param [text] text for title or just new title.
     * @return [Window] instance of window builder.
     */
    fun titleText(text: String): Window {
        windowBase.windowOptions.titleText = text
        return this
    }

    /**
     * TitleBar title text font family or just font name.
     *
     * @param [font] font name of text for title.
     * @return [Window] instance of window builder.
     */
    fun titleTextFont(font: Font): Window {
        windowBase.windowOptions.titleTextFont = font
        return this
    }

    /**
     * TitleBar background fill color.
     *
     * @param [backgroundColor] color for fill title-bar.
     * @return [Window] instance of window builder.
     */
    fun titleBarBackground(backgroundColor: Color): Window {
        windowBase.windowOptions.titleBarBackground = backgroundColor
        return this
    }

    /**
     * Inactive title-bar background fill color.
     *
     * @param [backgroundColor] color for fill inactive title-bar.
     * @return [Window] instance of window builder.
     */
    fun titleBarUnActiveBackground(backgroundColor: Color): Window {
        windowBase.windowOptions.titleBarInactiveBackground = backgroundColor
        return this
    }

    /**
     * TitleBar ui elements order (orientation).
     *
     * @param [order] ui elements order (LTR or RTL).
     * @return [Window] instance of window builder.
     */
    fun titleBarOrder(order: NodeOrientation): Window {
        windowBase.windowOptions.titleBarOrder = order
        return this
    }

    /**
     * TitleBar bar shadow depth (not window shadow).
     *
     * @param [depth] depth of shadow what applied on bar.
     * @return [Window] instance of window builder.
     */
    fun titleBarShadowDepth(depth: TitleShadowDepth): Window {
        windowBase.windowOptions.titleBarShadowDepth = depth
        return this
    }

    /**
     * TitleBar bar shadow depth (not window shadow)
     * for not inactive window.
     *
     * @param [depth] depth of shadow what applied on inactive bar.
     * @return [Window] instance of window builder.
     */
    fun titleBarInactiveShadowDepth(depth: TitleShadowDepth): Window {
        windowBase.windowOptions.titleBarInactiveShadowDepth = depth
        return this
    }

    /**
     * Controlling bottom border of title-bar visibility.
     *
     * @param [isVisible] visibility status for bar bottom border.
     * @return [Window] instance of window builder.
     */
    fun titleBarBottomBorderIsVisible(isVisible: Boolean): Window {
        windowBase.windowOptions.titleBarBottomBorderIsVisible = isVisible
        return this
    }

    /**
     * Window buttons style i.e Close, Minimize ... buttons.
     *
     * @param [style] window buttons style.
     * @return [Window] instance of window builder.
     */
    fun toolButtonsStyle(style: ButtonStyle): Window {
        windowBase.windowOptions.toolButtonsStyle = style
        return this
    }

    /**
     * Window buttons tooltip enabled state.
     *
     * @param [isEnabled] tooltip enabled state.
     * @return [Window] instance of window builder.
     */
    fun toolButtonsTooltipIsEnabled(isEnabled: Boolean): Window {
        windowBase.windowOptions.toolButtonsTooltipIsEnabled = isEnabled
        return this
    }

    /**
     * Window buttons (un/maximized, minimized) hover color.
     *
     * @param [color] button hover color.
     * @return [Window] instance of window builder.
     */
    fun toolButtonsHoverColor(color: Color): Window {
        windowBase.windowOptions.toolButtonsHoverColor = color
        return this
    }

    /**
     * Window buttons (un/maximized, minimized) pressed color.
     *
     * @param [color] button pressed color.
     * @return [Window] instance of window builder.
     */
    fun toolButtonsPressedColor(color: Color): Window {
        windowBase.windowOptions.toolButtonsPressedColor = color
        return this
    }

    /**
     * Enabling auto-calculating min sizes for window by content size.
     *
     * @param [isEnabled] auto-calculating min sizes status.
     * @return [Window] instance of window builder.
     */
    fun useMinSizeAsContentSize(isEnabled: Boolean): Window {
        windowBase.windowOptions.useMinSizeAsContentSize = isEnabled
        return this
    }


    /**
     * Window shadow enabled \ visible status.
     *
     * @param [isEnabled] window shadow enabled status.
     * @return [Window] instance of window builder.
     */
    fun windowShadowIsEnabled(isEnabled: Boolean): Window {
        windowBase.windowOptions.windowShadowIsEnabled = isEnabled
        return this
    }

    /**
     * Window shadow style \ type what be applied to window.
     *
     * @param [type] window shadow style or type.
     * @return [Window] instance of window builder.
     */
    fun windowShadowType(type: ShadowStyle): Window {
        windowBase.windowOptions.windowShadowType = type
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
    fun windowRootElement(node: Node): Window {
        windowBase.windowOptions.windowRootElement = node
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
    fun build(): Window {
        WindowBuilderHelper.validateJVMVersion()
        WindowBuilderHelper.validateStageOnNull(stage)
        WindowBuilderHelper.validateStageStyle(stage)
        windowBase.windowOptions.stage = stage
        windowBase.windowStageShownListener.windowOptionsInstance = windowBase.windowOptions
        windowBase.windowStageShownListener.addShownListener()
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
    fun create(): Window {
        windowBase.contentPart.prepareUserWorkspace(stage)
        windowBase.windowUi.assignBaseUi(stage)
        applyCreateProperties()
        callInitMethods()
        windowBase.contentPart.returnUserContent()
        return this
    }

    private fun applyCreateProperties() {
        windowBase.animationHelper.windowPart = windowBase.windowPart

        windowBase.contentPart.windowOptionsInstance = windowBase.windowOptions

        windowBase.windowDefaultSizeListener.windowBaseInstance = windowBase
        windowBase.windowDefaultSizeListener.windowOptionsInstance = windowBase.windowOptions

        windowBase.windowPart.windowUiInstance = windowBase.windowUi
        windowBase.windowPart.windowOptionsInstance = windowBase.windowOptions
        windowBase.windowPart.windowBaseInstance = windowBase
        windowBase.windowPart.contextPart = windowBase.contextPart
        windowBase.windowPart.isResizable = windowBase.windowOptions.isResizable
        windowBase.windowPart.isDraggable = windowBase.windowOptions.isDraggable
        windowBase.windowPart.isMaximizable = windowBase.windowOptions.isMaximizable
        windowBase.windowPart.isMinimizable = windowBase.windowOptions.isMinimizable
        windowBase.windowPart.isClosable = windowBase.windowOptions.isClosable
        windowBase.windowPart.animationDuration = windowBase.windowOptions.animationDuration
        windowBase.windowPart.smoothColorAnim = windowBase.windowOptions.smoothColorAnimation
        windowBase.windowPart.useMinSizeAsContentSize = windowBase.windowOptions.useMinSizeAsContentSize
        windowBase.windowPart.useMinSizeAsContentSizeHelper = windowBase.windowOptions.useMinSizeAsContentSize

        windowBase.windowResizeHelper.stage = windowBase.windowOptions.stage
        windowBase.windowResizeHelper.scene = windowBase.windowOptions.stage.scene

        windowBase.windowStateListener.borderInstance = windowBase.borderPart
        windowBase.windowStateListener.windowOptionsInstance = windowBase.windowOptions
        windowBase.windowStateListener.windowUiInstance = windowBase.windowUi
        windowBase.windowStateListener.windowInstance = windowBase.windowPart

        windowBase.windowInactiveListener.borderPartInstance = windowBase.borderPart
        windowBase.windowInactiveListener.titleBarPart = windowBase.titleBarPart
        windowBase.windowInactiveListener.windowOptionsInstance = windowBase.windowOptions

        windowBase.borderPart.windowOptionsInstance = windowBase.windowOptions
        windowBase.borderPart.windowUiInstance = windowBase.windowUi
        windowBase.borderPart.stateListener = windowBase.windowStateListener
        windowBase.borderPart.borderIsVisibleHelper = windowBase.windowOptions.borderIsVisible

        windowBase.titlePart.windowOptionsInstance = windowBase.windowOptions
        windowBase.titlePart.windowUiInstance = windowBase.windowUi
        
        windowBase.iconPart.windowOptionsInstance = windowBase.windowOptions
        windowBase.iconPart.windowUiInstance = windowBase.windowUi

        windowBase.titleBarPart.animHelperInstance = windowBase.animationHelper
        windowBase.titleBarPart.windowUiInstance = windowBase.windowUi
        windowBase.titleBarPart.windowOptionsInstance = windowBase.windowOptions
        windowBase.titleBarPart.windowPart = windowBase.windowPart

        windowBase.buttonPart.titleBarPart = windowBase.titleBarPart
        windowBase.buttonPart.windowOptionsInstance = windowBase.windowOptions
        windowBase.buttonPart.windowUiInstance = windowBase.windowUi
        windowBase.buttonPart.buttonHoverColor = windowBase.windowOptions.toolButtonsHoverColor
        windowBase.buttonPart.buttonPressedColor = windowBase.windowOptions.toolButtonsPressedColor

        windowBase.windowTitleBarListener.windowOptionsInstance = windowBase.windowOptions
        windowBase.windowTitleBarListener.windowUiInstance = windowBase.windowUi
        windowBase.windowTitleBarListener.windowPart = windowBase.windowPart

        windowBase.contextPart.windowUiInstance = windowBase.windowUi
        windowBase.contextPart.windowOptionsInstance = windowBase.windowOptions
        windowBase.contextPart.windowPart = windowBase.windowPart
    }

    private fun callInitMethods() {
        windowBase.windowResizeHelper.makeResizable()
        windowBase.windowStateListener.addBorderChangeListener()
        windowBase.windowStateListener.addWindowMaximizeListener()
        windowBase.windowStateListener.addWindowMinimizeListener()
        windowBase.contextPart.applyContextMenuProperties()
        windowBase.titlePart.applyTitleProperties()
        windowBase.iconPart.applyIconProperties()
        windowBase.borderPart.applyBorderProperties()
        windowBase.titleBarPart.applyTitleBarColor()
        windowBase.titleBarPart.applyTitleBarProperties()
        windowBase.titleBarPart.applyResizeProperties()
        windowBase.buttonPart.applyButtonProperties()
        windowBase.windowTitleBarListener.addResizeListeners()
        windowBase.windowTitleBarListener.addTitleMoveListener()
        windowBase.windowInactiveListener.addWindowUnActiveListener()

        if (!savePosInitialized) {
            WindowDataListener.stage = windowBase.windowOptions.stage
            WindowDataListener.savePosIsEnabled = windowBase.windowOptions.saveWindowPosition
            WindowDataListener.addPosListener()
            savePosInitialized = true
        }
    }

    companion object {
        var savePosInitialized: Boolean = false
    }
}