package calculator.model;

import calculator.parser.DelimiterParser;
import calculator.parser.NumberParser;

public class Input {

    private Delimiter delimiter;
    private Numbers numbers;

    public Input(String input) {
        int firstDigitIndex = findFirstDigitIndex(input);

        this.delimiter = DelimiterParser.parse(input.substring(0, firstDigitIndex));
        String[] numberList = this.delimiter.splitByDelimiter(input.substring(firstDigitIndex));

        this.numbers = NumberParser.parse(numberList);
    }

    private int findFirstDigitIndex(String input) {
        int lastDelimiterIndex = input.lastIndexOf(Delimiter.END_CUSTOM_DELIMITER);

        if (lastDelimiterIndex == -1) {
            return 0;
        }

        return lastDelimiterIndex + Delimiter.END_CUSTOM_DELIMITER.length();
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
