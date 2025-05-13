package calculator.Controller;

import calculator.Model.StringCalculator;
import calculator.View.ConsoleView;

public class CalculatorController {
    private final StringCalculator calculator;
    private final ConsoleView view;

    public CalculatorController(StringCalculator calculator, ConsoleView view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void run() {
        String input = view.getInput();
        try {
            long result = calculator.add(input);
            view.printResult(result);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
        } finally {
            view.close();
        }
    }
}