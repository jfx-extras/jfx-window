package jfxwindow.base

import jfxwindow.helpers.AnimationHelper
import jfxwindow.helpers.WindowDefaultSizeHelper
import jfxwindow.helpers.WindowResizeHelper
import jfxwindow.listeners.WindowInactiveListener
import jfxwindow.listeners.WindowStateListener
import jfxwindow.listeners.WindowBaseListener
import jfxwindow.parts.*

/**
 * It class contains window parts instances.
 */
@Suppress("RedundantVisibilityModifier")
public class WindowBase {
    internal lateinit var windowOptions: WindowOptions
    /**
     * Responsible for managing content in a window.
     * From public methods, only getting the root element
     * of your ui is available.
     */
    public var contentPart = ContentPart(this)
    /**
     * Contains some methods and properties allowing to
     * work with the context menu of the window.
     */
    public var contextPart = ContextPart(this)
    /**
     * Contains some methods and properties allowing to
     * work with the window.
     */
    public var windowPart = WindowPart()
    /**
     * Contains some methods and properties allowing to
     * work with the border of window.
     */
    public var borderPart = BorderPart()
    /**
     * Contains some methods and properties allowing to
     * work with the window title.
     */
    public var titlePart = TitlePart()
    /**
     * Contains some methods and properties allowing to
     * work with the window icon.
     */
    public var iconPart = IconPart()
    /**
     * Contains some methods and properties allowing to
     * work with the window title-bar.
     */
    public var titleBarPart = TitleBarPart()
    /**
     * Contains some methods and properties allowing to
     * work with the window buttons (close, minimize, maximize).
     */
    public var buttonPart = ButtonPart()
    /**
     * Contains some methods and properties allowing to
     * work with the window shadow.
     */
    public var shadowPart = ShadowPart()
    /**
     * A class that helps in playing the animation of some elements,
     * but from the public only an extra animation modifier is available.
     */
    public var animationHelper = AnimationHelper()
    internal var windowBaseListener = WindowBaseListener()
    internal var windowUi = WindowUi()
    internal var windowResizeHelper = WindowResizeHelper(windowPart)
    internal var windowStateListener = WindowStateListener()
    internal var windowInactiveListener = WindowInactiveListener()
    internal var windowDefaultSizeListener = WindowDefaultSizeHelper()
}