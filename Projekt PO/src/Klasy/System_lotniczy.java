package Klasy;
import java.time.LocalDateTime;
import java.util.*;

/**
 * klasa w ktorej sa tworzone listy  obiektow i generator lotow
 */
public class System_lotniczy  {

    private List<Klient> klienci = new ArrayList();
    private List<Trasa> trasy = new ArrayList();
    private List<Lotnisko> lotniska = new ArrayList();
    private List<Samolot> samoloty = new ArrayList();
    private List<Rezerwacja> rezerwacje = new ArrayList();
    private List<Lot> loty = new ArrayList<>();


    /**
     * Metoda dodajaca klienta do listy.
     * @param k
     */
    public void dodajKlient(Klient k) {
        klienci.add(k);
    }

    /**
     * Metoda usuwajaca klienta do listy.
     * @param k
     */
    public void usunKlient(Klient k) {
        klienci.remove(k);
    }

    /**
     * Metoda pobierajaca liste klientow.
     * @return
     */
    public List<Klient> getKlienci() {
        return klienci;
    }

    /**
     * Metoda ustawiajaca klienta w liscie.
     * @param klienci
     */
    public void setKlienci(List<Klient> klienci) {
        this.klienci = klienci;
    }

    /**
     * Metoda dodajaca trase do listy.
     * @param t
     */
    public void dodajTrasa(Trasa t) {
        trasy.add(t);
    }

    /**
     * Metoda usuwajaca trase z listy.
     * @param t
     */
    public void usunTrasa(Trasa t) {
        trasy.remove(t);
    }

    /**
     * Metoda pobierajaca liste tras.
     * @return
     */
    public List<Trasa> getTrasy() {
        return trasy;
    }

    /**
     * Metoda ustawiajaca trase w liscie.
     * @param trasy
     */
    public void setTrasy(List<Trasa> trasy) {
        this.trasy = trasy;
    }

    /**
     * Metoda dodajaca lotnisko do listy.
     * @param l
     */
    public void dodajLotnisko(Lotnisko l) {
        lotniska.add(l);
    }

    /**
     * Metoda usuwajaca lotnisko z listy.
     * @param l
     */
    public void usunLotnisko(Lotnisko l) {
        lotniska.remove(l);
    }

    /**
     * Metoda pobierajaca liste lotnisk.
     * @return
     */
    public List<Lotnisko> getLotniska() {
        return lotniska;
    }

    /**
     * Metoda ustawiajaca lostnisko w liscie.
     * @param lotniska
     */
    public void setLotniska(List<Lotnisko> lotniska) {
        this.lotniska = lotniska;
    }

    /**
     * Metoda dodajaca samolot do listy.
     * @param s
     */
    public void dodajSamolot(Samolot s) {
        samoloty.add(s);
    }

    /**
     * Metoda usuwajaca samolot z listy.
     * @param s
     */
    public void usunSamolot(Samolot s) {
        samoloty.remove(s);
    }

    /**
     * Metoda pobierajaca liste samolotow.
     * @return
     */
    public List<Samolot> getSamoloty() {
        return samoloty;
    }

    /**
     * Metoda ustawiajaca samolot w liscie.
     * @param samoloty
     */
    public void setSamoloty(List<Samolot> samoloty) {
        this.samoloty = samoloty;
    }

    /**
     * Metoda dodajaca rezerwacje do listy.
     * @param r
     */
    public void dodajRezerwacje(Rezerwacja r) {
        rezerwacje.add(r);
    }

    /**
     * Metoda usuwajaca rezerwacje z listy.
     * @param r
     */
    public void usunRezerwacje(Rezerwacja r) {
        rezerwacje.remove(r);
    }

    /**
     * Metoda wyswietlajaca liste rezerwacji.
     * @return
     */
    public List<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    /**
     * Metoda ustawiajaca rezerwacje w liscie.
     * @param rezerwacje
     */
    public void setRezerwacje(List<Rezerwacja> rezerwacje) {
        this.rezerwacje = rezerwacje;
    }


    /**
     * Metoda usuwajaca lot z listy.
     * @param l
     */
    public void usunLot(Lot l)
    {
        loty.remove(l);
    }

    /**
     * Metoda pobierajaca liste lotow.
     * @return
     */
    public List<Lot> getLoty()
    {
        return loty;
    }

    /**
     * Metoda ustawiajaca lot w liscie.
     * @param loty
     */
    public void setLoty(List<Lot> loty)
    {
        this.loty = loty;
    }

    /**
     * metoda ktora generuje lot
     * @param trasa
     * @param dataOdlotu
     * @param czestotliwosc
     */
    public void generatorLotow(Trasa trasa,LocalDateTime dataOdlotu,int czestotliwosc) {
        LocalDateTime dataPrzylotu = dataOdlotu.plusMinutes(trasa.getCzasLotu());
        LocalDateTime pom1;
        LocalDateTime pom2;
        {
            for (Samolot samolot : samoloty) {
                if (czestotliwosc == 1) {
                    if (samolot.getZasieg() >= trasa.getOdleglosc()) {
                        Lot lot1 = new Lot(samolot, trasa, dataOdlotu, dataPrzylotu);
                        loty.add(lot1);
                        pom1=dataOdlotu.plusDays(14);
                        pom2=dataPrzylotu.plusDays(14);
                        Lot lot2 = new Lot(samolot, trasa, pom1, pom2);
                        loty.add(lot2);
                        break;

                    }
                }
                if (czestotliwosc == 2) {
                    if (samolot.getZasieg() >= trasa.getOdleglosc()) {

                        Lot lot1 = new Lot(samolot, trasa, dataOdlotu, dataPrzylotu);
                        loty.add(lot1);
                        pom1=dataOdlotu.plusDays(7);
                        pom2=dataPrzylotu.plusDays(7);
                        Lot lot2 = new Lot(samolot, trasa, pom1, pom2);
                        loty.add(lot2);
                        pom1=dataOdlotu.plusDays(14);
                        pom2=dataPrzylotu.plusDays(14);
                        Lot lot3 = new Lot(samolot, trasa, pom1, pom2);
                        loty.add(lot3);
                        pom1=dataOdlotu.plusDays(21);
                        pom2=dataPrzylotu.plusDays(21);
                        Lot lot4 = new Lot(samolot, trasa, pom1, pom2);
                        loty.add(lot4);
                        break;
                    }
                }

            }
        }
    }
}
