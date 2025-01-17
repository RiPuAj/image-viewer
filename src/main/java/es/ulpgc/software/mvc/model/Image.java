package es.ulpgc.software.mvc.model;

public interface Image {
    Image previous();
    Image next();
    String path();
}
