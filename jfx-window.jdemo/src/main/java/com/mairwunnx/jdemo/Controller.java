package com.mairwunnx.jdemo;

import javafx.geometry.NodeOrientation;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
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
        titleTextResult.setText(window.getWindowBase().getTitlePart().getTitleText());
    }

    public void setTitleText() {
        window.getWindowBase().getTitlePart().setTitleText(titleTextTextField.getText());
    }

    public void changeTitleVisibility(MouseEvent mouseEvent) {
        ToggleButton toggleButton = (ToggleButton) mouseEvent.getSource();
        window.getWindowBase().getTitlePart().setTitleIsVisible(toggleButton.isSelected());
    }

    public void changeTitleAlign() {
        if (titleAlignTextField.getText().toLowerCase().equals(TitleAlignment.CENTER.name().toLowerCase())) {
            window.getWindowBase().getTitlePart().setTitleAlignment(TitleAlignment.CENTER);
        } else {
            window.getWindowBase().getTitlePart().setTitleAlignment(TitleAlignment.LEFT);
        }
    }

    public void getTitleAlign() {
        titleAlignResult.setText(window.getWindowBase().getTitlePart().getTitleAlignment().name());
    }

    public void getTitleFont() {
        titleFontResult.setText(window.getWindowBase().getTitlePart().getTitleTextFont().toString());
    }

    public void setTitleFont() {
        String[] font = ";".split(titleFontName.getText());
        window.getWindowBase().getTitlePart().setTitleTextFont(new Font(font[0], Double.parseDouble(font[1])));
    }

    public void getIconPath() {
        iconPathResult.setText(window.getWindowBase().getIconPart().getIcon());
    }

    public void setIconPath() {
        window.getWindowBase().getIconPart().setIcon(iconPath.getText());
    }

    public void changeIconVisible() {
        window.getWindowBase().getIconPart().setIconIsVisible(!window.getWindowBase().getIconPart().getIconIsVisible());
    }

    public void getIconIsSvg() {
        iconIsSvgResult.setText(String.valueOf(window.getWindowBase().getIconPart().getIconIsSvg()));
    }

    public void getSvgIconZoom() {
        svgIconZoomResult.setText(String.valueOf(window.getWindowBase().getIconPart().getSvgIconZoom()));
    }

    public void setSvgIconZoom() {
        window.getWindowBase().getIconPart().setSvgIconZoom(Double.parseDouble(svgIconZoom.getText()));
    }

    public void removeIcon() {
        window.getWindowBase().getIconPart().removeIcon();
    }

    public void getAnimationDuration() {
        animationDurationResult.setText(String.valueOf(window.getWindowBase().getWindowPart().getAnimationDuration().toMillis()));
    }

    public void setAnimationDuration() {
        window.getWindowBase().getWindowPart().setAnimationDuration(Duration.millis(Double.parseDouble(animationDuration.getText())));
    }

    public void changeAnimationDuration() {
        window.getWindowBase().getWindowPart().setSmoothColorAnim(!window.getWindowBase().getWindowPart().getSmoothColorAnim());
    }

    public void changeSavingPosition() {
        window.getWindowBase().getWindowPart().setSaveWindowPosition(!window.getWindowBase().getWindowPart().getSaveWindowPosition());
    }

    public void changeIsResizable() {
        window.getWindowBase().getWindowPart().setResizable(!window.getWindowBase().getWindowPart().isResizable());
    }

    public void changeIsDraggable() {
        window.getWindowBase().getWindowPart().setDraggable(!window.getWindowBase().getWindowPart().isDraggable());
    }

    public void changeIsMaximizable() {
        window.getWindowBase().getWindowPart().setMaximizable(!window.getWindowBase().getWindowPart().isMaximizable());
    }

    public void changeIsMinimizable() {
        window.getWindowBase().getWindowPart().setMinimizable(!window.getWindowBase().getWindowPart().isMinimizable());
    }

    public void changeIsClosable() {
        window.getWindowBase().getWindowPart().setClosable(!window.getWindowBase().getWindowPart().isClosable());
    }

    public void getButtonDisableOpacity() {
        buttonDisableOpacityResult.setText(String.valueOf(window.getWindowBase().getWindowPart().getDisabledOpacity()));
    }

    public void setButtonDusableOpacityResult() {
        window.getWindowBase().getWindowPart().setDisabledOpacity(Double.parseDouble(buttonDisableOpacity.getText()));
    }

    public void getTitleBackground() {
        titleBackgroundResult.setText(String.valueOf(window.getWindowBase().getTitleBarPart().getTitleBackground()));
    }

    public void setTitleBackground() {
        window.getWindowBase().getTitleBarPart().setTitleBackground(Color.web(titleBackground.getText()));
    }

    public void changeTitleOrder() {
        if (window.getWindowBase().getTitleBarPart().getOrder() == NodeOrientation.LEFT_TO_RIGHT) {
            window.getWindowBase().getTitleBarPart().setOrder(NodeOrientation.RIGHT_TO_LEFT);
        } else {
            window.getWindowBase().getTitleBarPart().setOrder(NodeOrientation.LEFT_TO_RIGHT);
        }
    }

    public void changeContextMenuIsEnabled() {
        window.getWindowBase().getContextPart().setContextMenuIsEnabled(!window.getWindowBase().getContextPart().getContextMenuIsEnabled());
    }

    public void getShadowDepth() {
        shadowDepthResult.setText(window.getWindowBase().getTitleBarPart().getShadowDepth().name());
    }

    public void setShadowDepth() {
        window.getWindowBase().getTitleBarPart().setShadowDepth(TitleShadowDepth.valueOf("DEPTH" + shadowDepth.getText()));
    }

    public void getButtonHoverColor() {
        buttonHoverColorResult.setText(String.valueOf(window.getWindowBase().getButtonPart().getButtonHoverColor()));
    }

    public void setButtonHoverColor() {
        window.getWindowBase().getButtonPart().setButtonHoverColor(Color.web(buttonHoverColor.getText()));
    }

    public void getButtonPressedColor() {
        buttonPressedColorResult.setText(String.valueOf(window.getWindowBase().getButtonPart().getButtonPressedColor()));
    }

    public void setButtonPressedColor() {
        window.getWindowBase().getButtonPart().setButtonPressedColor(Color.web(buttonPressedColor.getText()));
    }

    public void changeToolTipsVisibility() {
        window.getWindowBase().getButtonPart().setTooltipIsEnabled(!window.getWindowBase().getButtonPart().getTooltipIsEnabled());
    }

    public void changeCloseButtonVisible() {
        window.getWindowBase().getButtonPart().setCloseButtonIsVisible(!window.getWindowBase().getButtonPart().getCloseButtonIsVisible());
    }

    public void changeMaxButtonVisible() {
        window.getWindowBase().getButtonPart().setMaxButtonIsVisible(!window.getWindowBase().getButtonPart().getMaxButtonIsVisible());
    }

    public void changeMinButtonVisible() {
        window.getWindowBase().getButtonPart().setMinButtonIsVisible(!window.getWindowBase().getButtonPart().getMinButtonIsVisible());
    }

    public void getBorderColor() {
        borderColorResult.setText(String.valueOf(window.getWindowBase().getBorderPart().getBorderColor()));
    }

    public void setBorderColor() {
        window.getWindowBase().getBorderPart().setBorderColor(Color.web(borderColor.getText()));
    }

    public void getBorderInactiveColor() {
        borderInactiveColorResult.setText(String.valueOf(window.getWindowBase().getBorderPart().getBorderInactiveColor()));
    }

    public void setBorderInactiveColor() {
        window.getWindowBase().getBorderPart().setBorderInactiveColor(Color.web(borderInactiveColor.getText()));
    }

    public void changeBottomBorderVisible() {
        window.getWindowBase().getBorderPart().setBottomBorderIsVisible(!window.getWindowBase().getBorderPart().getBottomBorderIsVisible());
    }

    public void changeBorderIsVisible() {
        window.getWindowBase().getBorderPart().setBorderIsVisible(!window.getWindowBase().getBorderPart().getBorderIsVisible());
    }
}
