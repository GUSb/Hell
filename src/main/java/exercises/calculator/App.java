package exercises.calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type expression or q to exit");

        while (true) {

            String line = scanner.nextLine();

            if (line.equals("q")) {
                System.exit(0);
            }

            Thread thread = new Thread(new CalculatorRunnable(line));
            thread.start();
        }
    }
}
