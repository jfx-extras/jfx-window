package jfxwindow.parts

import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.control.ScrollPane
import javafx.scene.control.SplitPane
import javafx.scene.control.TabPane
import javafx.scene.control.TitledPane
import javafx.scene.layout.*
import javafx.stage.Stage
import jfxwindow.base.WindowBase
import jfxwindow.helpers.getChildList

@Suppress("RedundantVisibilityModifier", "unused")
/**
 * Responsible for managing content in a window.
 * From public methods, only getting the root element
 * of your ui is available.
 */
public class ContentPart(private val windowBase: WindowBase) {
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

    /**
     * @return user content root node.
     */
    public fun getRootNode(): Node = installedNode

    internal fun prepareUserWorkspace(stage: Stage) {
        userContent = ArrayList(stage.scene.root.getChildList())
        stage.getChildList()?.clear()
        stage.scene.getChildList()?.clear()
        stage.scene.root.getChildList()?.clear()
        stage.scene.root = FXMLLoader.load<Any>(
            ContentPart::class.java.classLoader.getResource("interface/window.fxml")
        ) as Parent
    }

    internal fun returnUserContent() {
        windowBase.windowUi.windowContainer.getChildList()?.clear()

        when {
            windowBase.windowOptions.windowRootElement is AnchorPane -> {
                userContent.forEach {
                    anchorPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = anchorPane
                windowBase.windowUi.windowContainer.content = anchorPane
            }
            windowBase.windowOptions.windowRootElement is BorderPane -> {
                userContent.forEach {
                    borderPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = borderPane
                windowBase.windowUi.windowContainer.content = borderPane
            }
            windowBase.windowOptions.windowRootElement is FlowPane -> {
                userContent.forEach {
                    flowPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = flowPane
                windowBase.windowUi.windowContainer.content = flowPane
            }
            windowBase.windowOptions.windowRootElement is GridPane -> {
                userContent.forEach {
                    gridPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = gridPane
                windowBase.windowUi.windowContainer.content = gridPane
            }
            windowBase.windowOptions.windowRootElement is HBox -> {
                userContent.forEach {
                    hBox.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = hBox
                windowBase.windowUi.windowContainer.content = hBox
            }
            windowBase.windowOptions.windowRootElement is Pane -> {
                userContent.forEach {
                    pane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = pane
                windowBase.windowUi.windowContainer.content = pane
            }
            windowBase.windowOptions.windowRootElement is ScrollPane -> {
                userContent.forEach {
                    scrollPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = scrollPane
                windowBase.windowUi.windowContainer.content = scrollPane
            }
            windowBase.windowOptions.windowRootElement is SplitPane -> {
                userContent.forEach {
                    splitPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = splitPane
                windowBase.windowUi.windowContainer.content = splitPane
            }
            windowBase.windowOptions.windowRootElement is StackPane -> {
                userContent.forEach {
                    stackPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = stackPane
                windowBase.windowUi.windowContainer.content = stackPane
            }
            windowBase.windowOptions.windowRootElement is TabPane -> {
                userContent.forEach {
                    tabPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = tabPane
                windowBase.windowUi.windowContainer.content = tabPane
            }
            windowBase.windowOptions.windowRootElement is TilePane -> {
                userContent.forEach {
                    tilePane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = tilePane
                windowBase.windowUi.windowContainer.content = tilePane
            }
            windowBase.windowOptions.windowRootElement is TitledPane -> {
                userContent.forEach {
                    titledPane.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = titledPane
                windowBase.windowUi.windowContainer.content = titledPane
            }
            windowBase.windowOptions.windowRootElement is VBox -> {
                userContent.forEach {
                    vBox.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = vBox
                windowBase.windowUi.windowContainer.content = vBox
            }
            else -> {
                userContent.forEach {
                    vBox.getChildList()?.apply {
                        add(it)
                    }
                }

                installedNode = vBox
                windowBase.windowUi.windowContainer.content = vBox
            }
        }
    }
}
