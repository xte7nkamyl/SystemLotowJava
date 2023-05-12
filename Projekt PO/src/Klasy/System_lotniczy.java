package Klasy;
import java.util.ArrayList;

public class System_lotniczy {

    private ArrayList<Klient> klienci = new ArrayList<>;
    private ArrayList<Trasa> trasy = new ArrayList<>;
    private ArrayList<Lotnisko> lotniska = new ArrayList<>;
    private ArrayList<Samolot> samoloty = new ArrayList<>;
    private ArrayList<Rezerwacja> rezerwacje = new ArrayList<>;

    public void dodajKlient(Klient k) {
        klienci.add();
    }

    public void usunKlient(Klient k) {
        klienci.remove();
    }

    public ArrayList<Klient> getKlienci() {
        return klienci;
    }

    public void dodajTrasa(Trasa t) {
        trasy.add();
    }

    public void usunTrasa(Trasa t) {
        trasy.remove();
    }

    public ArrayList<Trasa> getTrasy() {
        return trasy;
    }

    public void dodajLotnisko(Lotnisko l) {
        lotniska.add();
    }

    public void usunLotnisko(Lotnisko l) {
        lotniska.remove();
    }

    public ArrayList<Lotnisko> getLotniska() {
        return lotniska;
    }

    public void dodajSamolot(Samolot s) {
        samoloty.add();
    }

    public void usunSamolot(Lotnisko l) {
        samoloty.remove();
    }

    public ArrayList<Samolot> getSamoloty() {
        return samoloty;
    }

    public void dodajRezerwacje(Rezerwacja r) {
        rezerwacje.add();
    }

    public void usunRezerwacje(Rezerwacja r) {
        rezerwacje.remove();
    }

    public ArrayList<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

}
