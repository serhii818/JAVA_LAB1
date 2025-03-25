package KinoPack;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class Seans implements Serializable {
    public enum OgraniczenieWiekowe {
        G,
        PG,
        PG_13,
        R,
        NC_17
    }

    private final String tytul;
    private final String data;
    private final String godzina;
    private final OgraniczenieWiekowe ograniczenieWiekowe;
    private final HashMap<Character, HashMap<Integer, Boolean>> liczbaMiejsc;


    public Seans(String tytul, String data, String godzina, OgraniczenieWiekowe ograniczenieWiekowe) {
        this.tytul = tytul;
        this.data = data;
        this.godzina = godzina;
        this.ograniczenieWiekowe = ograniczenieWiekowe;
        liczbaMiejsc = new HashMap<>();
        for (int c = 65; c < 91; c++) {
            liczbaMiejsc.put((char) c, new HashMap<>());
        }
    }

    public boolean czyJestZajete(Character rzad, Integer kolumna) {
        return liczbaMiejsc.get(rzad).get(kolumna);
    }

    public boolean czyJestZajete(Miejsce m) {
        return liczbaMiejsc.get(m.rzad).get(m.kolumna);
    }

    public void ustawRezerwacje(Miejsce m, boolean rezerwacja) {
        liczbaMiejsc.get(m.rzad).put(m.kolumna, rezerwacja);
    }

    public String getTytul() {
        return tytul;
    }

    public String getData() {
        return data;
    }

    public String getGodzina() {
        return godzina;
    }

    public OgraniczenieWiekowe getOgraniczenieWiekowe() {
        return ograniczenieWiekowe;
    }

    @Override
    public String toString() {
        return tytul + ",   " + data + " " + godzina + ", (" + ograniczenieWiekowe + ")";
    }
}
