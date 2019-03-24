package com.mairwunnx.jdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        Parent root = FXMLLoader.load(Objects.requireNonNull(
                getClass().getClassLoader().getResource("demo.fxml")));
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        Window window = new Window(stage)
                .titleTextFont(Font.loadFont(String.valueOf(getClass().getClassLoader().getResource("UbuntuMono-Regular.ttf")), 16.0))
                .borderIsVisible(true)
                .icon("untitled.svg")
                .saveWindowPosition(true)
                .borderColor(Color.BLUE)
                .titleBarBottomBorderIsVisible(true)
                .borderInactiveColor(Color.BLACK)
                .iconIsVisible(true)
                .build();
        stage.show();
        window.create();

        System.out.println(window.getWindowBase().getTitlePart().getTitleTextFont());

        //window.getWindowBase().getBorderPart().setBorderColor(Color.BLUE);
    }

    public static void main(String[] args) {
        launch();
    }
}
