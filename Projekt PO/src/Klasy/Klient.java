package Klasy;


import java.io.Serializable;

public class Klient implements Serializable {

    protected String imie;
    protected String nazwisko;
    protected int PESEL;
    protected static int maxindex;
    protected int index;



    public Klient(String imie, String nazwisko, int PESEL) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;

        if(!(maxindex>1000)){
            this.maxindex=1000;
        }
        this.index=maxindex;
        maxindex+=1;
    }

    public String getImie(String imie) {
        return imie;
    }

    public String getNazwisko(String nazwisko) {
        return nazwisko;
    }

    public int getPESEL(int PESEL) {
        return PESEL;
    }

    @Override
    public String toString() {
        return "Imię - " + imie.toString() + " Nazwisko - " + nazwisko.toString() + " PESEL - " + PESEL+"\n";
    }
}
