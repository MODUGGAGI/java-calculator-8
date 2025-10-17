package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    private static final String START_MESSAGE = "덧셈할 문자열을 입력해주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    public String getInput() {
        System.out.println(START_MESSAGE);
        return Console.readLine();
    }

    public void printOutput(Number result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
