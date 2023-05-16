package Klasy;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class System_lotniczy {

    private List<Klient> klienci = new ArrayList();
    private List<Trasa> trasy = new ArrayList();
    private List<Lotnisko> lotniska = new ArrayList();
    private List<Samolot> samoloty = new ArrayList();
    private List<Rezerwacja> rezerwacje = new ArrayList();

    public void dodajKlient(Klient k) {
        klienci.add(k);
    }

    public void usunKlient(Klient k) {
        klienci.remove(k);
    }

    public List<Klient> getKlienci() {
        return klienci;
    }

    public void dodajTrasa(Trasa t) {
        trasy.add(t);
    }

    public void usunTrasa(Trasa t) {
        trasy.remove(t);
    }

    public List<Trasa> getTrasy() {
        return trasy;
    }

    public void dodajLotnisko(Lotnisko l) {
        lotniska.add(l);
    }

    public void usunLotnisko(Lotnisko l) {
        lotniska.remove(l);
    }

    public List<Lotnisko> getLotniska() {
        return lotniska;
    }

    public void dodajSamolot(Samolot s) {
        samoloty.add(s);
    }

    public void usunSamolot(Samolot s) {
        samoloty.remove(s);
    }

    public List<Samolot> getSamoloty() {
        return samoloty;
    }

    public void dodajRezerwacje(Rezerwacja r) {
        rezerwacje.add(r);
    }

    public void usunRezerwacje(Rezerwacja r) {
        rezerwacje.remove(r);
    }

    public List<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    public void generatorLotow(Klient klient, LocalDate dataOdlotu, LocalDate DataDolotu) {
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

    }
}
