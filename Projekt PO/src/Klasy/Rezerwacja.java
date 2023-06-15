package Klasy;
import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * klasa w ktorej tworzony jest obiekt rezerwacji
 */
public class Rezerwacja implements Serializable {
    private Klient klient;
    private Trasa trasa;
    private LocalDateTime dataWylotu;
    private Samolot samolot;
    /**
     * Konstruktor z czterema parametrami. Trzy z nich to obiekty klas klient, trasa i samolot (ktore sa w kompozycji z klasa rezerwacja) oraz zmienna czas wylotu typu LocalDateTime.
     * @param klient
     * @param trasa
     * @param dataWylotu
     * @param samolot
     */
    public Rezerwacja(Klient klient, Trasa trasa, LocalDateTime dataWylotu, Samolot samolot)
    {
        this.dataWylotu = dataWylotu;
        this.klient = klient;
        this.samolot = samolot;
        this.trasa = trasa;
    }
    /**
     * Metoda pobierajaca klienta.
     * @return
     */
    public Klient getKlient()
    {
        return klient;
    }


    /**
     * Metoda pobierajaca samolot.
     * @return
     */
    public Samolot getSamolot()
    {
        return samolot;
    }

    /**
     * Metoda nadpisujaca ktora wyswietla dane rezerwacji - klient na ktorego zostala zlozona rezerwacja, data wylotu i samolot.
     * @return
     */
    @Override
    public String toString() {
        return "Rezerwacja{" + "klient = " + klient + ", trasa = " + trasa + ", data wylotu = " + dataWylotu + ", samolot = " + samolot + '}' + "\n";
    }
}
