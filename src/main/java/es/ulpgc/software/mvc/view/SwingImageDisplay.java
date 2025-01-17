package es.ulpgc.software.mvc.view;

import es.ulpgc.software.mvc.model.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Image currentImage;
    private BufferedImage imageBitMap;

    @Override
    public void show(Image image) {
        this.currentImage = image;
        this.imageBitMap = readImageFrom(image.path());
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        Size size = Resizer.resize(
                this.getWidth(),
                this.getHeight(),
                imageBitMap.getWidth(),
                imageBitMap.getHeight());

        g.drawImage(imageBitMap, size.x(), size.y(), size.width(), size.height(), null);
    }



    @Override
    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image image) {
        this.currentImage = image;
    }

    private BufferedImage readImageFrom(String path){
        try {
            System.out.println(path);
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
