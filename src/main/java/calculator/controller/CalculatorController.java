package calculator.controller;

import calculator.model.Input;
import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final CalculatorView calculatorView = new CalculatorView();
    private final CalculatorService calculatorService = new CalculatorService();

    public void startCalculator() {
        Input input = new Input(calculatorView.getInput());
        calculatorView.printOutput(calculatorService.calculate(input.getNumbers()));
    }
}
