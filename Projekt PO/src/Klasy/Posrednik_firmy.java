package Klasy;

public class Posrednik_firmy extends Klient {

    private String nazwa_firmy;
    private int KRS;
    public Posrednik_firmy(String imie, String nazwisko, int PESEL, String nazwa_firmy, int KRS) {
        super(imie, nazwisko, PESEL);
        this.nazwa_firmy = nazwa_firmy;
        this.KRS = KRS;
    }

    @Override
    public String toString() {
        return super.toString() + " NazwaFirmy - " +nazwa_firmy+ " Krs - "+KRS;
    }
}
