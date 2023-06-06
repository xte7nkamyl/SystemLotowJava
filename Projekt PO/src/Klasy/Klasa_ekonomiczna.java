package Klasy;
import java.io.Serializable;
/**
 * klasa w ktorej tworzony jest obiekt samolotu typu klasa ekonomiczna
 */
public class Klasa_ekonomiczna extends Samolot implements Serializable {

    /**
     * Konstruktor tworzacy konkretny obiekt samolotu. Zawiera odwolanie do pol klasy nadrzednej do ktorych zostaly przypisane konkretne wartosci.
     */
    public Klasa_ekonomiczna() {
        super(400,400);
    }

    /**
     * Metoda nadpisujaca ktora zwraca konretny typ samolotu.
     * @return
     */
    @Override
    public String toString() {
        return "Klasa_ekonomiczna " + super.toString();
    }
}
