package calculator.service;

import calculator.model.Delimiter;
import calculator.model.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberParserTest {

    @Test
    @DisplayName("이무 입력도 되지 않은 경우")
    public void 빈_문자열() {
        //given
        Numbers numbers = NumberParser.parse("", Delimiter.DEFAULT_DELIMITER_List);

        //when
        //then
        assertThat(numbers.getNumberList()).isEmpty();
    }

    @Test
    @DisplayName("양수가 1개 입력된 경우")
    public void 숫자_1개() {
        //given
        Numbers numbers = NumberParser.parse("1", Delimiter.DEFAULT_DELIMITER_List);

        //when
        //then
        assertThat(numbers.getNumberList()).containsExactly(1L);
    }

    @Test
    @DisplayName("양수가 여러개 입력된 경우")
    public void 숫자_여러개() {
        //given
        Numbers numbers = NumberParser.parse("1,6.3,2,3", Delimiter.DEFAULT_DELIMITER_List);

        //when
        //then
        assertThat(numbers.getNumberList()).containsExactly(1L, 6.3, 2L, 3L);
    }

    @Test
    @DisplayName("음수가 입력된 경우")
    public void 음수() {
        //given

        //when
        //then
        assertThatThrownBy(() -> NumberParser.parse("1,-1,2,3", Delimiter.DEFAULT_DELIMITER_List))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 다른 문자가 입력된 경우")
    public void Not_숫자() {
        //given

        //when
        //then
        assertThatThrownBy(() -> NumberParser.parse("1,T,2,3", Delimiter.DEFAULT_DELIMITER_List))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("등록되지 않은 구분자가 입력된 경우 경우")
    public void 미등록_구분자() {
        //given

        //when
        //then
        assertThatThrownBy(() -> NumberParser.parse("1$2,3", Delimiter.DEFAULT_DELIMITER_List))
                .isInstanceOf(IllegalArgumentException.class);
    }
}