package jfxwindow.base

import javafx.geometry.NodeOrientation
import javafx.scene.Node
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.stage.Stage
import javafx.util.Duration
import jfxwindow.enums.ButtonStyle
import jfxwindow.enums.ShadowStyle
import jfxwindow.enums.TitleAlignment
import jfxwindow.enums.TitleShadowDepth
import jfxwindow.helpers.installCallbackSize
import jfxwindow.helpers.installDefaultSize
import jfxwindow.helpers.validateStage
import jfxwindow.listeners.WindowDataListener
import java.io.File

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
    public val instance: WindowBase = WindowBase()

    private var animationDuration: Duration = Duration.millis(200.0)
    /**
     * Animation duration for background color changing of title-bar zone.
     *
     * @param [duration] animation duration time.
     * @return [Window] instance of window builder.
     */
    public fun animationDuration(duration: Duration): Window {
        animationDuration = duration
        return this
    }

    private var smoothColorAnimation: Boolean = true
    /**
     * Animation enabled status for background color changing of title-bar zone.
     *
     * @param [isEnabled] enabled status color animation for background color
     * changing of title-bar zone.
     *
     * @return [Window] instance of window builder.
     */
    public fun smoothColorAnimation(isEnabled: Boolean): Window {
        smoothColorAnimation = isEnabled
        return this
    }

    private var borderIsVisible: Boolean = true
    /**
     * Border visibility status of application window border.
     *
     * @param [isVisible] visibility status of application window border.
     * @return [Window] instance of window builder.
     */
    public fun borderIsVisible(isVisible: Boolean): Window {
        borderIsVisible = isVisible
        return this
    }

    private var borderColor: Color = Color.web("#707070")
    /**
     * Border fill color of application window color.
     *
     * @param [fillColor] color for fill border.
     * @return [Window] instance of window builder.
     */
    public fun borderColor(fillColor: Color): Window {
        borderColor = fillColor
        return this
    }

    private var borderInactiveColor: Color = Color.web("#AAAAAA")
    /**
     * Border fill color of unfocused application window color.
     *
     * @param [fillColor] color for fill border.
     * @return [Window] instance of window builder.
     */
    public fun borderInactiveColor(fillColor: Color): Window {
        borderInactiveColor = fillColor
        return this
    }

    private var contextMenuIsEnabled: Boolean = true
    /**
     * TitleBar context-menu enabled state for current instance.
     *
     * @param [isEnabled] enabled state of context-menu.
     * @return [Window] instance of window builder.
     */
    public fun contextMenuIsEnabled(isEnabled: Boolean): Window {
        contextMenuIsEnabled = isEnabled
        return this
    }

    private var contextMenuSpacingIsEnabled: Boolean = true
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
        contextMenuSpacingIsEnabled = isEnabled
        return this
    }

    private var icon: String = ""
    /**
     * TitleBar icon also support SVG (Beta) images.
     * Probably you must use [svgIconZoom] for better result with svg.
     *
     * @param [iconPath] path to icon, if icon path contains .svg ext, then be
     * applied SVG icon.
     * @return [Window] instance of window builder.
     */
    public fun icon(iconPath: String): Window {
        icon = iconPath
        return this
    }

    private var iconIsVisible: Boolean = false
    /**
     * TitleBar icon visibility status in title-bar.
     *
     * @param [isVisible] visibility status for title-bar icon.
     * @return [Window] instance of window builder.
     */
    public fun iconIsVisible(isVisible: Boolean): Window {
        iconIsVisible = isVisible
        return this
    }

    private var isClosable: Boolean = true
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
        isClosable = isAble
        return this
    }

    private var closeButtonIsVisible: Boolean = true
    /**
     * Controlling visibility of window close button.
     *
     * @param [isVisibility] visibility status of close button.
     * @return [Window] instance of window builder.
     */
    public fun closeButtonIsVisible(isVisibility: Boolean): Window {
        closeButtonIsVisible = isVisibility
        return this
    }

    private var isMaximizable: Boolean = true
    /**
     * Controlling ability to maximize window with button or
     * maximize with context-menu.
     *
     * @param [isAble] ability status for maximize window.
     * @return [Window] instance of window builder.
     */
    public fun isMaximizable(isAble: Boolean): Window {
        isMaximizable = isAble
        return this
    }

    private var maximizeButtonIsVisible: Boolean = true
    /**
     * Controlling visibility of window maximize button.
     *
     * @param [isVisibility] visibility status of maximize button.
     * @return [Window] instance of window builder.
     */
    public fun maximizeButtonIsVisible(isVisibility: Boolean): Window {
        maximizeButtonIsVisible = isVisibility
        return this
    }

    private var isMinimizable: Boolean = true
    /**
     * Controlling ability to minimize window with button or
     * minimize with context-menu.
     *
     * @param [isAble] ability status for minimize window.
     * @return [Window] instance of window builder.
     */
    public fun isMinimizable(isAble: Boolean): Window {
        isMinimizable = isAble
        return this
    }

    private var minimizeButtonIsVisible: Boolean = true
    /**
     * Controlling visibility of window minimize button.
     *
     * @param [isVisibility] visibility status of minimize button.
     * @return [Window] instance of window builder.
     */
    public fun minimizeButtonIsVisible(isVisibility: Boolean): Window {
        minimizeButtonIsVisible = isVisibility
        return this
    }

    private var isDraggable: Boolean = true
    /**
     * Controlling ability to drag window in screen space.
     *
     * @param [isAllowed] enabled state for draggable property.
     * @return [Window] instance of window builder.
     */
    public fun isDraggable(isAllowed: Boolean): Window {
        isDraggable = isAllowed
        return this
    }

    private var isResizable: Boolean = stage.isResizable
    /**
     * Controlling ability to resize window.
     *
     * @param [isAllowed] enabled state for resizable property.
     * @return [Window] instance of window builder.
     */
    public fun isResizable(isAllowed: Boolean): Window {
        isResizable = isAllowed
        return this
    }

    private var resizeLimit: Boolean = true
    /**
     * Window resize limit, i.e you not can set size if
     * new size < stage title-bar height.
     *
     * @param [isEnabled] enabled state for resize limit property.
     * @return [Window] instance of window builder.
     */
    public fun resizeLimit(isEnabled: Boolean): Window {
        resizeLimit = isEnabled
        return this
    }

    private var saveWindowPosition: Boolean = false
    /**
     * Save window position data in user temp folder.
     *
     * **WARN: Data saving in system temp directory!**
     *
     * @param [isEnabled] enabled state for saving window position.
     * @return [Window] instance of window builder.
     */
    public fun saveWindowPosition(isEnabled: Boolean): Window {
        saveWindowPosition = isEnabled
        return this
    }

    private var svgIconZoom: Double = 0.3
    /**
     * Controlling svg icon zoom or size.
     * It can be applied when your SVG image so large or small.
     *
     * By default it value 0.3.
     *
     * @param [zoom] zoom modifier for SVG image.
     * @return [Window] instance of window builder.
     */
    public fun svgIconZoom(zoom: Double): Window {
        svgIconZoom = zoom
        return this
    }

    private var titleAlignment: TitleAlignment = TitleAlignment.LEFT
    /**
     * Title alignment in title-bar space.
     *
     * @param [alignment] title alignment in title-bar space.
     * @return [Window] instance of window builder.
     */
    public fun titleAlignment(alignment: TitleAlignment): Window {
        titleAlignment = alignment
        return this
    }

    private var titleIsVisible: Boolean = true
    /**
     * TitleBar title visibility status.
     *
     * @param [isVisible] visibility status for title.
     * @return [Window] instance of window builder.
     */
    public fun titleIsVisible(isVisible: Boolean): Window {
        titleIsVisible = isVisible
        return this
    }

    private val domain: String = File(
        WindowOptions::class.java.protectionDomain
            .codeSource
            .location.toURI()
            .path
    ).name
    private var titleText: String = if (!stage.title.isNullOrEmpty()) stage.title else domain
    /**
     * TitleBar title text or title content.
     *
     * @param [text] text for title or just new title.
     * @return [Window] instance of window builder.
     */
    public fun titleText(text: String): Window {
        titleText = text
        return this
    }

    private fun getSystemFont(): Font {
        return if (System.getProperty("os.name").contains("windows")) {
            Font("Segoe UI", 12.0)
        } else {
            Font("System Regular", 12.0)
        }
    }

    private var titleTextFont: Font = getSystemFont()
    /**
     * TitleBar title text font family or just font name.
     *
     * @param [font] font name of text for title.
     * @return [Window] instance of window builder.
     */
    public fun titleTextFont(font: Font): Window {
        titleTextFont = font
        return this
    }

    private var titleBarBackground: Color = Color.web("#FFFFFF")
    /**
     * TitleBar background fill color.
     *
     * @param [backgroundColor] color for fill title-bar.
     * @return [Window] instance of window builder.
     */
    public fun titleBarBackground(backgroundColor: Color): Window {
        titleBarBackground = backgroundColor
        return this
    }

    private var titleBarInactiveBackground: Color = Color.web("#FFFFFF")
    /**
     * Inactive title-bar background fill color.
     *
     * @param [backgroundColor] color for fill inactive title-bar.
     * @return [Window] instance of window builder.
     */
    public fun titleBarInactiveBackground(backgroundColor: Color): Window {
        titleBarInactiveBackground = backgroundColor
        return this
    }

    private var titleBarOrder: NodeOrientation = NodeOrientation.LEFT_TO_RIGHT
    /**
     * TitleBar ui elements order (orientation).
     *
     * @param [order] ui elements order (LTR or RTL).
     * @return [Window] instance of window builder.
     */
    public fun titleBarOrder(order: NodeOrientation): Window {
        titleBarOrder = order
        return this
    }

    private var titleBarShadowDepth: TitleShadowDepth = TitleShadowDepth.DEPTH0
    /**
     * TitleBar bar shadow depth (not window shadow).
     *
     * @param [depth] depth of shadow what applied on bar.
     * @return [Window] instance of window builder.
     */
    public fun titleBarShadowDepth(depth: TitleShadowDepth): Window {
        titleBarShadowDepth = depth
        return this
    }

    private var titleBarInactiveShadowDepth: TitleShadowDepth = TitleShadowDepth.DEPTH0
    /**
     * TitleBar bar shadow depth (not window shadow)
     * for not inactive window.
     *
     * @param [depth] depth of shadow what applied on inactive bar.
     * @return [Window] instance of window builder.
     */
    public fun titleBarInactiveShadowDepth(depth: TitleShadowDepth): Window {
        titleBarInactiveShadowDepth = depth
        return this
    }

    private var titleBarBottomBorderIsVisible: Boolean = false
    /**
     * Controlling bottom border of title-bar visibility.
     *
     * @param [isVisible] visibility status for bar bottom border.
     * @return [Window] instance of window builder.
     */
    public fun titleBarBottomBorderIsVisible(isVisible: Boolean): Window {
        titleBarBottomBorderIsVisible = isVisible
        return this
    }

    private var toolButtonsStyle: ButtonStyle = ButtonStyle.WIN32
    /**
     * Window buttons style i.e Close, Minimize ... buttons.
     *
     * @param [style] window buttons style.
     * @return [Window] instance of window builder.
     */
    public fun toolButtonsStyle(style: ButtonStyle): Window {
        toolButtonsStyle = style
        return this
    }

    private var toolButtonsTooltipIsEnabled: Boolean = true
    /**
     * Window buttons tooltip enabled state.
     *
     * @param [isEnabled] tooltip enabled state.
     * @return [Window] instance of window builder.
     */
    public fun toolButtonsTooltipIsEnabled(isEnabled: Boolean): Window {
        toolButtonsTooltipIsEnabled = isEnabled
        return this
    }

    private var toolButtonsHoverColor: Color = Color.color(0.0, 0.0, 0.0, 0.1)
    /**
     * Window buttons (un/maximized, minimized) hover color.
     *
     * @param [color] button hover color.
     * @return [Window] instance of window builder.
     */
    public fun toolButtonsHoverColor(color: Color): Window {
        toolButtonsHoverColor = color
        return this
    }

    private var toolButtonsPressedColor: Color = Color.color(0.0, 0.0, 0.0, 0.2)
    /**
     * Window buttons (un/maximized, minimized) pressed color.
     *
     * @param [color] button pressed color.
     * @return [Window] instance of window builder.
     */
    public fun toolButtonsPressedColor(color: Color): Window {
        toolButtonsPressedColor = color
        return this
    }

    private var windowShadowIsEnabled: Boolean = true
    /**
     * Window shadow enabled \ visible status.
     *
     * @param [isEnabled] window shadow enabled status.
     * @return [Window] instance of window builder.
     */
    public fun windowShadowIsEnabled(isEnabled: Boolean): Window {
        windowShadowIsEnabled = isEnabled
        return this
    }

    private var windowShadowType: ShadowStyle = ShadowStyle.WIN32
    /**
     * Window shadow style \ type what be applied to window.
     *
     * @param [type] window shadow style or type.
     * @return [Window] instance of window builder.
     */
    public fun windowShadowType(type: ShadowStyle): Window {
        windowShadowType = type
        return this
    }

    private var windowRootElement: Node = VBox()
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
        windowRootElement = node
        return this
    }

    /**
     * @return stage instance what used in for window creating.
     */
    public fun getStage(): Stage = stage

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
        validateStage(stage)
        instance.windowOptions = getWindowOptionsInstance()
        return this
    }

    private fun getWindowOptionsInstance(): WindowOptions {
        return WindowOptions(
            stage,
            animationDuration,
            smoothColorAnimation,
            borderIsVisible,
            borderColor,
            borderInactiveColor,
            contextMenuIsEnabled,
            contextMenuSpacingIsEnabled,
            icon,
            iconIsVisible,
            isClosable,
            closeButtonIsVisible,
            isMaximizable,
            maximizeButtonIsVisible,
            isMinimizable,
            minimizeButtonIsVisible,
            isDraggable,
            isResizable,
            resizeLimit,
            saveWindowPosition,
            svgIconZoom,
            titleAlignment,
            titleIsVisible,
            titleText,
            titleTextFont,
            titleBarBackground,
            titleBarInactiveBackground,
            titleBarOrder,
            titleBarShadowDepth,
            titleBarInactiveShadowDepth,
            titleBarBottomBorderIsVisible,
            toolButtonsStyle,
            toolButtonsTooltipIsEnabled,
            toolButtonsHoverColor,
            toolButtonsPressedColor,
            windowShadowIsEnabled,
            windowShadowType,
            windowRootElement
        )
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
        installDefaultSize(instance)
        installCallbackSize(instance)
        instance.windowMinimizeListener.init()
        instance.windowMaximizeListener.init()
        instance.borderStateHelper.init()
        instance.contextPart.init()
        instance.windowPart.init()
        instance.borderPart.init()
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

        instance.windowResizeHelper.stage = instance.windowOptions.stage
        instance.windowResizeHelper.scene = instance.windowOptions.stage.scene

        instance.windowInactiveListener.borderPartInstance = instance.borderPart
        instance.windowInactiveListener.titleBarPart = instance.titleBarPart
        instance.windowInactiveListener.windowOptionsInstance = instance.windowOptions

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

        instance.windowBaseListener.windowOptionsInstance = instance.windowOptions
        instance.windowBaseListener.windowUiInstance = instance.windowUi
        instance.windowBaseListener.windowPart = instance.windowPart

        instance.shadowPart.windowOptionsInstance = instance.windowOptions
        instance.shadowPart.windowUiInstance = instance.windowUi
    }

    private fun callInitMethods(): Unit {
        instance.windowResizeHelper.makeResizable()
        instance.titlePart.applyTitleProperties()
        instance.iconPart.applyIconProperties()
        instance.titleBarPart.applyTitleBarColor()
        instance.titleBarPart.applyTitleBarProperties()
        instance.titleBarPart.applyResizeProperties()
        instance.buttonPart.applyButtonProperties()
        instance.shadowPart.applyShadowProperties()
        instance.windowBaseListener.addTitleMoveListener()
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
