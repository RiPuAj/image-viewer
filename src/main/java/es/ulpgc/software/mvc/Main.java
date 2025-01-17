package es.ulpgc.software.mvc;

import es.ulpgc.software.mvc.controller.commands.NextImageCommand;
import es.ulpgc.software.mvc.controller.commands.PreviousImageCommand;
import es.ulpgc.software.mvc.io.FileImageLoader;
import es.ulpgc.software.mvc.view.MainFrame;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileImageLoader imagesDir = new FileImageLoader(new File("images"));
        MainFrame mainFrame = new MainFrame();
        mainFrame.addCommand(
                "next", new NextImageCommand(mainFrame.getImageDisplay()))
                .addCommand("prev", new PreviousImageCommand(mainFrame.getImageDisplay()));
        mainFrame.getImageDisplay().show(imagesDir.load());
        mainFrame.setVisible(true);
    }
}
