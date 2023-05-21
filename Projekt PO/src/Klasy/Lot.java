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

    public Lot(Samolot samolot1,Trasa trasa1, LocalDateTime czaswylotu1,LocalDateTime czasdolotu1){
        this.samolot=samolot1;
        this.trasa=trasa1;
        this.czaswylotu=czaswylotu1;
        this.czasdolotu=czasdolotu1;

        if(!(maxindex>1000)){
            this.maxindex=1000;
        }
        this.index=maxindex;
        maxindex+=1;

    }
    public LocalDateTime getCzasWylotu(){return czaswylotu;}
    public Samolot getSamolot(){return samolot;}



}
