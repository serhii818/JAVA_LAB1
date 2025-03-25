package ONP;
import java.io.Serializable;


public class Main {

    public static void main(String[] args) {
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

}
