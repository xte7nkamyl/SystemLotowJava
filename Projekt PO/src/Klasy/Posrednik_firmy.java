package Klasy;
/**
 * klasa w ktorej tworzony jest obiekt posrednik firmy
 */
public class Posrednik_firmy extends Klient {

    private String nazwa_firmy;
    private int KRS;

    /**
     * Konstruktor tworzacy obiekt posrednik firmy. Zawiera odwolanie sie do pol (imie, nazwisko, PESEL) klasy nadrzednej i dodaje dwie nowe zmienne - nazwa firmy i numer KRS
     * @param imie
     * @param nazwisko
     * @param PESEL
     * @param nazwa_firmy
     * @param KRS
     */
    public Posrednik_firmy(String imie, String nazwisko, int PESEL, String nazwa_firmy, int KRS) {
        super(imie, nazwisko, PESEL);
        this.nazwa_firmy = nazwa_firmy;
        this.KRS = KRS;
    }

    /**
     * Metoda nadpisujaca ktora wyswietla dane firmy - nazwe i numer KRS
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + " Nazwa Firmy - " +nazwa_firmy+ " KRS - "+KRS;
    }
}
