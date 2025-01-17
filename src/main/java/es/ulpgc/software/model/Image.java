package es.ulpgc.software.model;

public interface Image {
    Image previous();
    Image next();
    String path();
}
