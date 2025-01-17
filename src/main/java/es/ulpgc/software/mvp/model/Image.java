package es.ulpgc.software.mvp.model;

public interface Image {
    Image previous();
    Image next();
    String path();
}
