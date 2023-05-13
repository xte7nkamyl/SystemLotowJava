package Klasy;

public class Trasa {
    private int odleglosc;
    private Lotnisko poczatek;
    private Lotnisko koniec;
    private int czasLotu;

    public Trasa(int odleglosc, Lotnisko poczatek, Lotnisko koniec, int czasLotu) {
        this.odleglosc = odleglosc;
        this.poczatek = poczatek;
        this.koniec = koniec;
        this.czasLotu = czasLotu;
    }

    public int getCzasLotu() {
        return czasLotu;
    }

    public int setCzasLotu(int czasLotu) {
        if (czasLotu > 0)
            this.czasLotu = czasLotu;
        else
            this.czasLotu = 0;

        return this.czasLotu;
    }

    public int getOdleglosc() {
        return odleglosc;
    }

    public int setOdleglosc(int odleglosc) {
        if (odleglosc > 0)
            this.odleglosc = odleglosc;
        else
            this.odleglosc = 0;

        return this.odleglosc;

    }

    @Override
    public String toString() {
        return "Odległość - " + odleglosc + "\n Miejsce początkowe - " + poczatek + "\n Miejsce końcowe - " + koniec + "\n Czas lotu - " + czasLotu;
    }
}
