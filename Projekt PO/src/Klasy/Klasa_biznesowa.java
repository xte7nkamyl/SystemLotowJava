package Klasy;
import java.io.Serializable;
/**
 * klasa w ktorej tworzony jest obiekt samolotu typu klasa biznesowa
 */
public class Klasa_biznesowa extends Samolot implements Serializable {

    /**
     * Konstruktor tworzacy konkretny obiekt samolotu. Zawiera odwolanie do pol klasy nadrzednej do ktorych zostaly przypisane konkretne wartosci.
     */
    public Klasa_biznesowa() {
        super(300, 500);
    }

    /**
     * Metoda nadpisujaca ktora zwraca konretny typ samolotu.
     * @return
     */
    @Override
    public String toString() {
        return "Klasa_Biznesowa " +  super.toString();
    }
}