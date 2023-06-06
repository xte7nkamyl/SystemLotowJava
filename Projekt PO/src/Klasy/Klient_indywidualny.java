package Klasy;
/**
 * klasa w ktorej tworzony jest obiekt klienta indywidualnego
 */
public class Klient_indywidualny extends Klient {
    /**
     * Konstruktor w ktorym znajduje sie odwolanie do pol klasy nadrzednej. Nie zostaly dodane dodatkowe zmienne
     * @param imie
     * @param nazwisko
     * @param PESEL
     */
    public Klient_indywidualny(String imie, String nazwisko, int PESEL) {
        super(imie, nazwisko, PESEL);
    }
}
