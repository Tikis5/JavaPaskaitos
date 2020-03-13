package trecia_paskaita;

import java.io.IOException;
import java.util.Scanner;

public class UzduotisSesta {
    public static void main(String[] args) throws IOException {

        //Skaiciuotuvas skaiciuotuvas = new Skaiciuotuvas();
        //UzduotisSesta uzduotisSesta = new UzduotisSesta();

        Scanner sc = new Scanner(System.in);
        System.out.println("Ivesk veiksma. PVZ.: 10 + 10 ");

        String line = sc.nextLine();
        String[] elements = line.split(" ");
            try {

                double sk1 = Double.parseDouble(elements[0]);
                double sk2 = Double.parseDouble(elements[2]);
                String veiksmas = elements[1];
                UzduotisSesta.skaiciuotuvas(sk1, sk2, veiksmas);
            } catch (NumberFormatException e) {
                System.out.println("Neteisingas formatas");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Mazai elementu");
            }



    }

    public static void skaiciuotuvas(double sk1, double sk2, String veiksmas) {
        double suma = 0;
        double atimtis = 0;
        double daugyba = 0;
        double dalyba = 0;

            switch (veiksmas) {
                case "+":
                    suma = sk1 + sk2;
                    System.out.println("suma: " + suma);
                    break;
                case "-":
                    atimtis = sk1 + sk2;
                    System.out.println("atimtis: " + atimtis);
                    break;
                case "*":
                    daugyba = sk1 * sk2;
                    System.out.println("daugyba: " + daugyba);
                    break;
                case "/":
                    if (sk2 != 0) {
                        dalyba = sk1 / sk2;
                        System.out.println("dalyba: " + dalyba);
                    } else System.out.println("Is 0 dalinti negalima");
                    break;
                default:
                    System.out.println("Netinkamas veiksmas");
            }
    }
}
