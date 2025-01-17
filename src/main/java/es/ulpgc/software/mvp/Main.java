package es.ulpgc.software.mvp;

import es.ulpgc.software.mvp.io.FileImageLoader;
import es.ulpgc.software.mvp.swing.MainFrame;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        ImagePresenter imagePresenter = new ImagePresenter(mainFrame.getImageDisplay());
        FileImageLoader images = new FileImageLoader(new File("images"));
        imagePresenter.show(images.load());
        mainFrame.setVisible(true);
    }
}
