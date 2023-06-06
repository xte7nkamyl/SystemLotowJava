package Klasy;

import java.io.Serializable;

public class Trasa implements Serializable {
    private int odleglosc;
    private Lotnisko poczatek;
    private Lotnisko koniec;
    private int czasLotu;

    /**
     * Konstruktor z czterema parametrami. Dwa z nich sa typu lotnisko a dwa nastepne typu int.
     * @param odleglosc
     * @param poczatek
     * @param koniec
     * @param czasLotu
     */
    public Trasa(int odleglosc, Lotnisko poczatek, Lotnisko koniec, int czasLotu) {
        this.odleglosc = odleglosc;
        this.poczatek = poczatek;
        this.koniec = koniec;
        this.czasLotu = czasLotu;
    }


    /**
     * Metoda pobierajaca czas wylotu.
     * @return
     */
    public int getCzasLotu() {
        return czasLotu;
    }

    /**
     * Metoda ustawiajaca czas wylotu.
     * @param czasLotu
     * @return
     */
    public int setCzasLotu(int czasLotu) {
        if (czasLotu > 0)
            this.czasLotu = czasLotu;
        else
            this.czasLotu = 0;

        return this.czasLotu;
    }

    /**
     * Metoda pobierajaca odleglosc.
     * @return
     */
    public int getOdleglosc() {
        return odleglosc;
    }

    /**
     * Metoda ustawiajaca odleglosc.
     * @param odleglosc
     * @return
     */
    public int setOdleglosc(int odleglosc) {
        if (odleglosc > 0)
            this.odleglosc = odleglosc;
        else
            this.odleglosc = 0;

        return this.odleglosc;

    }

    /**
     * Metoda nadpisujaca ktora wyswietla dane trasy - odleglosc, miejsce poczatkowe i koncowe oraz czas trwania lotu.
     * @return
     */
    @Override
    public String toString() {
        return "Odległość - " + odleglosc + " Miejsce początkowe - " + poczatek + " Miejsce końcowe - " + koniec + " Czas lotu - " + czasLotu + "\n";
    }
}
