package KinoPack;

import java.io.Serializable;
import java.util.LinkedList;

public class Klient implements Serializable {
    private String imie;
    private String nazwisko;
    private String telefon;
    private String mail;
    private Seans seans;
    private LinkedList<Miejsce> miejsca;


    public Klient(String imie, String nazwisko, String mail, String telefon) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.mail = mail;
        seans = null;
        miejsca = new LinkedList<>();
    }

    public void setSeans(Seans seans) {
        this.seans = seans;
    }

    public void dodajMiejsce(Miejsce miejsce) {
        this.miejsca.add(miejsce);
    }

    public void dodajMiejsce(Character rzad, Integer kolumna) {
        this.miejsca.add(new Miejsce(rzad, kolumna));
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getMail() {
        return mail;
    }

    public Seans getSeans() {
        return seans;
    }

    public LinkedList<Miejsce> getMiejsca() {
        return miejsca;
    }

    public void usunRezerwacje() {
        seans = null;
        miejsca.clear();
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + ",   " + mail + " " + telefon + ",   " +
                ((seans != null) ? seans.getTytul() : "NULL") + " " + ((miejsca != null) ? miejsca.toString() : "NULL");
    }
}
