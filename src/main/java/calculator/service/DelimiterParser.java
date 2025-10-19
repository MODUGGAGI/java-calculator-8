package calculator.service;

import calculator.model.Delimiter;
import java.util.regex.Pattern;

public class DelimiterParser {

    public static Delimiter parse(String rawDelimiterList) {
        String delimiterList = Delimiter.DEFAULT_DELIMITER_List + parseCustomDelimiterList(rawDelimiterList);
        return new Delimiter(delimiterList);
    }

    private static String parseCustomDelimiterList(String rawDelimiterList) {
        if (rawDelimiterList == null || rawDelimiterList.isEmpty()) {
            return "";
        }

        if (!rawDelimiterList.startsWith(Delimiter.START_CUSTOM_DELIMITER)) {
            throw new IllegalArgumentException();
        }

        StringBuilder delimiterListBuilder = new StringBuilder();
        int currentIndex = 0;

        while (rawDelimiterList.startsWith(Delimiter.START_CUSTOM_DELIMITER, currentIndex)) {
            int startIndex = findStartIndex(currentIndex);
            int endIndex = findEndIndex(rawDelimiterList, startIndex);

            String delimiter = rawDelimiterList.substring(startIndex, endIndex);
            validateDelimiter(delimiter);

            delimiterListBuilder.append("|").append(Pattern.quote(delimiter));
            currentIndex = endIndex + Delimiter.END_CUSTOM_DELIMITER.length();
        }

        if (currentIndex != rawDelimiterList.length()) {
            throw new IllegalArgumentException();
        }

        return delimiterListBuilder.toString();
    }

    private static int findStartIndex(int currentIndex) {
        return currentIndex + Delimiter.START_CUSTOM_DELIMITER.length();
    }

    private static int findEndIndex(String remainingDelimiter, int startIndex) {
        int endIndex = remainingDelimiter.indexOf(Delimiter.END_CUSTOM_DELIMITER, startIndex);

        if (endIndex < 0) {
            throw new IllegalArgumentException();
        }

        return endIndex;
    }

    private static void validateDelimiter(String delimiter) {
        if (delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (delimiter.equals(".")) {
            throw new IllegalArgumentException();
        }
        if (delimiter.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }
}
