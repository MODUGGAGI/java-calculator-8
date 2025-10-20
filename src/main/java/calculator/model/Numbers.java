package calculator.model;

import java.util.List;

public class Numbers {

    private final List<Number> numberList;

    public Numbers(List<Number> numberList) {
        this.numberList = numberList;
    }

    public List<Number> getNumberList() {
        return this.numberList;
    }

    public Number calculateSum() {
        if (this.numberList == null || this.numberList.isEmpty()) {
            return 0;
        }

        if (this.numberList.size() == 1) {
            return this.numberList.getFirst();
        }

        double sum = 0;
        for (Number number : this.numberList) {
            sum += number.doubleValue();
        }

        if (sum % 1 == 0) {
            return (long) sum;
        }

        return sum;
    }
}
