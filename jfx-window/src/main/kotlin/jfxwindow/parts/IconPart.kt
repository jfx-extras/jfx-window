package jfxwindow.parts

import javafx.scene.image.Image
import jfxwindow.base.WindowOptions
import jfxwindow.base.WindowUi

class IconPart {
    @get:JvmSynthetic @set:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions
    @get:JvmSynthetic @set:JvmSynthetic
    internal lateinit var windowUiInstance: WindowUi
    private var isSvg: Boolean = false
    private var iconPath: String = ""

    @JvmSynthetic
    internal fun applyIconProperties() {
        if (!windowOptionsInstance.icon.isNullOrEmpty()) {
            isSvg = getImageExtension(windowOptionsInstance.icon) == "svg"

            if (windowOptionsInstance.iconIsVisible) {
                if (isSvg) {
                    windowUiInstance.svgIcon.isManaged = true
                    windowUiInstance.svgIcon.isVisible = true
                    windowUiInstance.icon.isManaged = false
                    windowUiInstance.icon.isVisible = false
                } else {
                    windowUiInstance.svgIcon.isManaged = false
                    windowUiInstance.svgIcon.isVisible = false
                    windowUiInstance.icon.isManaged = true
                    windowUiInstance.icon.isVisible = true
                }

                icon = windowOptionsInstance.icon
                iconPath = windowOptionsInstance.icon
            } else {
                windowUiInstance.svgIcon.isManaged = false
                windowUiInstance.svgIcon.isVisible = false
                windowUiInstance.icon.isManaged = false
                windowUiInstance.icon.isVisible = false
            }
        } else {
            windowUiInstance.svgIcon.isManaged = false
            windowUiInstance.svgIcon.isVisible = false
            windowUiInstance.icon.isManaged = false
            windowUiInstance.icon.isVisible = false
        }
    }

    var icon: String?
        get() = iconPath
        set(path) {
            if (path.isNullOrEmpty()) removeIcon() else {
                if (iconPath.isEmpty()) iconIsVisible = true

                iconPath = path

                if (getImageExtension(iconPath) == "svg") {
                    isSvg = true

                    windowUiInstance.svgIcon.isVisible = true
                    windowUiInstance.svgIcon.isManaged = true
                    windowUiInstance.icon.isVisible = false
                    windowUiInstance.icon.isManaged = false

                    val url = iconPath
                    windowUiInstance.svgIcon.engine.load(url)
                    windowUiInstance.svgIcon.isContextMenuEnabled = false
                    svgIconZoom = windowOptionsInstance.svgIconZoom

                    val webPage = com.sun.javafx.webkit.Accessor.getPageFor(windowUiInstance.svgIcon.engine)
                    webPage.setBackgroundColor(0)
                } else {
                    isSvg = false

                    windowUiInstance.icon.isVisible = true
                    windowUiInstance.icon.isManaged = true
                    windowUiInstance.svgIcon.isVisible = false
                    windowUiInstance.svgIcon.isManaged = false

                    windowUiInstance.icon.image = Image(iconPath)
                    windowOptionsInstance.stage.icons.add(Image(iconPath))
                }
            }
        }

    var iconIsVisible: Boolean
        get() = (if (isSvg) windowUiInstance.svgIcon.isVisible else windowUiInstance.icon.isVisible)
        set(isVisible) {
            if (isVisible) {
                if (isSvg) {
                    windowUiInstance.svgIcon.isVisible = true
                    windowUiInstance.svgIcon.isManaged = true
                    windowUiInstance.icon.isVisible = false
                    windowUiInstance.icon.isManaged = false
                    isSvg = true
                } else {
                    windowUiInstance.icon.isVisible = true
                    windowUiInstance.icon.isManaged = true
                    windowUiInstance.svgIcon.isVisible = false
                    windowUiInstance.svgIcon.isManaged = false
                    isSvg = false
                }
            } else {
                windowUiInstance.svgIcon.isVisible = false
                windowUiInstance.svgIcon.isManaged = false
                windowUiInstance.icon.isVisible = false
                windowUiInstance.icon.isManaged = false
            }
        }

    var svgIconZoom: Double
        get() = windowUiInstance.svgIcon.zoom
        set(zoom) { windowUiInstance.svgIcon.zoom = zoom }

    val iconIsSvg: Boolean
        get() = isSvg

    fun removeIcon() {
        iconPath = ""
        iconIsVisible = false
        windowUiInstance.icon.image = null
        windowUiInstance.svgIcon.engine.load(null)
    }

    private fun getImageExtension(imagePath: String?): String {
        val pathString: List<String> = imagePath!!.split("/")
        return pathString.last().split(".")[1].toLowerCase()
    }
}