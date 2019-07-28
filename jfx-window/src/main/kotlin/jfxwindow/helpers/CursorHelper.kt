package jfxwindow.helpers

import com.sun.javafx.cursor.CursorType
import com.sun.javafx.cursor.StandardCursorFrame
import javafx.scene.Cursor

internal fun isCursorResize(cursor: Cursor): Boolean {
    return StandardCursorFrame(CursorType.valueOf(cursor.toString())).cursorType.name.contains(
            "RESIZE"
        )
}
