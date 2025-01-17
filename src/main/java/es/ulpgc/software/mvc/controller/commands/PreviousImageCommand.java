package es.ulpgc.software.mvc.controller.commands;

import es.ulpgc.software.mvc.controller.Command;
import es.ulpgc.software.mvc.view.ImageDisplay;

public class PreviousImageCommand implements Command {
    private final ImageDisplay display;

    public PreviousImageCommand(ImageDisplay imageDisplay) {
        this.display = imageDisplay;
    }

    @Override
    public void execute() {

        display.show(display.getCurrentImage().previous());
    }
}
