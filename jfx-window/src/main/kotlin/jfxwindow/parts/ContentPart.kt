package jfxwindow.parts

import javafx.event.EventTarget
import javafx.fxml.FXMLLoader
import javafx.scene.Group
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.control.Control
import javafx.scene.control.SkinBase
import javafx.scene.control.SplitPane
import javafx.scene.control.ToolBar
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import jfxwindow.base.WindowUi
import java.lang.reflect.Method

class ContentPart(private val windowUiInstance: WindowUi) {
    private lateinit var userContent: ArrayList<Node>

    @JvmSynthetic
    internal fun prepareUserWorkspace(stage: Stage) {
        userContent = ArrayList(stage.scene.root.getChildList())

        stage.scene.root.getChildList()?.clear()
        stage.scene.root.getChildList()?.add(
            FXMLLoader.load<Any>(
                ContentPart::class.java.classLoader.getResource("window.fxml")
            ) as Node
        )
    }

    @JvmSynthetic
    internal fun returnUserContent() {
        userContent.forEach {
            //windowUiInstance.titleBar.center.getChildList()?.clear()
            //windowUiInstance.titleBar.center.addChildIfPossible(it)
        }
    }

    /**
     * It getChildList, getChildrenReflectively, findMethodByName
     * methods by TornadoFx library. https://github.com/edvin/tornadofx
     *
     * Find the list of children from a Parent node. Gleaned code from ControlsFX for this.
     */
    private fun EventTarget.getChildList(): MutableList<Node>? = when (this) {
        is SplitPane -> items
        is ToolBar -> items
        is Pane -> children
        is Group -> children
        is HBox -> children
        is VBox -> children
        is Control -> (skin as? SkinBase<*>)?.children ?: getChildrenReflectively()
        is Parent -> getChildrenReflectively()
        else -> null
    }

    @Suppress("UNCHECKED_CAST", "PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    private fun Parent.getChildrenReflectively(): MutableList<Node>? {
        val getter = this.javaClass.findMethodByName("getChildren")
        if (getter != null && java.util.List::class.java.isAssignableFrom(getter.returnType)) {
            getter.isAccessible = true
            return getter.invoke(this) as MutableList<Node>
        }
        return null
    }

    private fun Class<*>.findMethodByName(name: String): Method? {
        val method = (declaredMethods + methods).find { it.name == name }
        if (method != null) return method
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
        if (superclass == java.lang.Object::class.java) return null
        return superclass.findMethodByName(name)
    }
}