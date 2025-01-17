package es.ulpgc.software.mvc.controller.commands;

import es.ulpgc.software.mvc.controller.Command;
import es.ulpgc.software.mvc.view.ImageDisplay;

public class NextImageCommand implements Command {
    private final ImageDisplay display;

    public NextImageCommand(ImageDisplay display) {
        this.display = display;
    }

    @Override
    public void execute() {
        display.show(display.getCurrentImage().next());
    }
}
