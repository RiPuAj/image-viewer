package es.ulpgc.software.mvp.io;

import es.ulpgc.software.mvp.model.Image;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Set;

public class FileImageLoader implements ImageLoader {
    private final File[] images;
    private static final Set<String> imageExtensions = Set.of(".jpg", ".jpeg", ".png");
    private static FilenameFilter isImage() {return (dir, name) -> imageExtensions.stream().anyMatch(name::endsWith);}

    public FileImageLoader(File dir) {
        this.images = dir.listFiles(isImage());
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
