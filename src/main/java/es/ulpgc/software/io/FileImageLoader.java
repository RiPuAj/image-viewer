package es.ulpgc.software.io;

import es.ulpgc.software.model.Image;

import java.io.File;
import java.io.FileFilter;
import java.util.Set;

public class FileImageLoader implements ImageLoader {
    private final File[] images;
    private final Set<String> imageExtensions = Set.of(".jpg", ".jpeg", ".png");
    private final FileFilter imageFilter = file -> imageExtensions.stream()
            .anyMatch(ext -> file.getName().toLowerCase().endsWith(ext));

    public FileImageLoader(File dir) {
        this.images = dir.listFiles(imageFilter);
    }

    @Override
    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(int i) {
        return new Image() {

            @Override
            public Image previous() {
                return imageAt((i - 1 + images.length) % images.length);
            }

            @Override
            public Image next() {
                return imageAt((i + 1) % images.length);
            }

            @Override
            public String path() {
                return images[i].getAbsolutePath();
            }
        };
    }


}
