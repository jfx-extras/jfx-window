package com.mairwunnx.jdemo;

import javafx.geometry.NodeOrientation;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import jfxwindow.enums.ShadowStyle;
import jfxwindow.enums.TitleAlignment;
import jfxwindow.enums.TitleShadowDepth;

import static com.mairwunnx.jdemo.EntryPoint.window;

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
    public TextField borderColorResult;
    public TextField borderColor;
    public TextField borderInactiveColorResult;
    public TextField borderInactiveColor;

    public void getTitleText() {
        titleTextResult.setText(window.getInstance().getTitlePart().getTitleText());
    }

    public void setTitleText() {
        window.getInstance().getTitlePart().setTitleText(titleTextTextField.getText());
    }

    public void changeTitleVisibility(MouseEvent mouseEvent) {
        ToggleButton toggleButton = (ToggleButton) mouseEvent.getSource();
        window.getInstance().getTitlePart().setTitleIsVisible(toggleButton.isSelected());
    }

    public void changeTitleAlign() {
        if (titleAlignTextField.getText().toLowerCase().equals(TitleAlignment.CENTER.name().toLowerCase())) {
            window.getInstance().getTitlePart().setTitleAlignment(TitleAlignment.CENTER);
        } else {
            window.getInstance().getTitlePart().setTitleAlignment(TitleAlignment.LEFT);
        }
    }

    public void getTitleAlign() {
        titleAlignResult.setText(window.getInstance().getTitlePart().getTitleAlignment().name());
    }

    public void getTitleFont() {
        titleFontResult.setText(window.getInstance().getTitlePart().getTitleTextFont().toString());
    }

    public void setTitleFont() {
        String[] font = ";".split(titleFontName.getText());
        window.getInstance().getTitlePart().setTitleTextFont(new Font(font[0], Double.parseDouble(font[1])));
    }

    public void getIconPath() {
        iconPathResult.setText(window.getInstance().getIconPart().getIcon());
    }

    public void setIconPath() {
        window.getInstance().getIconPart().setIcon(iconPath.getText());
    }

    public void changeIconVisible() {
        window.getInstance().getIconPart().setIconIsVisible(!window.getInstance().getIconPart().getIconIsVisible());
    }

    public void getIconIsSvg() {
        iconIsSvgResult.setText(String.valueOf(window.getInstance().getIconPart().getIconIsSvg()));
    }

    public void getSvgIconZoom() {
        svgIconZoomResult.setText(String.valueOf(window.getInstance().getIconPart().getSvgIconZoom()));
    }

    public void setSvgIconZoom() {
        window.getInstance().getIconPart().setSvgIconZoom(Double.parseDouble(svgIconZoom.getText()));
    }

    public void removeIcon() {
        window.getInstance().getIconPart().removeIcon();
    }

    public void getAnimationDuration() {
        animationDurationResult.setText(String.valueOf(window.getInstance().getWindowPart().getAnimationDuration().toMillis()));
    }

    public void setAnimationDuration() {
        window.getInstance().getWindowPart().setAnimationDuration(Duration.millis(Double.parseDouble(animationDuration.getText())));
    }

    public void changeAnimationDuration() {
        window.getInstance().getWindowPart().setSmoothColorAnim(!window.getInstance().getWindowPart().getSmoothColorAnim());
    }

    public void changeSavingPosition() {
        window.getInstance().getWindowPart().setSaveWindowPosition(!window.getInstance().getWindowPart().getSaveWindowPosition());
    }

    public void changeIsResizable() {
        window.getInstance().getWindowPart().setResizable(!window.getInstance().getWindowPart().isResizable());
    }

    public void changeIsDraggable() {
        window.getInstance().getWindowPart().setDraggable(!window.getInstance().getWindowPart().isDraggable());
    }

    public void changeIsMaximizable() {
        window.getInstance().getWindowPart().setMaximizable(!window.getInstance().getWindowPart().isMaximizable());
    }

    public void changeIsMinimizable() {
        window.getInstance().getWindowPart().setMinimizable(!window.getInstance().getWindowPart().isMinimizable());
    }

    public void changeIsClosable() {
        window.getInstance().getWindowPart().setClosable(!window.getInstance().getWindowPart().isClosable());
    }

    public void getButtonDisableOpacity() {
        buttonDisableOpacityResult.setText(String.valueOf(window.getInstance().getWindowPart().getDisabledOpacity()));
    }

    public void setButtonDusableOpacityResult() {
        window.getInstance().getWindowPart().setDisabledOpacity(Double.parseDouble(buttonDisableOpacity.getText()));
    }

    public void getTitleBackground() {
        titleBackgroundResult.setText(String.valueOf(window.getInstance().getTitleBarPart().getTitleBackground()));
    }

    public void setTitleBackground() {
        window.getInstance().getTitleBarPart().setTitleBackground(Color.web(titleBackground.getText()));
    }

    public void changeTitleOrder() {
        if (window.getInstance().getTitleBarPart().getOrder() == NodeOrientation.LEFT_TO_RIGHT) {
            window.getInstance().getTitleBarPart().setOrder(NodeOrientation.RIGHT_TO_LEFT);
        } else {
            window.getInstance().getTitleBarPart().setOrder(NodeOrientation.LEFT_TO_RIGHT);
        }
    }

    public void changeContextMenuIsEnabled() {
        window.getInstance().getContextPart().setContextMenuIsEnabled(!window.getInstance().getContextPart().getContextMenuIsEnabled());
    }

    public void getShadowDepth() {
        shadowDepthResult.setText(window.getInstance().getTitleBarPart().getShadowDepth().name());
    }

    public void setShadowDepth() {
        window.getInstance().getTitleBarPart().setShadowDepth(TitleShadowDepth.valueOf("DEPTH" + shadowDepth.getText()));
    }

    public void getButtonHoverColor() {
        buttonHoverColorResult.setText(String.valueOf(window.getInstance().getButtonPart().getButtonHoverColor()));
    }

    public void setButtonHoverColor() {
        window.getInstance().getButtonPart().setButtonHoverColor(Color.web(buttonHoverColor.getText()));
    }

    public void getButtonPressedColor() {
        buttonPressedColorResult.setText(String.valueOf(window.getInstance().getButtonPart().getButtonPressedColor()));
    }

    public void setButtonPressedColor() {
        window.getInstance().getButtonPart().setButtonPressedColor(Color.web(buttonPressedColor.getText()));
    }

    public void changeToolTipsVisibility() {
        window.getInstance().getButtonPart().setTooltipIsEnabled(!window.getInstance().getButtonPart().getTooltipIsEnabled());
    }

    public void changeCloseButtonVisible() {
        window.getInstance().getButtonPart().setCloseButtonIsVisible(!window.getInstance().getButtonPart().getCloseButtonIsVisible());
    }

    public void changeMaxButtonVisible() {
        window.getInstance().getButtonPart().setMaxButtonIsVisible(!window.getInstance().getButtonPart().getMaxButtonIsVisible());
    }

    public void changeMinButtonVisible() {
        window.getInstance().getButtonPart().setMinButtonIsVisible(!window.getInstance().getButtonPart().getMinButtonIsVisible());
    }

    public void getBorderColor() {
        borderColorResult.setText(String.valueOf(window.getInstance().getBorderPart().getBorderColor()));
    }

    public void setBorderColor() {
        window.getInstance().getBorderPart().setBorderColor(Color.web(borderColor.getText()));
    }

    public void getBorderInactiveColor() {
        borderInactiveColorResult.setText(String.valueOf(window.getInstance().getBorderPart().getBorderInactiveColor()));
    }

    public void setBorderInactiveColor() {
        window.getInstance().getBorderPart().setBorderInactiveColor(Color.web(borderInactiveColor.getText()));
    }

    public void changeBottomBorderVisible() {
        window.getInstance().getBorderPart().setBottomBorderIsVisible(!window.getInstance().getBorderPart().getBottomBorderIsVisible());
    }

    public void changeBorderIsVisible() {
        window.getInstance().getBorderPart().setBorderIsVisible(!window.getInstance().getBorderPart().getBorderIsVisible());
    }

    public void changeShadowIsEnabled(MouseEvent mouseEvent) {
        ToggleButton toggleButton = (ToggleButton) mouseEvent.getSource();
        window.getInstance().getShadowPart().setWindowShadowIsEnabled(toggleButton.isSelected());
    }

    public void changeShadowType(MouseEvent mouseEvent) {
        ToggleButton toggleButton = (ToggleButton) mouseEvent.getSource();
        if (toggleButton.isSelected()) {
            window.getInstance().getShadowPart().setWindowShadowType(ShadowStyle.WIN32);
        } else {
            window.getInstance().getShadowPart().setWindowShadowType(ShadowStyle.MATERIAL);
        }
    }
}
