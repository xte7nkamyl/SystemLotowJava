package Klasy;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

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
     * Metoda dodajaca lot do listy.
     * @param l
     */
    public void dodajLot(Lot l)
    {
        loty.add(l);
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

     /*public void dodajLot(Lot l) {
        loty.add(l);
    }
    public void usunLot(Lot l) {
        loty.remove(l);
    }*/

    /*public void generatorLotow(Klient klient, LocalDate dataOdlotu, LocalDate DataDolotu) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        for (Trasa trasa : trasy) {
            for (Samolot samolot : samoloty) {
                if (samolot.getZasieg() >= trasa.getOdleglosc()) {
                    LocalDateTime czasWylotu = LocalDateTime.of(dataOdlotu, LocalTime.of(random.nextInt(24), random.nextInt(60)));
                    LocalDateTime czasDolotu = czasWylotu.plusMinutes(trasa.getCzasLotu());
                    if (czasDolotu.isBefore(LocalDateTime.of(DataDolotu.plusDays(1), LocalTime.of(0, 0)))) {
                        Rezerwacja rezerwacja = new Rezerwacja(klient, trasa, czasWylotu, samolot);
                        System.out.println(rezerwacja);
                        while (true) {
                            System.out.println("Wybierz opcję:");
                            System.out.println("1. Dodaj rezerwacje");
                            System.out.println("2. Anuluj");
                            int x = random.nextInt();
                            switch (x)
                            {
                                case 1:
                                    rezerwacje.add(rezerwacja);
                                    break;
                                case 2:
                                    break;
                            }
                        }
                    }
                }
            }

        }

    }*/
/*
    public void generatorLotowDlaKlienta(Klient klient, Trasa trasa, LocalDate dataOdlotu, LocalDate DataDolotu) {

        Scanner scanner = new Scanner(System.in);
        for (Lot lot : loty) {
            if (lot.getCzasWylotu().equals(dataOdlotu)) {
                Rezerwacja rezerwacja = new Rezerwacja(klient, trasa, lot.getCzasWylotu(), lot.getSamolot());
                System.out.println(rezerwacja);
                while (true) {
                    System.out.println("Wybierz opcję:");
                    System.out.println("1. Dodaj rezerwacje");
                    System.out.println("2. Anuluj");
                    int x = scanner.nextInt();
                    switch (x) {
                        case 1:
                            rezerwacje.add(rezerwacja);
                            break;
                        case 2:
                            break;
                    }
                    if (x == 0) {
                        break;
                    }
                }
            }
        }
    }*/
    /*public void generatorLotowDlatrasy(Trasa trasa,LocalDateTime dataOdlotu,int czestotliwosc) {
        LocalDateTime dataPrzylotu = dataOdlotu.plusMinutes(trasa.getCzasLotu());
        {
            for (Samolot samolot : samoloty) {
                if (czestotliwosc <= 1) {
                    if (samolot.getZasieg() >= trasa.getOdleglosc()) {
                        Lot lot = new Lot(samolot, trasa, dataOdlotu, dataPrzylotu);
                        loty.add(lot);
                        break;
                    }
                }
                if (czestotliwosc <= 2) {
                    if (samolot.getZasieg() >= trasa.getOdleglosc()) {
                        dataOdlotu.plusDays(7);
                        dataPrzylotu.plusDays(7);
                        Lot lot = new Lot(samolot, trasa, dataOdlotu, dataPrzylotu);
                        loty.add(lot);
                        break;
                    }
                }

            }//tutaj to jest to samo co ponizej tylko doszedlem do wniosku ze ten zakres czasu nie jest potrzebny
    }
    }
    */

    public void generatorLotowDlatrasy(Trasa trasa,LocalDateTime dataOdlotu,int czestotliwosc) {
        LocalDateTime dataPrzylotu = dataOdlotu.plusMinutes(trasa.getCzasLotu());
        {
            for (Samolot samolot : samoloty) {
                if (czestotliwosc <= 1) {
                    if (samolot.getZasieg() >= trasa.getOdleglosc()) {
                        Lot lot1 = new Lot(samolot, trasa, dataOdlotu, dataPrzylotu);
                        loty.add(lot1);
                        dataOdlotu = dataOdlotu.plusDays(14);
                        dataPrzylotu = dataOdlotu.plusDays(14);
                        Lot lot2 = new Lot(samolot, trasa, dataOdlotu, dataPrzylotu);
                        loty.add(lot2);
                    }
                    if(czestotliwosc !=2){

                    }
                }
                if (czestotliwosc <= 2) {
                    if (samolot.getZasieg() >= trasa.getOdleglosc()) {

                        dataOdlotu.minusDays(7);
                        dataPrzylotu.minusDays(7);
                        Lot lot3 = new Lot(samolot, trasa, dataOdlotu, dataPrzylotu);
                        loty.add(lot3);
                        dataOdlotu.plusDays(14);
                        dataPrzylotu.plusDays(14);
                        Lot lot4 = new Lot(samolot, trasa, dataOdlotu, dataPrzylotu);
                        loty.add(lot4);
                        break;
                    }
                }

            }//tutaj to jest to samo co ponizej tylko doszedlem do wniosku ze ten zakres czasu nie jest potrzebny
        }
    }
/*public void generatorLotowDlatrasy(Trasa trasa,LocalDate dataOdlotu,LocalDate DataDolotu,int czestotliwosc) {
        Random random = new Random();
        LocalDateTime czasodlotu = LocalDateTime.of(dataOdlotu,LocalTime.of(random.nextInt(24),random.nextInt(60)));
        LocalDateTime czasprzylotu=czasodlotu.plusMinutes(trasa.getCzasLotu());

        for (Samolot samolot: samoloty){
            if(czestotliwosc<=1) {
                if (samolot.getZasieg() > trasa.getOdleglosc()) {
                    Lot lot = new Lot(samolot, trasa, czasodlotu, czasprzylotu);
                }
            }
            if(czestotliwosc<=2) {
                if (samolot.getZasieg() > trasa.getOdleglosc()) {
                    czasodlotu.plusDays(7);
                    czasprzylotu.plusDays(7);
                    Lot lot = new Lot(samolot, trasa, czasodlotu, czasprzylotu);
                }
            }
            if(czestotliwosc<=3) {
                if (samolot.getZasieg() > trasa.getOdleglosc()) {
                    czasodlotu.plusDays(7);
                    czasprzylotu.plusDays(7);
                    Lot lot = new Lot(samolot, trasa, czasodlotu, czasprzylotu);
                }
            }
            if(czestotliwosc<=4) {
                if (samolot.getZasieg() > trasa.getOdleglosc()) {
                    czasodlotu.plusDays(7);
                    czasprzylotu.plusDays(7);
                    Lot lot = new Lot(samolot, trasa, czasodlotu, czasprzylotu);
                }
            }
        }
    }*/

}
