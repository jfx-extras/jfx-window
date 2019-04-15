package com.mairwunnx.jdemo;

import javafx.geometry.NodeOrientation;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import jfxwindow.enums.TitleAlignment;
import jfxwindow.enums.TitleShadowDepth;

import static com.mairwunnx.jdemo.EntryPoint.*;

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
    public TextField titleBackgroundResult;
    public TextField titleBackground;
    public TextField shadowDepthResult;
    public TextField shadowDepth;
    public TextField buttonHoverColorResult;
    public TextField buttonHoverColor;
    public TextField buttonPressedColorResult;
    public TextField buttonPressedColor;

    public void getTitleText(MouseEvent mouseEvent) {
        titleTextResult.setText(window.getWindowBase().getTitlePart().getTitleText());
    }

    public void setTitleText(MouseEvent mouseEvent) {
        window.getWindowBase().getTitlePart().setTitleText(titleTextTextField.getText());
    }

    public void changeTitleVisibility(MouseEvent mouseEvent) {
        ToggleButton toggleButton = (ToggleButton) mouseEvent.getSource();
        window.getWindowBase().getTitlePart().setTitleIsVisible(toggleButton.isSelected());
    }

    public void changeTitleAlign(MouseEvent mouseEvent) {
        if (titleAlignTextField.getText().toLowerCase().equals(TitleAlignment.CENTER.name().toLowerCase())) {
            window.getWindowBase().getTitlePart().setTitleAlignment(TitleAlignment.CENTER);
        } else {
            window.getWindowBase().getTitlePart().setTitleAlignment(TitleAlignment.LEFT);
        }
    }

    public void getTitleAlign(MouseEvent mouseEvent) {
        titleAlignResult.setText(window.getWindowBase().getTitlePart().getTitleAlignment().name());
    }

    public void getTitleFont(MouseEvent mouseEvent) {
        titleFontResult.setText(window.getWindowBase().getTitlePart().getTitleTextFont().toString());
    }

    public void setTitleFont(MouseEvent mouseEvent) {
        String[] font = ";".split(titleFontName.getText());
        window.getWindowBase().getTitlePart().setTitleTextFont(new Font(font[0], Double.parseDouble(font[1])));
    }

    public void getIconPath(MouseEvent mouseEvent) {
        iconPathResult.setText(window.getWindowBase().getIconPart().getIcon());
    }

    public void setIconPath(MouseEvent mouseEvent) {
        window.getWindowBase().getIconPart().setIcon(iconPath.getText());
    }

    public void changeIconVisible(MouseEvent mouseEvent) {
        window.getWindowBase().getIconPart().setIconIsVisible(!window.getWindowBase().getIconPart().getIconIsVisible());
    }

    public void getIconIsSvg(MouseEvent mouseEvent) {
        iconIsSvgResult.setText(String.valueOf(window.getWindowBase().getIconPart().getIconIsSvg()));
    }

    public void getSvgIconZoom(MouseEvent mouseEvent) {
        svgIconZoomResult.setText(String.valueOf(window.getWindowBase().getIconPart().getSvgIconZoom()));
    }

    public void setSvgIconZoom(MouseEvent mouseEvent) {
        window.getWindowBase().getIconPart().setSvgIconZoom(Double.parseDouble(svgIconZoom.getText()));
    }

    public void removeIcon(MouseEvent mouseEvent) {
        window.getWindowBase().getIconPart().removeIcon();
    }

    public void getAnimationDuration(MouseEvent mouseEvent) {
        animationDurationResult.setText(String.valueOf(window.getWindowBase().getWindowPart().getAnimationDuration().toMillis()));
    }

    public void setAnimationDuration(MouseEvent mouseEvent) {
        window.getWindowBase().getWindowPart().setAnimationDuration(Duration.millis(Double.parseDouble(animationDuration.getText())));
    }

    public void changeAnimationDuration(MouseEvent mouseEvent) {
        window.getWindowBase().getWindowPart().setSmoothColorAnim(!window.getWindowBase().getWindowPart().getSmoothColorAnim());
    }

    public void changeSavingPosition(MouseEvent mouseEvent) {
        window.getWindowBase().getWindowPart().setSaveWindowPosition(!window.getWindowBase().getWindowPart().getSaveWindowPosition());
    }

    public void changeIsResizable(MouseEvent mouseEvent) {
        window.getWindowBase().getWindowPart().setResizable(!window.getWindowBase().getWindowPart().isResizable());
    }

    public void changeIsDraggable(MouseEvent mouseEvent) {
        window.getWindowBase().getWindowPart().setDraggable(!window.getWindowBase().getWindowPart().isDraggable());
    }

    public void changeIsMaximizable(MouseEvent mouseEvent) {
        window.getWindowBase().getWindowPart().setMaximizable(!window.getWindowBase().getWindowPart().isMaximizable());
    }

    public void changeIsMinimizable(MouseEvent mouseEvent) {
        window.getWindowBase().getWindowPart().setMinimizable(!window.getWindowBase().getWindowPart().isMinimizable());
    }

    public void changeIsClosable(MouseEvent mouseEvent) {
        window.getWindowBase().getWindowPart().setClosable(!window.getWindowBase().getWindowPart().isClosable());
    }

    public void getButtonDisableOpacity(MouseEvent mouseEvent) {
        buttonDisableOpacityResult.setText(String.valueOf(window.getWindowBase().getWindowPart().getDisabledOpacity()));
    }

    public void setButtonDusableOpacityResult(MouseEvent mouseEvent) {
        window.getWindowBase().getWindowPart().setDisabledOpacity(Double.parseDouble(buttonDisableOpacity.getText()));
    }

    public void getTitleBackground(MouseEvent mouseEvent) {
        titleBackgroundResult.setText(String.valueOf(window.getWindowBase().getTitleBarPart().getTitleBackground()));
    }

    public void setTitleBackground(MouseEvent mouseEvent) {
        window.getWindowBase().getTitleBarPart().setTitleBackground(Color.web(titleBackground.getText()));
    }

    public void changeTitleOrder(MouseEvent mouseEvent) {
        if (window.getWindowBase().getTitleBarPart().getOrder() == NodeOrientation.LEFT_TO_RIGHT) {
            window.getWindowBase().getTitleBarPart().setOrder(NodeOrientation.RIGHT_TO_LEFT);
        } else {
            window.getWindowBase().getTitleBarPart().setOrder(NodeOrientation.LEFT_TO_RIGHT);
        }
    }

    public void changeContextMenuIsEnabled(MouseEvent mouseEvent) {
        window.getWindowBase().getContextPart().setContextMenuIsEnabled(!window.getWindowBase().getContextPart().getContextMenuIsEnabled());
    }

    public void getShadowDepth(MouseEvent mouseEvent) {
        shadowDepthResult.setText(window.getWindowBase().getTitleBarPart().getShadowDepth().name());
    }

    public void setShadowDepth(MouseEvent mouseEvent) {
        window.getWindowBase().getTitleBarPart().setShadowDepth(TitleShadowDepth.valueOf("DEPTH" + shadowDepth.getText()));
    }

    public void getButtonHoverColor(MouseEvent mouseEvent) {
        buttonHoverColorResult.setText(String.valueOf(window.getWindowBase().getButtonPart().getButtonHoverColor()));
    }

    public void setButtonHoverColor(MouseEvent mouseEvent) {
        window.getWindowBase().getButtonPart().setButtonHoverColor(Color.web(buttonHoverColor.getText()));
    }

    public void getButtonPressedColor(MouseEvent mouseEvent) {
        buttonPressedColorResult.setText(String.valueOf(window.getWindowBase().getButtonPart().getButtonPressedColor()));
    }

    public void setButtonPressedColor(MouseEvent mouseEvent) {
        window.getWindowBase().getButtonPart().setButtonPressedColor(Color.web(buttonPressedColor.getText()));
    }

    public void changeToolTipsVisibility(MouseEvent mouseEvent) {
        window.getWindowBase().getButtonPart().setTooltipIsEnabled(!window.getWindowBase().getButtonPart().getTooltipIsEnabled());
    }

    public void changeCloseButtonVisible(MouseEvent mouseEvent) {
        window.getWindowBase().getButtonPart().setCloseButtonIsVisible(!window.getWindowBase().getButtonPart().getCloseButtonIsVisible());
    }

    public void changeMaxButtonVisible(MouseEvent mouseEvent) {
        window.getWindowBase().getButtonPart().setMaxButtonIsVisible(!window.getWindowBase().getButtonPart().getMaxButtonIsVisible());
    }

    public void changeMinButtonVisible(MouseEvent mouseEvent) {
        window.getWindowBase().getButtonPart().setMinButtonIsVisible(!window.getWindowBase().getButtonPart().getMinButtonIsVisible());
    }
}
