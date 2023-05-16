package Klasy;

import java.io.Serializable;

public class Klasa_pierwsza extends Samolot implements Serializable {

    public Klasa_pierwsza() {
        super(200, 6000);
    }

    @Override
    public String toString() {
        return "Klasa_pierwsza " +  super.toString();
    }
}
