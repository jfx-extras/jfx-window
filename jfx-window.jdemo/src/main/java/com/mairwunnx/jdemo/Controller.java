package com.mairwunnx.jdemo;

import javafx.scene.control.Button;
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
    public TextField iconPathResult;
    public TextField iconPath;
    public TextField iconIsSvgResult;
    public TextField svgIconZoomResult;
    public TextField svgIconZoom;

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

    public void getIconPath(MouseEvent mouseEvent) {
        iconPathResult.setText(EntryPoint.window.getWindowBase().getIconPart().getIcon());
    }

    public void setIconPath(MouseEvent mouseEvent) {
        EntryPoint.window.getWindowBase().getIconPart().setIcon(iconPath.getText());
    }

    public void changeIconVisible(MouseEvent mouseEvent) {
        EntryPoint.window.getWindowBase().getIconPart().setIconIsVisible(!EntryPoint.window.getWindowBase().getIconPart().getIconIsVisible());
    }

    public void getIconIsSvg(MouseEvent mouseEvent) {
        iconIsSvgResult.setText(String.valueOf(EntryPoint.window.getWindowBase().getIconPart().getIconIsSvg()));
    }

    public void getSvgIconZoom(MouseEvent mouseEvent) {
        svgIconZoomResult.setText(String.valueOf(EntryPoint.window.getWindowBase().getIconPart().getSvgIconZoom()));
    }

    public void setSvgIconZoom(MouseEvent mouseEvent) {
        EntryPoint.window.getWindowBase().getIconPart().setSvgIconZoom(Double.parseDouble(svgIconZoom.getText()));
    }

    public void removeIcon(MouseEvent mouseEvent) {
        EntryPoint.window.getWindowBase().getIconPart().removeIcon();
    }
}
