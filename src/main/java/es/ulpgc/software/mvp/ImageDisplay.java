package es.ulpgc.software.mvp;


import java.io.IOException;

public interface ImageDisplay {
    void paint(String filename, int offset);
    int getWidth();
    void clear();
    void on(Shift shift);
    void on(Released released);

    interface Shift {
        Shift Null = offset -> {};
        void offset(int offset);
    }
    interface Released {
        Released Null = offset -> {};
        void offset(int offset);
    }
}
