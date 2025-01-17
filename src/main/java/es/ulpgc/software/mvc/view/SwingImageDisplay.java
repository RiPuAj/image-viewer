package es.ulpgc.software.mvc.view;

import es.ulpgc.software.mvc.model.Image;

import javax.swing.*;
import java.awt.*;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Image currentImage;

    @Override
    public void show(Image image) {
        this.currentImage = image;
        repaint();
    }

    @Override
    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image image) {
        this.currentImage = image;
    }

    @Override
    public void paint(Graphics g) {

    }
}
