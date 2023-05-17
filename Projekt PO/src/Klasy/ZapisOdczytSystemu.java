package Klasy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ZapisOdczytSystemu implements Serializable {

        public static void zapisz(System_lotniczy system_lotniczy, String nazwaPliku) {
            try {
                FileOutputStream fileOut = new FileOutputStream(nazwaPliku);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                List<Samolot> samoloty = new ArrayList<>(system_lotniczy.getSamoloty());
                List<Klient> klienci = new ArrayList<>(system_lotniczy.getKlienci());
                List<Lotnisko> lotniska = new ArrayList<>(system_lotniczy.getLotniska());
                out.writeObject(samoloty);
                out.writeObject(klienci);
                out.writeObject(lotniska);
                out.close();
                fileOut.close();
                System.out.println("Zapisano stan systemu do pliku: " + nazwaPliku);
            } catch (IOException e) {
                System.err.println("Błąd podczas zapisywania stanu systemu: " + e.getMessage());
            }
        }

        public static void odczytaj(System_lotniczy system_lotniczy, String nazwaPliku) {
            try {
                FileInputStream fileIn = new FileInputStream(nazwaPliku);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                List<Samolot> samoloty = (List<Samolot>) in.readObject();
                List<Klient> klienci = (List<Klient>) in.readObject();
                List<Lotnisko> lotniska = (List<Lotnisko>) in.readObject();
                system_lotniczy.setSamoloty(samoloty);
                system_lotniczy.setKlienci(klienci);
                system_lotniczy.setLotniska(lotniska);
                in.close();
                fileIn.close();
                System.out.println("Odczytano stan systemu z pliku: " + nazwaPliku);
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Błąd podczas odczytywania stanu systemu: " + e.getMessage());
            }
        }
    }


