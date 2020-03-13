package trecia_paskaita;

import java.util.Scanner;

public class IndividualiUzduotis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite varda: ");
        String vardas = sc.nextLine();
        System.out.println("Jusu vardas yra: " + vardas);
        System.out.println(vardas.length());
    }
}
