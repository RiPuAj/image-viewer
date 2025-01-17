package es.ulpgc.software.mvc;

import es.ulpgc.software.mvc.controller.commands.NextImageCommand;
import es.ulpgc.software.mvc.controller.commands.PreviousImageCommand;
import es.ulpgc.software.mvc.io.FileImageLoader;
import es.ulpgc.software.mvc.view.MainFrame;

import java.io.File;

public class Main {
    public static final String root = "images";
    public static void main(String[] args) {
        FileImageLoader fileImageLoader = new FileImageLoader(new File(root));
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(fileImageLoader.load());
        mainFrame.addCommand("prev", new PreviousImageCommand(mainFrame.getImageDisplay()))
                .addCommand("next", new NextImageCommand(mainFrame.getImageDisplay()));
        mainFrame.setVisible(true);
    }
}
