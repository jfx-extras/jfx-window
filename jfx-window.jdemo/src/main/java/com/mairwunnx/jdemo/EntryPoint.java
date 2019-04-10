package com.mairwunnx.jdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxwindow.base.Window;

import java.io.IOException;
import java.util.Objects;

public class EntryPoint extends Application {
    static Window window;
    private static Double width;
    private static Double height;

    @Override
    public void start(Stage stage) throws IOException {
        System.setProperty("prism.lcdtext", "false");

        Parent root = FXMLLoader.load(Objects.requireNonNull(
                getClass().getClassLoader().getResource("demo.fxml")));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);

        window = new Window(stage)
                .titleTextFont(Font.loadFont(String.valueOf(getClass().getClassLoader().getResource("segoeui.ttf")), 12.0))
                .titleText("jfx-window")
                .icon("jfx-logo.png")
                .iconIsVisible(false)
                .borderColor(Color.BLACK)
                .borderInactiveColor(Color.DARKGRAY)
                .useMinSizeAsContentSize(true)
                .windowRootElement(new HBox())
                .build();

        stage.show();
        window.create();

        stage.widthProperty().addListener((newValue) -> {
            width = Double.parseDouble(newValue.toString().split("value: ")[1].replace("]", ""));
            calculateSize();
        });
        stage.heightProperty().addListener((newValue) -> {
            height = Double.parseDouble(newValue.toString().split("value: ")[1].replace("]", ""));
            calculateSize();
        });

        System.out.println("stage min width: " + stage.getMinWidth());
        System.out.println("stage min height: " + stage.getMinHeight());
    }

    private static void calculateSize() {
        window.getWindowBase().getTitlePart().setTitleText("Size: " + width + "x" + height);
    }

    public static void main(String[] args) {
        launch();
    }
}
