package Klasy;

import java.io.*;

public class ZapisOdczytSystemu implements Serializable{
    public void zapiszStanSystemu(System_lotniczy system, String nazwaPliku)
    {
        try{
            FileOutputStream fileOut = new FileOutputStream(nazwaPliku);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(system);
            out.close();
            fileOut.close();
            System.out.println("Zapisano stan systemu do pliku " + nazwaPliku);
        } catch (IOException e)
        {
            System.err.println("Blad podczas zapisywania stanu systemu " + e.getMessage());
        }
    }

    public System_lotniczy odczytSystemu(String nazwaPliku)
    {
        try
            {
                FileInputStream fileIn = new FileInputStream(nazwaPliku);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                System_lotniczy system = (System_lotniczy) in.readObject();
                in.close();
                fileIn.close();
                System.out.println("Odczytano stan systemu z pliky " + nazwaPliku);
            return system;
            } catch (IOException | ClassNotFoundException e)
        {
            System.err.println("Blad podczas pdczytywania stanu systemu " + e.getMessage());
            return null;
        }
    }
}

