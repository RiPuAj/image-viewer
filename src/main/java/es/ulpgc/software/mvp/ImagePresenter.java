package es.ulpgc.software.mvp;

import es.ulpgc.software.mvp.model.Image;

import java.io.IOException;

import static es.ulpgc.software.mvp.ImageDisplay.*;

public class ImagePresenter {
    private ImageDisplay display;
    private Image image;

    public ImagePresenter(ImageDisplay display) {
        this.display = display;
        this.display.on((Shift) this::shift);
        this.display.on((Released) this::released);
    }

    private void shift(int offset)  {
        display.clear();
        display.paint(image.path(), offset);
        if (offset > 0 ) display.paint(image.previous().path(), offset - display.getWidth());
        else display.paint(image.next().path(),  offset + display.getWidth());
    }

    private void released(int offset)  {
        if (Math.abs(offset) >= display.getWidth() / 2) this.image = offset > 0 ? image.previous() : image.next();
        repaint();
    }

    private void repaint() {
        this.display.clear();
        this.display.paint(image.path(), 0);
    }

    public void show(Image image) {
        this.image = image;
        repaint();
    }

    public ImageDisplay getDisplay() {
        return display;
    }



}
