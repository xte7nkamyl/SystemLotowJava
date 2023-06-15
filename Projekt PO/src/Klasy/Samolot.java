package Klasy;

import java.io.Serializable;
/**
 * klasa w ktorej tworzony jest obiekt samolotu
 */
public class Samolot implements Serializable {
    private int iloscMiejsc;
    private int zasieg;

    /**
     * Konstruktor dwuparametrowy tworzacy obiekt samolot ze zdefiniowanymi danymi.
     * @param iloscMiejsc
     * @param zasieg
     */
    public Samolot(int iloscMiejsc, int zasieg) {
        this.iloscMiejsc = iloscMiejsc;
        this.zasieg = zasieg;
    }

    /**
     * Metoda pobierajaca zasieg samolotu.
     * @return
     */
    public int getZasieg() {
        return zasieg;
    }


    /**
     * Metoda nadpisujaca ktora wyswietla parametry samolotu - ilosc miejsc i zasieg
     * @return
     */
    @Override
    public String toString() {
        return "Ilosc miejsc - " + iloscMiejsc + " Zasieg - " + zasieg + "\n";
    }
}
