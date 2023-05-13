package Klasy;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

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

    public GeneratorLotow(ArrayList<Trasa> trasy, ArrayList<Samolot> samoloty)
    {
        this.trasy = trasy;
    }
    public void generator(LocalDate dataOdlotu, LocalDate DataDolotu)
    {
List loty = new ArrayList<>();
        Random random = new Random();
for (Trasa trasa : trasy)
{
    for (Samolot samolot : samoloty)
    {
        if (samolot.getZasieg() >= trasa.getOdleglosc())
        {
            LocalDateTime czasWylotu = LocalDateTime.of(dataOdlotu, LocalTime.of(random.nextInt(24), random.nextInt(60) ));
            LocalDateTime czasDolotu = czasWylotu.plusMinutes(trasa.getCzasLotu());
        }
    }
}

    }

}
