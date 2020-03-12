package trecia_paskaita;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.jar.JarOutputStream;

public class TaskFileReadFromFile {
    public static void main(String[] args) {

        PenktaUzduotis penktaUzduotis = new PenktaUzduotis();

        try (BufferedReader bf = new BufferedReader(new FileReader("cars.txt"))) {
            String line;
            String carName = "";
            double bestCarAvg = 0;
            while ((line = bf.readLine()) != null) {
                String[] elements = line.split(" ");
                double average = penktaUzduotis.avarage(Double.parseDouble(elements[1]), Double.parseDouble(elements[2]));
                System.out.println(elements[0] + " " + average);
                if (bestCarAvg == 0 || bestCarAvg > average) {
                    bestCarAvg = average;
                    carName = elements[0];
                }
                /*System.out.println(elements[0]);
                System.out.println(elements[1]);
                System.out.println(elements[2]);
                System.out.println(line);*/
            }
            System.out.println("Optimaliausias automobilis " + carName +" " + bestCarAvg);
        } catch (IOException e) {
            System.out.println("Failo nuskaitymas nepavyko");
        }
    }
}
