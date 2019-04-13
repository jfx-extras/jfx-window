package jfxwindow.parts

import javafx.event.EventTarget
import javafx.fxml.FXMLLoader
import javafx.scene.Group
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.control.*
import javafx.scene.layout.*
import javafx.stage.Stage
import jfxwindow.base.WindowOptions
import jfxwindow.base.WindowUi
import java.lang.reflect.Method

class ContentPart(private val windowUiInstance: WindowUi) {
    @set:JvmSynthetic
    @get:JvmSynthetic
    internal lateinit var windowOptionsInstance: WindowOptions
    private lateinit var userContent: ArrayList<Node>

    private val anchorPane: AnchorPane = AnchorPane()
    private val borderPane: BorderPane = BorderPane()
    private val flowPane: FlowPane = FlowPane()
    private val gridPane: GridPane = GridPane()
    private val hBox: HBox = HBox()
    private val pane: Pane = Pane()
    private val scrollPane: ScrollPane = ScrollPane()
    private val splitPane: SplitPane = SplitPane()
    private val stackPane: StackPane = StackPane()
    private val tabPane: TabPane = TabPane()
    private val tilePane: TilePane = TilePane()
    private val titledPane: TitledPane = TitledPane()
    private val vBox: VBox = VBox()

    private var installedNode: Node = VBox()

    @JvmSynthetic
    internal fun prepareUserWorkspace(stage: Stage) {
        userContent = ArrayList(stage.scene.root.getChildList())
        stage.getChildList()?.clear()
        stage.scene.getChildList()?.clear()
        stage.scene.root.getChildList()?.clear()
        stage.scene.root = FXMLLoader.load<Any>(
            ContentPart::class.java.classLoader.getResource("interface/window.fxml")
        ) as Parent
    }

    @JvmSynthetic
    internal fun returnUserContent() {
        windowUiInstance.windowContainer.getChildList()?.clear()

        when {
            windowOptionsInstance.windowRootElement is AnchorPane -> {
                userContent.forEach {
                    anchorPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = anchorPane
                windowUiInstance.windowContainer.content = anchorPane
            }
            windowOptionsInstance.windowRootElement is BorderPane -> {
                userContent.forEach {
                    borderPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = borderPane
                windowUiInstance.windowContainer.content = borderPane
            }
            windowOptionsInstance.windowRootElement is FlowPane -> {
                userContent.forEach {
                    flowPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = flowPane
                windowUiInstance.windowContainer.content = flowPane
            }
            windowOptionsInstance.windowRootElement is GridPane -> {
                userContent.forEach {
                    gridPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = gridPane
                windowUiInstance.windowContainer.content = gridPane
            }
            windowOptionsInstance.windowRootElement is HBox -> {
                userContent.forEach {
                    hBox.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = hBox
                windowUiInstance.windowContainer.content = hBox
            }
            windowOptionsInstance.windowRootElement is Pane -> {
                userContent.forEach {
                    pane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = pane
                windowUiInstance.windowContainer.content = pane
            }
            windowOptionsInstance.windowRootElement is ScrollPane -> {
                userContent.forEach {
                    scrollPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = scrollPane
                windowUiInstance.windowContainer.content = scrollPane
            }
            windowOptionsInstance.windowRootElement is SplitPane -> {
                userContent.forEach {
                    splitPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = splitPane
                windowUiInstance.windowContainer.content = splitPane
            }
            windowOptionsInstance.windowRootElement is StackPane -> {
                userContent.forEach {
                    stackPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = stackPane
                windowUiInstance.windowContainer.content = stackPane
            }
            windowOptionsInstance.windowRootElement is TabPane -> {
                userContent.forEach {
                    tabPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = tabPane
                windowUiInstance.windowContainer.content = tabPane
            }
            windowOptionsInstance.windowRootElement is TilePane -> {
                userContent.forEach {
                    tilePane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = tilePane
                windowUiInstance.windowContainer.content = tilePane
            }
            windowOptionsInstance.windowRootElement is TitledPane -> {
                userContent.forEach {
                    titledPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = titledPane
                windowUiInstance.windowContainer.content = titledPane
            }
            windowOptionsInstance.windowRootElement is VBox -> {
                userContent.forEach {
                    vBox.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = vBox
                windowUiInstance.windowContainer.content = vBox
            }
            else -> {
                userContent.forEach {
                    vBox.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = vBox
                windowUiInstance.windowContainer.content = vBox
            }
        }
    }

    /**
     * @return user content root element.
     */
    fun getRootElement(): Node = installedNode

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