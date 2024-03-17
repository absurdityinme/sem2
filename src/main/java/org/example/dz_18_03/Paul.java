package org.example.dz_18_03;

public class Paul extends Fremen {
    private boolean isMuadDib;

    Paul(String name) {
        super(name);
    }

    public void setMuadDib() {
        isMuadDib = true;
    }
    public String toString() {
        return "i'm " + name + " and i'm " + (isMuadDib ? "" : "not ") + "Muad'Dib";
    }
}
