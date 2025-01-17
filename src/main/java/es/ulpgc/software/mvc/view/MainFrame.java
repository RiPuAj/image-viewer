package es.ulpgc.software.mvc.view;

import es.ulpgc.software.mvc.controller.Command;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;
    private Map<String, Command> commands;

    public MainFrame() {
        this.commands = new HashMap<>();
        setTitle("Image Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(createImageDisplay());
        add(createToolBar(), BorderLayout.SOUTH);
    }

    private Component createImageDisplay() {
        SwingImageDisplay imageDisplay = new SwingImageDisplay();
        this.imageDisplay = imageDisplay;
        return imageDisplay;
    }

    private Component createPrevButton() {
        JButton prevButton = new JButton("Previous");
        prevButton.addActionListener(e -> commands.get("prev").execute());
        return prevButton;
    }

    private Component createNextButton() {
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> commands.get("next").execute());
        return nextButton;
    }

    private Component createToolBar() {
        JPanel toolBar = new JPanel();
        toolBar.add(createPrevButton());
        toolBar.add(createNextButton());
        return toolBar;
    }

    public MainFrame addCommand(String name, Command command) {
        commands.put(name, command);
        return this;
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
}
