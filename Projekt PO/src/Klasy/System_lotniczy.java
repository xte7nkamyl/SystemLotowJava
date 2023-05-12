package Klasy;
import java.util.ArrayList;

public class System_lotniczy {

    private ArrayList<Klient> klienci = new ArrayList<>;
    private ArrayList<Trasa> trasy = new ArrayList<>;
    private ArrayList<Lotnisko> lotniska = new ArrayList<>;
    private ArrayList<Samolot> samoloty = new ArrayList<>;
    private ArrayList<Rezerwacja> rezerwacje = new ArrayList<>;

    public void dodajKlient(Klient k) {
        klienci.add(k);
    }

    public void usunKlient(Klient k) {
        klienci.remove(k);
    }

    public ArrayList<Klient> getKlienci() {
        return klienci;
    }

    public void dodajTrasa(Trasa t) {
        trasy.add(t);
    }

    public void usunTrasa(Trasa t) {
        trasy.remove(t);
    }

    public ArrayList<Trasa> getTrasy() {
        return trasy;
    }

    public void dodajLotnisko(Lotnisko l) {
        lotniska.add(l);
    }

    public void usunLotnisko(Lotnisko l) {
        lotniska.remove(l);
    }

    public ArrayList<Lotnisko> getLotniska() {
        return lotniska;
    }

    public void dodajSamolot(Samolot s) {
        samoloty.add(s);
    }

    public void usunSamolot(Samolot s) {
        samoloty.remove(s);
    }

    public ArrayList<Samolot> getSamoloty() {
        return samoloty;
    }

    public void dodajRezerwacje(Rezerwacja r) {
        rezerwacje.add(r);
    }

    public void usunRezerwacje(Rezerwacja r) {
        rezerwacje.remove(r);
    }

    public ArrayList<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

}
