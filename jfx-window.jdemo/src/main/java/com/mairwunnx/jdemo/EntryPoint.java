package com.mairwunnx.jdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxwindow.base.Window;

public class EntryPoint extends Application {
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Pane(), 640, 480);
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
