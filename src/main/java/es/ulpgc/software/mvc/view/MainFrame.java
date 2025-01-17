package es.ulpgc.software.mvc.view;

import es.ulpgc.software.mvc.controller.Command;
import es.ulpgc.software.mvc.controller.commands.NextImageCommand;
import es.ulpgc.software.mvc.controller.commands.PreviousImageCommand;

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
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(createImageDisplay());
        add(createToolBar());
    }

    private Component createImageDisplay() {
        es.ulpgc.software.mvc.view.ImageDisplay imageDisplay = new SwingImageDisplay();
        this.imageDisplay = imageDisplay;
        return (Component) imageDisplay;
    }

    private Component createPrevButton() {
        JButton prevButton = new JButton("<-");
        prevButton.addActionListener(e -> commands.get("prev").execute());
        return prevButton;
    }

    private Component createNextButton() {
        JButton nextButton = new JButton("->");
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
