package com.mairwunnx.jdemo;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.util.Duration;
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
    public TextField animationDurationResult;
    public TextField animationDuration;
    public TextField buttonDisableOpacityResult;
    public TextField buttonDisableOpacity;

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

    public void getAnimationDuration(MouseEvent mouseEvent) {
        animationDurationResult.setText(String.valueOf(EntryPoint.window.getWindowBase().getWindowPart().getAnimationDuration().toMillis()));
    }

    public void setAnimationDuration(MouseEvent mouseEvent) {
        EntryPoint.window.getWindowBase().getWindowPart().setAnimationDuration(Duration.millis(Double.parseDouble(animationDuration.getText())));
    }

    public void changeAnimationDuration(MouseEvent mouseEvent) {
        EntryPoint.window.getWindowBase().getWindowPart().setSmoothColorAnim(!EntryPoint.window.getWindowBase().getWindowPart().getSmoothColorAnim());
    }

    public void changeSavingPosition(MouseEvent mouseEvent) {
        EntryPoint.window.getWindowBase().getWindowPart().setSaveWindowPosition(!EntryPoint.window.getWindowBase().getWindowPart().getSaveWindowPosition());
    }

    public void changeIsResizable(MouseEvent mouseEvent) {
        EntryPoint.window.getWindowBase().getWindowPart().setResizable(!EntryPoint.window.getWindowBase().getWindowPart().isResizable());
    }

    public void changeIsDraggable(MouseEvent mouseEvent) {
        EntryPoint.window.getWindowBase().getWindowPart().setDraggable(!EntryPoint.window.getWindowBase().getWindowPart().isDraggable());
    }

    public void changeIsMaximizable(MouseEvent mouseEvent) {
        EntryPoint.window.getWindowBase().getWindowPart().setMaximizable(!EntryPoint.window.getWindowBase().getWindowPart().isMaximizable());
    }

    public void changeIsMinimizable(MouseEvent mouseEvent) {
        EntryPoint.window.getWindowBase().getWindowPart().setMinimizable(!EntryPoint.window.getWindowBase().getWindowPart().isMinimizable());
    }

    public void changeIsClosable(MouseEvent mouseEvent) {
        EntryPoint.window.getWindowBase().getWindowPart().setClosable(!EntryPoint.window.getWindowBase().getWindowPart().isClosable());
    }

    public void getButtonDisableOpacity(MouseEvent mouseEvent) {
        buttonDisableOpacityResult.setText(String.valueOf(EntryPoint.window.getWindowBase().getWindowPart().getDisabledOpacity()));
    }

    public void setButtonDusableOpacityResult(MouseEvent mouseEvent) {
        EntryPoint.window.getWindowBase().getWindowPart().setDisabledOpacity(Double.parseDouble(buttonDisableOpacity.getText()));
    }
}
