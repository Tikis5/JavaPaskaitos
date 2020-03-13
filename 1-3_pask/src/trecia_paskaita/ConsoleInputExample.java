package trecia_paskaita;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite skaiciu: ");

        try {
            int result = sc.nextInt();
            System.out.println("Ivestas skaicius yra: " + result);
            if (result % 2 == 0) {
                System.out.println("Skaicius yra lyginis.");
            } else {
                System.out.println("Skaicius yra nelyginis.");
            }
        }catch (InputMismatchException e){
            System.out.println("Blogas formatas!");
        }
    }
}
