package calculator.service;

import calculator.model.Delimiter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DelimiterParserTest {

    @Test
    @DisplayName("커스텀 구분자가 입력되지 않은 경우")
    void 구분자_없는_경우() {
        //given
        Delimiter delimiter = DelimiterParser.parse("");

        //when
        //then
        assertThat(delimiter.getDelimiterList()).isEqualTo(",|;");
    }

    @Test
    @DisplayName("커스텀 구분자가 1개 입력된 경우")
    void 구분자_1개() {
        //given
        Delimiter delimiterList = DelimiterParser.parse("//@\\n");

        //when
        //then
        assertThat(delimiterList.getDelimiterList()).isEqualTo(",|;|\\Q@\\E");
    }

    @Test
    @DisplayName("커스텀 구분자가 여러글자로 입력된 경우")
    void 구분자_1개_여러글자() {
        //given
        Delimiter delimiterList = DelimiterParser.parse("//@#$\\n");

        //when
        //then
        assertThat(delimiterList.getDelimiterList()).isEqualTo(",|;|\\Q@#$\\E");
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자로 '.', 숫자, 빈 문자열 입력된 경우")
    @ValueSource(strings = {"//.\\n", "//1\\n", "//\\n"})
    void 잘못된_구분자_입력(String rawDelimiterList) {
        //given

        //when
        //then
        assertThatThrownBy(() -> DelimiterParser.parse(rawDelimiterList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자가 1개일 때 입력이 잘못된 경우")
    @ValueSource(strings = {"@\\n", "/@\\n", "//@", "//@\\", "//@n"})
    void 구분자_1개_입력_오류(String rawDelimiterList) {
        //given

        //when
        //then
        assertThatThrownBy(() -> DelimiterParser.parse(rawDelimiterList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("커스텀 구분자가 여러개 입력된 경우")
    void 구분자_여러개() {
        //given
        Delimiter delimiterList = DelimiterParser.parse("//@\\n//#\\n");

        //when
        //then
        assertThat(delimiterList.getDelimiterList()).isEqualTo(",|;|\\Q@\\E|\\Q#\\E");
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자가 여러개일 때 입력이 잘못된 경우")
    @ValueSource(strings = {"//@\\n/#\\n", "//@\\n#\\n", "//@\\n//#", "//@\\n//#\\", "//@\\n//#n"})
    void 구분자_여러개_입력_오류(String rawDelimiterList) {
        //given

        //when
        //then
        assertThatThrownBy(() -> DelimiterParser.parse(rawDelimiterList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}