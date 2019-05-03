@file:Suppress("unused")

package jfxwindow.helpers

import java.util.*

private fun getCurrentLocale(): Locale = Locale.getDefault()
internal var contextMenuBundle = ResourceBundle.getBundle(
    "i18n/contextmenu/ContextMenu",
    getCurrentLocale()
)
internal var buttonToolTipsBundle = ResourceBundle.getBundle(
    "i18n/toolbuttons/ButtonToolTips",
    getCurrentLocale()
)
