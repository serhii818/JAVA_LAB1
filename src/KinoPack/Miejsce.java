package KinoPack;

import java.io.Serializable;

public class Miejsce implements Serializable {
    public Character rzad;
    public Integer kolumna;

    public Miejsce(Character rzad, Integer kolumna) {
        this.rzad = rzad;
        this.kolumna = kolumna;
    }

    @Override
    public String toString() {
        return "" + rzad + kolumna;
    }
}
