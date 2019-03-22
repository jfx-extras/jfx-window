package com.mairwunnx.jdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxwindow.base.Window;

import java.io.IOException;
import java.util.Objects;

public class EntryPoint extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(
                getClass().getClassLoader().getResource("demo.fxml")));
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        Window window = new Window(stage)
                .borderIsVisible(false)
                .build();
        stage.show();
        window.create();
    }

    public static void main(String[] args) {
        launch();
    }
}
