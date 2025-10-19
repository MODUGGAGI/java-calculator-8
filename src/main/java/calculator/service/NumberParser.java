package calculator.service;

import calculator.model.Numbers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberParser {

    public static Numbers parse(String rawNumberList, String delimiterList) {
        if (rawNumberList == null || rawNumberList.isEmpty()) {
            return new Numbers(new ArrayList<>());
        }

        String[] splitNumbers = rawNumberList.split(delimiterList);

        List<Number> parsedNumbers = Arrays.stream(splitNumbers)
                .map(NumberParser::parseSingleNumber)
                .toList();

        return new Numbers(parsedNumbers);
    }

    private static Number parseSingleNumber(String rawNumber) {
        try {
            Number number = toNumber(rawNumber);
            validateNumber(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static Number toNumber(String rawNumber) {

        if (rawNumber.contains(".")) {
            return Double.parseDouble(rawNumber);
        }

        return Long.parseLong(rawNumber);
    }

    private static void validateNumber(Number number) {
        if (0 >= number.doubleValue()) {
            throw new IllegalArgumentException();
        }
    }
}
