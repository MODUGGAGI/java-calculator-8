package calculator.model;

import java.util.List;

public class Numbers {

    private final List<Number> numberList;

    public Numbers(List<Number> numberList) {
        this.numberList = numberList;
    }

    public List<Number> getNumberList() {
        return numberList;
    }
}
