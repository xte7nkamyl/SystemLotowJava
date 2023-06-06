package Klasy;

import java.io.Serializable;

/**
 * klasa w ktorej tworzony jest obiekt samolotu typu klasa pierwsza
 */
public class Klasa_pierwsza extends Samolot implements Serializable {

    /**
     * Konstruktor tworzacy konkretny obiekt samolotu. Zawiera odwolanie do pol klasy nadrzednej do ktorych zostaly przypisane konkretne wartosci.
     */
    public Klasa_pierwsza() {
        super(200, 600);
    }

    /**
     * Metoda nadpisujaca ktora zwraca konretny typ samolotu.
     * @return
     */
    @Override
    public String toString() {
        return "Klasa_pierwsza " +  super.toString();
    }
}
