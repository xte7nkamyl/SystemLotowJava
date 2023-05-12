package Klasy;

public class Lotnisko {
    private String nazwa;
    private String miasto;

    public Lotnisko(String nazwa, String miasto) {
        this.nazwa = nazwa;
        this.miasto = miasto;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getMiasto() {
        return miasto;
    }

    @Override
    public String toString(){
        return "Nazwa - " + nazwa + "\n Miasto - " + miasto;
    }

}
