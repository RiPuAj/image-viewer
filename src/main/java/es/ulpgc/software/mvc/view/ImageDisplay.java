package es.ulpgc.software.mvc.view;

import es.ulpgc.software.mvc.model.Image;

public interface ImageDisplay {
    void show(Image image);
    Image getCurrentImage();
}
