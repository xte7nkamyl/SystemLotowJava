package Klasy;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Lot implements Serializable {

    private Samolot samolot;
    private Trasa trasa;
    private LocalDateTime czaswylotu;
    private LocalDateTime czasdolotu;
    private static int maxindex;
    private int index;

    public Lot(Samolot samolot,Trasa trasa, LocalDateTime czaswylotu,LocalDateTime czasdolotu){
        this.samolot=samolot;
        this.trasa=trasa;
        this.czaswylotu=czaswylotu;
        this.czasdolotu=czasdolotu;
    }
    public LocalDateTime getCzasWylotu(){return czaswylotu;}
    public Samolot getSamolot(){return samolot;}
    public Trasa getTrasa()
    {
        return trasa;
    }

    @Override
    public String toString() {
        return "Data :"+czaswylotu+"--"+czasdolotu+" samolot: "+samolot+" trasa "+trasa+"\n";
    }
}
