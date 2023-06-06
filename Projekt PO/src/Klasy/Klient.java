package Klasy;


import java.io.Serializable;

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

    /**
     * Metoda pobierjaca zmienna imie.
     * @param imie
     * @return
     */
    public String getImie(String imie) {
        return imie;
    }

    /**
     * Metoda pobierajaca zmienna nazwisko.
     * @param nazwisko
     * @return
     */
    public String getNazwisko(String nazwisko) {
        return nazwisko;
    }

    /**
     * Metoda zwracajaca zmienna PESEL.
     * @param PESEL
     * @return
     */
    public int getPESEL(int PESEL) {
        return PESEL;
    }

    /**
     * Metoda ktora zwraca pozyskane dane obiektu klient.
     * @return
     */
    @Override
    public String toString() {
        return "Imię - " + imie.toString() + " Nazwisko - " + nazwisko.toString() + " PESEL - " + PESEL+"\n";
    }
}
