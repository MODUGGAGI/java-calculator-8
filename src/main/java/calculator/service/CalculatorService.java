package calculator.service;

import calculator.model.Numbers;
import java.util.List;

public class CalculatorService {

    public Number calculate(Numbers numbers) {
        List<Number> numberList = numbers.getNumberList();

        if (numberList == null || numberList.isEmpty()) {
            return 0;
        }

        if (numberList.size() == 1) {
            return numberList.getFirst();
        }

        double sum = 0;
        for (Number number : numberList) {
            sum += number.doubleValue();
        }

        if (sum % 1 == 0) {
            return (long) sum;
        }

        return sum;
    }
}
