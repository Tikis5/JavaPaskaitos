import java.util.Scanner;

public class TestProgram {
    public static void main(String[] args) {
        userInput();
    }

    public static void userInput() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Ivesk veiksma su operatoriais(+, -, * arba /). PVZ.: 2 + 2");

                String line = sc.nextLine();
                String[] elements = line.split(" ");
                double numb1 = Double.parseDouble(elements[0]);
                double numb2 = Double.parseDouble(elements[2]);
                String operator = elements[1];

                if (Double.parseDouble(elements[2]) != 0) {
                    TestProgram.calculator(numb1, numb2, operator);
                    break;
                }else {
                    System.out.println("Antras skaicius negali buti 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Neteisingas formatas");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Mazai elementu");
            }
        }
    }

    public static void calculator(double numb1, double numb2, String operator) {
        double addition;
        double subtraction;
        double multiplication;
        double division;

        switch (operator) {
            case "+":
                addition = numb1 + numb2;
                System.out.println("suma: " + addition);
                break;
            case "-":
                subtraction = numb1 + numb2;
                System.out.println("atimtis: " + subtraction);
                break;
            case "*":
                multiplication = numb1 * numb2;
                System.out.println("daugyba: " + multiplication);
                break;
            case "/":
                if (numb2 != 0) /*sitas ifas paliktas del visa ko, jei kazkokiu budu pavyktu vartotojui isprausti ji vis tiek*/ {
                    division = numb1 / numb2;
                    System.out.println("dalyba: " + division);
                } else System.out.println("Is 0 dalinti negalima");
                break;
            default:
                System.out.println("Netinkamas operatorius arba neteisingai ivestas veiksmas");
                userInput();
        }
    }
}

