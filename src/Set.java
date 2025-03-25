

import java.util.Arrays;

class Set<T extends Comparable<T>>{

    private T[] set ;
    private int pojemnosc;
    private int rozmiar;

    @SuppressWarnings("unchecked")
    public Set(int pojemnosc){
        this.pojemnosc = pojemnosc;
        set = (T[]) new Comparable[pojemnosc];
        rozmiar = 0;
    }

    public int szukaj(T element) {
        return Arrays.binarySearch(set, 0, rozmiar, element);
    }

    public void dodajElement(T element) {
        if(rozmiar == pojemnosc) {
            throw new IllegalStateException("Zbior jest pelny");
        }

        if(szukaj(element) > -1) {
            return;
        }

        set[rozmiar] = element;
        rozmiar++;

        Arrays.sort(set, 0, rozmiar);
    }

    @Override
    public String toString() {
        String tab = "Zbior= ";
        for (int i = 0; i < rozmiar; i++) {
            tab += set[i];
            tab += " ";
        }
        return tab + "Rozmiar: " + rozmiar + " Pojemnosc: " + pojemnosc;
    }

    public void usunElement(T element) {
        if(szukaj(element) <= -1) {
            System.out.println("Element nie istnieje");
            return;
        }

        for(int i = szukaj(element); i < rozmiar - 1; i++) {
            set[i] = set[i+1];
        }

        set[rozmiar-1] = null;

        rozmiar--;
    }

    public Set<T> przeciecie(Set<T> zbior){
        Set<T> wynik = new Set<>(pojemnosc);

        for(int i = 0; i < rozmiar; i++) {
            if(zbior.szukaj(set[i]) > -1) {
                wynik.dodajElement(set[i]);
            }
        }

        return wynik;
    }

    public void odejmijElementy(Set<T> zbior) {
        for(int i = 0; i < zbior.rozmiar; i++) {
            if(rozmiar == 0) {
                return;
            }
            usunElement(zbior.set[i]);
        }
    }

    public void dodajElementy(Set<T> zbior) {
        for(int i = 0; i < zbior.rozmiar; i++) {
            dodajElement(zbior.set[i]);
        }
    }

}


