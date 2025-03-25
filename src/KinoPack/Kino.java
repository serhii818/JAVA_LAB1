package KinoPack;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;

public class Kino implements Serializable {
    static private final LinkedList<Klient> klienci = new LinkedList<>();
    static private final LinkedList<Seans> seansy = new LinkedList<>();

    public void zarejestrujKlienta(String imie, String nazwisko, String mail, String telefon) {
        Klient klient = new Klient(imie, nazwisko, mail, telefon);
        klienci.add(klient);
    }

    public void zarejestrujKlienta(Klient klient) {
        klienci.add(klient);
    }

    public void kupBilet(String tytulSeansu, String mailKlienta, LinkedList<Miejsce> miejsca) {
        Klient klient = null;
        for (Klient k : klienci) {

            if (mailKlienta.equals(k.getMail())) {
                klient = k;
                break;
            }
        }

        Seans seans = null;
        for (Seans s : seansy) {
            if (tytulSeansu.equals(s.getTytul())) {
                seans = s;
                break;
            }
        }

        if (klient != null && seans != null) {
            klient.setSeans(seans);
            for (Miejsce m : miejsca) {
                klient.dodajMiejsce(m);
                seans.ustawRezerwacje(m, true);
            }
        }
    }

    public void odluwajRezerwacjeKlienta(String mailKlienta) {
        Klient klient = null;
        for (Klient k : klienci) {

            if (mailKlienta.equals(k.getMail())) {
                klient = k;
                break;
            }
        }

        if (klient.getMiejsca() != null) {
            for (Miejsce m : klient.getMiejsca()) {
                klient.getSeans().ustawRezerwacje(m, false);
            }
        }
        klient.usunRezerwacje();
    }

    public void dodajSeans(Seans seans) {
        seansy.add(seans);
    }

    public void dodajSeans(String tytul, String data, String godzina, Seans.OgraniczenieWiekowe ograniczenieWiekowe) {
        Seans seans = new Seans(tytul, data, godzina, ograniczenieWiekowe);
        seansy.add(seans);
    }

    public boolean usunSeans(String tytulSeansu) {
        Seans seans = null;
        for (Seans s : seansy) {
            if (tytulSeansu.equals(s.getTytul())) {
                seans = s;
                break;
            }
        }

        for (Klient k : klienci) {
            if (k.getSeans() == seans) {
                k.usunRezerwacje();
            }
        }

        return seansy.remove(seans);
    }

    public boolean usunKlienta(String mailKlienta) {
        Klient klient = null;
        for (Klient k : klienci) {

            if (mailKlienta.equals(k.getMail())) {
                klient = k;
                break;
            }
        }
        odluwajRezerwacjeKlienta(mailKlienta);
        return klienci.remove(klient);
    }

    @Override
    public String toString() {
        String s = "Dane Kina :\n";
        s += "  Seansy:\n";
        for (Seans sea : seansy) {
            s += "      " + sea.toString() + "\n";
        }
        s += "  Klienci:\n";
        for (Klient k : klienci) {
            s += "      " + k.toString() + "\n";
        }
        return s;
    }
}
