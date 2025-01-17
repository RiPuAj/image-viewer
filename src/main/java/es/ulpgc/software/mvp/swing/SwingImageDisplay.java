package es.ulpgc.software.mvp.swing;

import es.ulpgc.software.mvp.ImageDisplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private int initShift;
    private Released released = Released.Null;
    private Shift shift = Shift.Null;
    private List<Paint> paints = new ArrayList<>();

    public SwingImageDisplay() {
        this.addMouseListener(mouseListener());
        this.addMouseMotionListener(mouseMotionListener());
    }

    @Override
    public void paint(String filename, int offset) {
        clear();
        try {
            paints.add(new Paint(filename, offset, ImageIO.read(new File(filename))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        repaint();

    }

    @Override
    public void paint(Graphics g){
        for (Paint paint : paints) {
            g.setColor(Color.BLACK);
            g.drawImage(paint.image(), paint.offset, 0,getWidth(), getHeight(), null);
        }
    }

    @Override
    public void clear() {
        paints.clear();
    }

    @Override
    public void on(Shift shift) {
        this.shift = shift != null ? shift : Shift.Null;
    }

    @Override
    public void on(Released released) {
        this.released = released != null ? released : Released.Null;
    }

    private MouseListener mouseListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                initShift = e.getX();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                released.offset(e.getX() - initShift);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }

    private MouseMotionListener mouseMotionListener() {
        return new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                shift.offset(e.getX() - initShift);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        };
    }

    private record Paint(String id, int offset, BufferedImage image) {}
}
