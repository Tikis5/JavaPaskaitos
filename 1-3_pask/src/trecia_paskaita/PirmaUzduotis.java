package trecia_paskaita;

import java.util.Scanner;

public class PirmaUzduotis {
    /**
     * Parašyti programą kuri paprašytų vartotojo įvesti žodį ir jį iš karto atvaizduotų,
     * tada vėl paprašytų įvesti kitą žodį, jį atvaizduotų, ir procesą kartotų tol, kol nebus įvestas žodis „pabaiga“.
     * Patikrinkite ar įvestas žodžio ilgis yra lyginis ar ne tam panaudokite % operatoriu.
     * Jei žodis yra lyginis atspausdinkite “Įvestas žodis  {įvestas_žodis} yra lyginis” ir šalia kokio ilgio yra žodis.
     * Jei nelyginis “Įvestas žodis {įvestas_žodis} nelyginis” šalia jo ilgį. Taip suskaičiuokite kiek tame žodyje yra “a” raidžių.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PirmaUzduotis pirmaUzduotis = new PirmaUzduotis();
        String result;
        do {
            System.out.println("Iveskite zodi, jei norite baigti iveskite pabaiga: ");
            result = sc.nextLine();
            pirmaUzduotis.printMethodEven(result);
            //todo patikrinti ar ne pabaiga
            System.out.println("skaicius raidziu a yra: " + getNumbOfLetters(result, 'a'));

        } while (!result.toLowerCase().equals("pabaiga"));
    }
    private void printMethodEven(String result){
        if (result.toLowerCase().equals("pabaiga")){
            return;
        }
        System.out.println("Ivestas zodis yra: " + result + ", jo ilgis yra " + result.length());
        if (result.length() % 2 == 0) {
            System.out.println("Įvestas žodis " + result + " yra lyginis");
        } else {
            System.out.println("Įvestas žodis " + result + " nelyginis");
        }
    }
    private static int getNumbOfLetters(String result, char letter){
        int count = 0;
        for (int i = 0; i < result.length(); i++){
            char l = result.charAt(i);
            if (l==letter){
                count++;
            }
        }
        return count;
    }
}
