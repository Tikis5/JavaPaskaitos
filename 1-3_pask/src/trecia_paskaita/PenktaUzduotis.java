package trecia_paskaita;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PenktaUzduotis {
    /*Antanas nusprendė nusipirkti naują automobilį ir jam svarbus rodiklis yra kuro sąnaudos.
        Padėkite Antanui ir realizuoti programą, kuri apskaičiuotų kiek automobilis vidutiniškai sunaudoja kuro 100 km.
        Programa turi paprašyti Antano įvesti nuvažiuotus km ir kuro sąnaudas. Formulė vidurkis = (kuro sąnaudos *100)/
        nuvažiuoto atstumo.Vidurkio skaičiavimas vykdomas kitame metode. Programa negali sustoti jei Antanas per klaidą
        įves tekstą, ji tu vėl prašyti pakartoti įvedimą. Programa baigia darbą kai vidurkis apskaičiuotas sėkmingai.
         */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PenktaUzduotis penktaUzduotis = new PenktaUzduotis();
        System.out.println("Ivesk nuvaziuota atstuma");
        double atstumas = penktaUzduotis.getValue(sc);
        System.out.println("Ivesk kuro sanaudas");
        double sanaudos = penktaUzduotis.getValue(sc);
        System.out.println("Vidurkis yra: " + penktaUzduotis.avarage(atstumas, sanaudos));

    }

    public double avarage(double nuvaziuotasKm, double kuroSanaudos) {
        return kuroSanaudos * 100 / nuvaziuotasKm;
    }

    public double getValue(Scanner sc) {
        Double value = null;
        while (value == null) {
            try {
                value = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Neteisinga reiksme, pakartok");
                sc.nextLine();
            }
        }
        return value;
    }
}
