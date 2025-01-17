package es.ulpgc.software.view;

import es.ulpgc.software.model.Image;

import javax.swing.*;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Image currentImage;

    public SwingImageDisplay(Image currentImage) {
        this.currentImage = currentImage;
    }

    @Override
    public void show(Image image) {

    }
    
    public Image getCurrentImage() {
        return currentImage;
    }
}
