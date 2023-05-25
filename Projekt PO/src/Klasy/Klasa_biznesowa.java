package Klasy;

import java.io.Serializable;

public class Klasa_biznesowa extends Samolot implements Serializable {
    public Klasa_biznesowa() {
        super(300, 500);
    }

    @Override
    public String toString() {
        return "Klasa_Biznesowa " +  super.toString();
    }
}