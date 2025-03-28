
import java.io.*;
import java.util.LinkedList;

import KinoPack.*;
import ONP.*;


public class Main {
    public static void testONP(String[] args) {
        // 7 1 + 4 2 - 2 ^ * =
        String tmp = "";
        if (args.length == 0) {
            tmp = "v(4^2%12)+4!=";
        } else {
            for (int i = 0; i < args.length; i++) {
                tmp += args[i];
            }
        }
        ONP onp = new ONP();
        System.out.print(tmp + " ");
        String rownanieOnp = onp.przeksztalcNaOnp(tmp);
        System.out.print("\t\t" + rownanieOnp);
        String wynik = onp.obliczOnp(rownanieOnp);
        System.out.println("\t\t" + " " + wynik);
    }

     public static void testKino() {
        Kino kino = new Kino();
        kino.zarejestrujKlienta("Serhii", "Zasiadivko", "serhii@zas.com", "+48800543321");
        kino.zarejestrujKlienta("Kamil", "Urban", "kamil@urban.com", "+48412541400");
        kino.zarejestrujKlienta("Konrad", "Kasza", "konrad@kasza.com", "+48999777320");

        kino.dodajSeans("Lord of the rings", "21 maja", "16:30", Seans.OgraniczenieWiekowe.PG);
        kino.dodajSeans("Attack on Titans", "18 czerwca", "9:00", Seans.OgraniczenieWiekowe.R);
        kino.dodajSeans("Matrix", "2 kwietnia", "23:00", Seans.OgraniczenieWiekowe.PG_13);

        LinkedList<Miejsce> m = new LinkedList<>();
        m.add(new Miejsce('D', 12));
        m.add(new Miejsce('D', 11));
        kino.kupBilet("Matrix", "kamil@urban.com", m);


        m.clear();
        m.add(new Miejsce('A', 2));
        m.add(new Miejsce('A', 1));
        kino.kupBilet("Attack on Titans", "serhii@zas.com", m);


        Kino kino2 = null;
        try {
            ObjectOutputStream wy = new ObjectOutputStream(new FileOutputStream(".\\kino.dat"));
            wy.writeObject(kino);
            wy.close();


            ObjectInputStream we = new ObjectInputStream(new FileInputStream(".\\kino.dat"));
            kino2 = (Kino) we.readObject();
            we.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(kino2);
        System.out.println();

        kino2.odluwajRezerwacjeKlienta("serhii@zas.com");
        kino2.usunSeans("Matrix");
        kino2.usunKlienta("konrad@kasza.com");

        System.out.println(kino2);
        System.out.println();

        try {
            String filename = "data.txt";
            FileWriter fout = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fout);
            out.write(kino2.toString());
            out.close();

            FileInputStream fin = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fin);
            BufferedReader r = new BufferedReader(new InputStreamReader(in));
            String strLine;
            String dane = "";
            while ((strLine = r.readLine()) != null)
                dane += strLine + "\n";
            in.close();
            System.out.println(dane);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void testSet() {
        Set<Integer> zbior1 = new Set<>(10);
        Set<Integer> zbior2 = new Set<>(10);

        zbior1.dodajElement(5);
        zbior1.dodajElement(3);
        zbior1.dodajElement(8);
        zbior1.dodajElement(1);

        zbior2.dodajElement(3);
        zbior2.dodajElement(7);
        zbior2.dodajElement(8);

        System.out.println("Zbiór 1: ");
        System.out.println(zbior1.toString());

        System.out.println("Zbiór 2: ");
        System.out.println(zbior2.toString());

        Set<Integer> przeciecie = zbior1.przeciecie(zbior2);
        System.out.println("Przecięcie zbiorów: ");
        System.out.println(przeciecie.toString());

        zbior1.dodajElementy(zbior2);
        System.out.println("Zbiór 1 z dodanymi elementami zbioru 2: ");
        System.out.println(zbior1.toString());

        zbior1.usunElement(5);
        System.out.println("Zbiór 1 z usunietym elementem o wartosci 5: ");
        System.out.println(zbior1.toString());

        zbior1.usunElement(5);
        System.out.println(zbior1.toString());
    }
    
    public static void main(String[] args) {
        testONP(args);
        testKino();
        testSet();
    }
}
