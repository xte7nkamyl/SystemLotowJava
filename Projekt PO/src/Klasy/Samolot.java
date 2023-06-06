package Klasy;

import java.io.Serializable;

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
     * Metoda pobierajaca ilosc miejsc.
     * @return
     */
    public int getIloscMiejsc() {
        return iloscMiejsc;
    }

    /**
     * Metoda ustawiajaca ilosc miejsc.
     * @param iloscMiejsc
     * @return
     */
    public int setIloscMiejsc(int iloscMiejsc) {
        if (iloscMiejsc > 0)
            this.iloscMiejsc = iloscMiejsc;
        else
            this.iloscMiejsc = 0;

        return this.iloscMiejsc;

    }

    /**
     * Metoda pobierajaca zasieg samolotu.
     * @return
     */
    public int getZasieg() {
        return zasieg;
    }

    /**
     * Metoda ustawiajaca zasieg samolotu.
     * @return
     */
    public int setZasieg(int zasieg) {
        if (zasieg > 0)
            this.zasieg = zasieg;
         else
            this.zasieg = 0;

        return this.zasieg;
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
