package jfxwindow.base

import jfxwindow.helpers.AnimationHelper
import jfxwindow.helpers.TitleBarFillsHelper
import jfxwindow.helpers.WindowResizeHelper
import jfxwindow.listeners.WindowBaseListener
import jfxwindow.listeners.WindowInactiveListener
import jfxwindow.listeners.WindowMaximizeListener
import jfxwindow.listeners.WindowMinimizeListener
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
    public var windowPart = WindowPart(this)
    /**
     * Contains some methods and properties allowing to
     * work with the border of window.
     */
    public var borderPart = BorderPart(this)
    /**
     * Contains some methods and properties allowing to
     * work with the window title.
     */
    public var titlePart = TitlePart(this)
    /**
     * Contains some methods and properties allowing to
     * work with the window icon.
     */
    public var iconPart = IconPart(this)
    /**
     * Contains some methods and properties allowing to
     * work with the window title-bar.
     */
    public var titleBarPart = TitleBarPart(this)
    /**
     * Contains some methods and properties allowing to
     * work with the window buttons (close, minimize, maximize).
     */
    public var buttonPart = ButtonPart(this)
    /**
     * Contains some methods and properties allowing to
     * work with the window shadow.
     */
    public var shadowPart = ShadowPart()
    /**
     * A class that helps in playing the animation of some elements,
     * but from the public only an extra animation modifier is available.
     */
    public var animationHelper = AnimationHelper(this)
    internal var windowBaseListener = WindowBaseListener()
    internal var windowUi = WindowUi(this)
    internal var windowResizeHelper = WindowResizeHelper(windowPart)
    internal var windowMinimizeListener = WindowMinimizeListener(this)
    internal var windowMaximizeListener = WindowMaximizeListener(this)
    internal var windowInactiveListener = WindowInactiveListener(this)
    internal var titleBarFillsHelper = TitleBarFillsHelper(this)
}
