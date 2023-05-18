package Klasy;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Rezerwacja {
    private Klient klient;
    private Trasa trasa;
    private LocalDateTime dataWylotu;
    private Samolot samolot;

    public Rezerwacja(Klient klient, Trasa trasa, LocalDateTime dataWylotu, Samolot samolot)
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
        return trasa;
    }

    public LocalDateTime getDataWylotu()
    {
        return dataWylotu;
    }

    public Samolot getSamolot()
    {
        return samolot;
    }

    @Override
    public String toString() {
        return "Rezerwacja{" +
                "klient = " + klient +
                ", trasa = " + trasa +
                ", data wylotu = " + dataWylotu +
                ", samolot = " + samolot +
                '}';
    }
}
