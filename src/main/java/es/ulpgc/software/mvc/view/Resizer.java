package es.ulpgc.software.mvc.view;

public class Resizer {
    public static Size resize(int widthPanel, int heightPanel, int widthImage, int heightImage) {
        double scale = Math.min(getScaleXFactor(widthPanel, widthImage), getScaleYFactor(heightPanel, heightImage));

        return new Size(
                (int)(widthPanel-(widthImage*scale)) / 2,
                (int)(heightPanel-(heightImage*scale)) / 2,
                (int)(widthImage*scale),
                (int)(heightImage*scale)
        );
    }

    private static double getScaleYFactor(int heightPanel, int heightImage) {
        return (double) heightPanel / heightImage;
    }

    private static double getScaleXFactor(int widthPanel, int widthImage) {
        return (double) widthPanel / widthImage;
    }
}
