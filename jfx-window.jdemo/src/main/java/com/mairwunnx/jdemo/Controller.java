package com.mairwunnx.jdemo;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import jfxwindow.enums.TitleAlignment;

public class Controller {
    public TextField titleTextResult;
    public TextField titleTextTextField;
    public TextField titleAlignResult;
    public TextField titleAlignTextField;
    public TextArea titleFontResult;
    public TextField titleFontName;

    public void getTitleText(MouseEvent mouseEvent) {
        titleTextResult.setText(EntryPoint.window.getWindowBase().getTitlePart().getTitleText());
    }

    public void setTitleText(MouseEvent mouseEvent) {
        EntryPoint.window.getWindowBase().getTitlePart().setTitleText(titleTextTextField.getText());
    }

    public void changeTitleVisibility(MouseEvent mouseEvent) {
        ToggleButton toggleButton = (ToggleButton) mouseEvent.getSource();
        EntryPoint.window.getWindowBase().getTitlePart().setTitleIsVisible(toggleButton.isSelected());
    }

    public void changeTitleAlign(MouseEvent mouseEvent) {
        if (titleAlignTextField.getText().toLowerCase().equals(TitleAlignment.CENTER.name().toLowerCase())) {
            EntryPoint.window.getWindowBase().getTitlePart().setTitleAlignment(TitleAlignment.CENTER);
        } else {
            EntryPoint.window.getWindowBase().getTitlePart().setTitleAlignment(TitleAlignment.LEFT);
        }
    }

    public void getTitleAlign(MouseEvent mouseEvent) {
        titleAlignResult.setText(EntryPoint.window.getWindowBase().getTitlePart().getTitleAlignment().name());
    }

    public void getTitleFont(MouseEvent mouseEvent) {
        titleFontResult.setText(EntryPoint.window.getWindowBase().getTitlePart().getTitleTextFont().toString());
    }

    public void setTitleFont(MouseEvent mouseEvent) {
        String[] font = ";".split(titleFontName.getText());
        EntryPoint.window.getWindowBase().getTitlePart().setTitleTextFont(new Font(font[0], Double.parseDouble(font[1])));
    }
}
