package calculator.View;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public String getInput() {
        System.out.println("Enter a string to calculate: ");
        return scanner.nextLine();
    }

    public void printResult(long result) {
        System.out.println("Result: " + result);
    }

    public void printError(String message) {
        System.out.println("IllegalArgumentException: " + message);
    }

    public void close() {
        scanner.close();
    }
}