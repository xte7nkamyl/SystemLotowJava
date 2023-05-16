package Klasy;

import java.io.Serializable;

public class Klasa_ekonomiczna extends Samolot implements Serializable {

    public Klasa_ekonomiczna() {
        super(400,4000);
    }

    @Override
    public String toString() {
        return "Klasa_ekonomiczna " + super.toString();
    }
}
