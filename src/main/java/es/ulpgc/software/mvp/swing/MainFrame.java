package es.ulpgc.software.mvp.swing;

import es.ulpgc.software.mvp.ImageDisplay;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;

    public MainFrame() {
        setTitle("Image Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(createImageDisplay());
    }

    private Component createImageDisplay() {
        SwingImageDisplay imageDisplay = new SwingImageDisplay();
        this.imageDisplay = imageDisplay;
        return imageDisplay;
    }


    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
}
