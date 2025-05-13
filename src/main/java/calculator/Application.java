package calculator;

import calculator.Controller.CalculatorController;
import calculator.Model.StringCalculator;
import calculator.View.ConsoleView;


public class Application {
    public static void main(String[] args) {
        StringCalculator model = new StringCalculator();
        ConsoleView view = new ConsoleView();
        CalculatorController controller = new CalculatorController(model, view);

        controller.run();
    }
}
