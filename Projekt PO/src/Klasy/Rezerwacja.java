package Klasy;

import java.time.LocalDate;

public class Rezerwacja {
    private Klient klient;
    private Trasa tarsa;
    private LocalDate dataWylotu;
    private Samolot samolot;

    public Rezerwacja(Klient klient, Trasa trasa, LocalDate dataWylotu, Samolot samolot)
    {
        this.dataWylotu = dataWylotu;
        this.klient = klient;
        this.samolot = samolot;
        this.trasa = trasa;
    }
    public Klient getKlient()
    {
        return klient;
    }
    public Trasa getTarsa() {
        return tarsa;
    }

    public LocalDate
}
