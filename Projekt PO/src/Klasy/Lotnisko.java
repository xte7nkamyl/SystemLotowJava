package Klasy;
import java.io.Serializable;
/**
 * klasa w ktorej tworzony jest obiekt lotnisko
 */
public class Lotnisko implements Serializable {
    private String nazwa;
    private String miasto;

    /**
     * Konstruktor dwuparametrowy tworzacy obiekt lotnisko o danej nazwie i w danym miescie.
     * @param nazwa
     * @param miasto
     */
    public Lotnisko(String nazwa, String miasto) {
        this.nazwa = nazwa;
        this.miasto = miasto;
    }

    /**
     * Metoda nadpisujaca ktora wyswietla dane lotniska - nazwe oraz miasto w ktorym lezy.
     * @return
     */
    @Override
    public String toString(){
        return "Nazwa - " + nazwa + " Miasto - " + miasto+"\n";
    }

}
