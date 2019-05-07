package jfxwindow.base

import javafx.scene.control.Label
import javafx.scene.control.ScrollPane
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.shape.SVGPath
import javafx.scene.web.WebView

internal class WindowUi(private val windowBase: WindowBase) {
    internal val windowShadowPane: BorderPane by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#windowShadowPane") as BorderPane
    }
    internal val windowPane: BorderPane by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#windowPane") as BorderPane
    }
    internal val windowTitleBarPane: BorderPane by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#windowTitleBarPane") as BorderPane
    }
    internal val windowContainer: ScrollPane by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#windowContainer") as ScrollPane
    }
    internal val leftBorder: Pane by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#leftBorder") as Pane
    }
    internal val rightBorder: Pane by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#rightBorder") as Pane
    }
    internal val bottomBorder: Pane by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#bottomBorder") as Pane
    }
    internal val title: Label by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#title") as Label
    }
    internal val titleCenter: Label by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#titleCenter") as Label
    }
    internal val icon: ImageView by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#icon") as ImageView
    }
    internal val svgIcon: WebView by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#svgIcon") as WebView
    }
    internal val buttonContainer: HBox by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#buttonContainer") as HBox
    }
    internal val win32MinButton: HBox by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#win32MinButton") as HBox
    }
    internal val win32MinIcon: SVGPath by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#win32MinIcon") as SVGPath
    }
    internal val win32UnMaxButton: HBox by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#win32UnMaxButton") as HBox
    }
    internal val win32UnMaxIcon: SVGPath by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#win32UnMaxIcon") as SVGPath
    }
    internal val win32MaxButton: HBox by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#win32MaxButton") as HBox
    }
    internal val win32MaxIcon: SVGPath by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#win32MaxIcon") as SVGPath
    }
    internal val win32CloseButton: HBox by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#win32CloseButton") as HBox
    }
    internal val win32CloseIcon: SVGPath by lazy {
        windowBase.windowOptions.stage.scene.root.lookup("#win32CloseIcon") as SVGPath
    }
}
