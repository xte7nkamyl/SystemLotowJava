package Klasy;
import java.io.Serializable;
/**
 * klasa w ktorej tworzony jest obiekt trasy
 */
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
     * Metoda pobierajaca odleglosc.
     * @return
     */
    public int getOdleglosc() {
        return odleglosc;
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
