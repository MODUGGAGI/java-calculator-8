package calculator.controller;

import calculator.model.Input;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final CalculatorView calculatorView = new CalculatorView();

    public void startCalculator() {
        Input input = new Input(calculatorView.getInput());
        calculatorView.printOutput(input.getNumbers().calculateSum());
    }
}
