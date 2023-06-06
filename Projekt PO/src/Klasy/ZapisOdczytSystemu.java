package Klasy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * klasa w ktorej tworzony jest zapis i odczyt z pliku
 */
public class ZapisOdczytSystemu implements Serializable {


    /**
     * Metoda sluzaca do zapisu pliku.
     * @param system_lotniczy
     * @param nazwaPliku
     */
        public static void zapisz(System_lotniczy system_lotniczy, String nazwaPliku) {
            try {
                FileOutputStream fileOut = new FileOutputStream(nazwaPliku);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                List<Samolot> samoloty = new ArrayList<>(system_lotniczy.getSamoloty());
                List<Klient> klienci = new ArrayList<>(system_lotniczy.getKlienci());
                List<Lotnisko> lotniska = new ArrayList<>(system_lotniczy.getLotniska());
                List<Trasa> trasy = new ArrayList<>(system_lotniczy.getTrasy());
                List<Rezerwacja> rezerwacje = new ArrayList<>(system_lotniczy.getRezerwacje());
                List<Lot> loty = new ArrayList<>(system_lotniczy.getLoty());
                out.writeObject(samoloty);
                out.writeObject(klienci);
                out.writeObject(lotniska);
                out.writeObject(trasy);
                out.writeObject(rezerwacje);
                out.writeObject(loty);
                out.close();
                fileOut.close();
                System.out.println("Zapisano stan systemu do pliku: " + nazwaPliku);
            } catch (IOException e) {
                System.err.println("Błąd podczas zapisywania stanu systemu: " + e.getMessage());
            }
        }

    /**
     * Metoda sluzaca do odczytu pliku.
     * @param system_lotniczy
     * @param nazwaPliku
     */
    public static void odczytaj(System_lotniczy system_lotniczy, String nazwaPliku) {
            try {
                FileInputStream fileIn = new FileInputStream(nazwaPliku);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                List<Samolot> samoloty = (List<Samolot>) in.readObject();
                List<Klient> klienci = (List<Klient>) in.readObject();
                List<Lotnisko> lotniska = (List<Lotnisko>) in.readObject();
                List<Trasa> trasy = (List<Trasa>) in.readObject();
                List<Rezerwacja> rezerwacje = (List<Rezerwacja>) in.readObject();
                List<Lot> loty = (List<Lot>) in.readObject();
                system_lotniczy.setSamoloty(samoloty);
                system_lotniczy.setKlienci(klienci);
                system_lotniczy.setLotniska(lotniska);
                system_lotniczy.setTrasy(trasy);
                system_lotniczy.setRezerwacje(rezerwacje);
                system_lotniczy.setLoty(loty);
                in.close();
                fileIn.close();
                System.out.println("Odczytano stan systemu z pliku: " + nazwaPliku);
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Błąd podczas odczytywania stanu systemu: " + e.getMessage());
            }
        }
    }


