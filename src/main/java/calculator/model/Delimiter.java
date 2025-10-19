package calculator.model;

public class Delimiter {

    public static final String START_CUSTOM_DELIMITER = "//";
    public static final String END_CUSTOM_DELIMITER = "\\n";
    public static final String DEFAULT_DELIMITER_List = ",|;";

    private final String delimiterList;

    public Delimiter(String delimiterList) {
        this.delimiterList = delimiterList;
    }

    public String getDelimiterList() {
        return delimiterList;
    }
}
