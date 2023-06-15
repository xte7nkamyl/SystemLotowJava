package Klasy;


import java.io.Serializable;

/**
 * klasa w ktorej tworzony jest obiekt klienta
 */
public class Klient implements Serializable {

    protected String imie;
    protected String nazwisko;
    protected int PESEL;

    /**
     * Konstruktor z trzema parametrami tworzacy obiekt klient. Kazdy klient charakteryzuje sie imieniem, nazwiskiem i numerem PESEL.
     * @param imie
     * @param nazwisko
     * @param PESEL
     */
    public Klient(String imie, String nazwisko, int PESEL) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
    }

    @Override
    public String toString() {
        return "Imię - " + imie.toString() + " Nazwisko - " + nazwisko.toString() + " PESEL - " + PESEL+"\n";
    }
}
