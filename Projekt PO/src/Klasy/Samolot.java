package Klasy;

public class Samolot {
    private int iloscMiejsc;
    private int zasieg;

    public Samolot(int iloscMiejsc, int zasieg) {
        this.iloscMiejsc = iloscMiejsc;
        this.zasieg = zasieg;
    }

    public int getIloscMiejsc() {
        return iloscMiejsc;
    }

    public int setIloscMiejsc(int iloscMiejsc) {
        if (iloscMiejsc > 0)
            this.iloscMiejsc = iloscMiejsc;
        else
            this.iloscMiejsc = 0;

        return this.iloscMiejsc;

    }

    public int getZasieg() {
        return zasieg;
    }

    public int setZasieg(int zasieg) {
        if (zasieg > 0)
            this.zasieg = zasieg;
         else
            this.zasieg = 0;

        return this.zasieg;
    }

    @Override
    public String toString() {
        return "Ilość miejsc - " + iloscMiejsc + "\n Zasięg - " + zasieg;
    }
}
