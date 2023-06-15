package Klasy;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * klasa w ktorej tworzony jest obiekt lot
 */
public class Lot implements Serializable {

    private Samolot samolot;
    private Trasa trasa;
    private LocalDateTime czaswylotu;
    private LocalDateTime czasdolotu;

    /**
     * Konstruktor z czterema parametrami. Dwa z nich to obiekty klas samolot i trasa (ktore sa w kompozycji z klasa lot) oraz zmienne czas wylotu i czas dolotu typu LocalDateTime zaczerpniete z biblioteki.
     * @param samolot
     * @param trasa
     * @param czaswylotu
     * @param czasdolotu
     */
    public Lot(Samolot samolot,Trasa trasa, LocalDateTime czaswylotu,LocalDateTime czasdolotu){
        this.samolot=samolot;
        this.trasa=trasa;
        this.czaswylotu=czaswylotu;
        this.czasdolotu=czasdolotu;
    }

    /**
     * Metoda pobierajaca czas wylotu.
     * @return
     */
    public LocalDateTime getCzasWylotu(){return czaswylotu;}

    /**
     * Metoda pobierajaca czas dolotu.
     * @return
     */
    public Samolot getSamolot(){return samolot;}

    /**
     * Metoda pobierajaca trase.
     * @return
     */
    public Trasa getTrasa()
    {
        return trasa;
    }

    /**
     * Metoda nadpisujaca ktora wyswietla parametry lotu - czas wylotu i dolotu oraz trase.
     * @return
     */
    @Override
    public String toString() {
        return "Data :"+czaswylotu+"--"+czasdolotu+" samolot: "+samolot+" trasa "+trasa+"\n";
    }
}
