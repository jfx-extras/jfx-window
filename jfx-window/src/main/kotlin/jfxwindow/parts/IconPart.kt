package jfxwindow.parts

import javafx.scene.image.Image
import jfxwindow.base.WindowBase

/**
 * Contains some methods and properties allowing to
 * work with the window icon.
 */
@Suppress(
    "RedundantVisibilityModifier",
    "MemberVisibilityCanBePrivate",
    "RedundantUnitReturnType",
    "unused"
)
public class IconPart(private val windowBase: WindowBase) {
    private var isSvg: Boolean = false
    private var iconPath: String = ""

    internal fun init(): Unit {
        if (windowBase.windowOptions.icon.isNotEmpty()) {
            isSvg = getImageExtension(windowBase.windowOptions.icon) == "svg"

            if (isSvg) {
                showSvgIcon(true)
                showDefaultIcon(false)
            } else {
                showSvgIcon(false)
                showDefaultIcon(true)
            }

            icon = windowBase.windowOptions.icon
            iconPath = windowBase.windowOptions.icon
        } else {
            disableManagingIcons()
        }

        iconIsVisible = windowBase.windowOptions.iconIsVisible
        svgIconZoom = windowBase.windowOptions.svgIconZoom
    }

    /**
     * TitleBar icon also support SVG (Beta) images.
     * Probably you must use [svgIconZoom] for better result with svg.
     */
    public var icon: String
        get() = iconPath
        set(path) {
            if (path.isEmpty()) {
                removeIcon()
            } else {
                if (iconPath.isEmpty()) iconIsVisible = true
                iconPath = path

                if (getImageExtension(iconPath) == "svg") {
                    isSvg = true

                    showSvgIcon(true)
                    showDefaultIcon(false)

                    val url = iconPath
                    windowBase.windowUi.svgIcon.engine.load(url)
                    windowBase.windowUi.svgIcon.isContextMenuEnabled = false
                    svgIconZoom = windowBase.windowOptions.svgIconZoom

                    val webPage =
                        com.sun.javafx.webkit.Accessor.getPageFor(
                            windowBase.windowUi.svgIcon.engine
                        )
                    webPage.setBackgroundColor(0)
                } else {
                    isSvg = false

                    showDefaultIcon(true)
                    showSvgIcon(false)

                    windowBase.windowUi.icon.image = Image(iconPath)
                    windowBase.windowOptions.stage.icons.add(Image(iconPath))
                }
            }
        }

    /**
     * TitleBar icon visibility status in title-bar.
     */
    public var iconIsVisible: Boolean
        get() {
            return (if (isSvg) {
                windowBase.windowUi.svgIcon.isVisible
            } else {
                windowBase.windowUi.icon.isVisible
            })
        }
        set(isVisible) {
            if (isVisible) {
                isSvg = if (isSvg) {
                    showSvgIcon(true)
                    showDefaultIcon(false)
                    true
                } else {
                    showDefaultIcon(true)
                    showSvgIcon(false)
                    false
                }
            } else {
                disableManagingIcons()
            }
        }

    /**
     * Controlling svg icon zoom or size.
     * It can be applied when your SVG image so large or small.
     *
     * By default it value 0.3.
     */
    public var svgIconZoom: Double
        get() = windowBase.windowUi.svgIcon.zoom
        set(zoom) {
            windowBase.windowUi.svgIcon.zoom = zoom
        }

    /**
     * Return icon is svg value.
     */
    public val iconIsSvg: Boolean
        get() = isSvg

    /**
     * Just fully remove icon from application.
     */
    public fun removeIcon(): Unit {
        iconPath = ""
        iconIsVisible = false
        windowBase.windowUi.icon.image = null
        windowBase.windowUi.svgIcon.engine.load(null)
    }

    private fun getImageExtension(imagePath: String): String {
        val pathString: List<String> = imagePath.split("/")
        return pathString.last().split(".")[1].toLowerCase()
    }

    private fun disableManagingIcons(): Unit {
        windowBase.windowUi.svgIcon.isManaged = false
        windowBase.windowUi.svgIcon.isVisible = false
        windowBase.windowUi.icon.isManaged = false
        windowBase.windowUi.icon.isVisible = false
    }

    private fun showSvgIcon(show: Boolean): Unit {
        windowBase.windowUi.svgIcon.isManaged = show
        windowBase.windowUi.svgIcon.isVisible = show
    }

    private fun showDefaultIcon(show: Boolean): Unit {
        windowBase.windowUi.icon.isManaged = show
        windowBase.windowUi.icon.isVisible = show
    }
}
