package jfxwindow.base

import javafx.scene.control.Label
import javafx.scene.control.ScrollPane
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.shape.SVGPath
import javafx.scene.web.WebView
import javafx.stage.Stage

class WindowUi {
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowShadowPane: BorderPane
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowPane: BorderPane
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowTitleBarPane: BorderPane
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var windowContainer: ScrollPane

    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var leftBorder: Pane
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var rightBorder: Pane
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var bottomBorder: Pane

    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var title: Label
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var titleCenter: Label
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var icon: javafx.scene.image.ImageView
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var svgIcon: WebView

    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var buttonContainer: HBox
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var win32MinButton: HBox
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var win32MinIcon: SVGPath
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var win32UnMaxButton: HBox
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var win32UnMaxIcon: SVGPath
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var win32MaxButton: HBox
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var win32MaxIcon: SVGPath
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var win32CloseButton: HBox
    @set:JvmSynthetic @get:JvmSynthetic
    internal lateinit var win32CloseIcon: SVGPath

    @JvmSynthetic
    internal fun assignBaseUi(stage: Stage) {
        windowShadowPane = stage.scene.root.lookup("#windowShadowPane") as BorderPane
        windowPane = stage.scene.root.lookup("#windowPane") as BorderPane
        windowTitleBarPane = stage.scene.root.lookup("#windowTitleBarPane") as BorderPane
        windowContainer = stage.scene.root.lookup("#windowContainer") as ScrollPane

        leftBorder = stage.scene.root.lookup("#leftBorder") as Pane
        rightBorder = stage.scene.root.lookup("#rightBorder") as Pane
        bottomBorder = stage.scene.root.lookup("#bottomBorder") as Pane

        title = stage.scene.root.lookup("#title") as Label
        titleCenter = stage.scene.root.lookup("#titleCenter") as Label
        icon = stage.scene.root.lookup("#icon") as ImageView
        svgIcon = stage.scene.root.lookup("#svgIcon") as WebView

        buttonContainer = stage.scene.root.lookup("#buttonContainer") as HBox

        win32MinButton = stage.scene.root.lookup("#win32MinButton") as HBox
        win32MinIcon = stage.scene.root.lookup("#win32MinIcon") as SVGPath

        win32UnMaxButton = stage.scene.root.lookup("#win32UnMaxButton") as HBox
        win32UnMaxIcon = stage.scene.root.lookup("#win32UnMaxIcon") as SVGPath

        win32MaxButton = stage.scene.root.lookup("#win32MaxButton") as HBox
        win32MaxIcon = stage.scene.root.lookup("#win32MaxIcon") as SVGPath

        win32CloseButton = stage.scene.root.lookup("#win32CloseButton") as HBox
        win32CloseIcon = stage.scene.root.lookup("#win32CloseIcon") as SVGPath
    }
}