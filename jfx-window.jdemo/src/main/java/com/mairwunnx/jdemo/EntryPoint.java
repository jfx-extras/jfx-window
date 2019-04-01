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
    @Override
    public void start(Stage stage) throws IOException {
        System.setProperty("prism.lcdtext", "false");

        Parent root = FXMLLoader.load(Objects.requireNonNull(
                getClass().getClassLoader().getResource("demo.fxml")));

        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);

        Window window = new Window(stage)
                .titleTextFont(Font.loadFont(String.valueOf(getClass().getClassLoader().getResource("segoeui.ttf")), 12.0))
                .titleText("jfx-window")
                .icon("jfx-logo.png")
                .iconIsVisible(false)
                .borderColor(Color.BLACK)
                .borderInactiveColor(Color.DARKGRAY)
                .windowRootElement(new HBox())
                .build();

        stage.show();
        window.create();
    }

    public static void main(String[] args) {
        launch();
    }
}
