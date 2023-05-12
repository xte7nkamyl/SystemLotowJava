package Klasy;

public class Klient {

    protected String imie;
    protected String nazwisko;
    protected int PESEL;


    public Klient(String imie, String nazwisko, int PESEL) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
    }

    public String getImie(String imie) {
        return imie;
    }

    public String getNazwisko(String nazwisko) {
        return nazwisko;
    }

    public int getPESEL(int PESEL) {
        return PESEL;
    }

    @Override
    public String toString() {
        return "imie - " + imie.toString() + "\n Nazwisko - " + nazwisko.toString() + "\n PESEL - " + PESEL;
    }
}
