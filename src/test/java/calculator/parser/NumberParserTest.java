package calculator.parser;

import calculator.model.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberParserTest {

    @Test
    @DisplayName("이무 입력도 되지 않은 경우")
    void 입력_안된_경우() {
        //given
        String[] rawNumberList = new String[0];

        //when
        Numbers numbers = NumberParser.parse(rawNumberList);

        //then
        assertThat(numbers.getNumberList()).isEmpty();
    }

    @Test
    @DisplayName("양수가 1개 입력된 경우")
    void 숫자_1개() {
        //given
        String[] rawNumberList = new String[]{"1"};

        //when
        Numbers numbers = NumberParser.parse(rawNumberList);

        //then
        assertThat(numbers.getNumberList()).containsExactly(1L);
    }

    @Test
    @DisplayName("양수가 여러개 입력된 경우")
    void 숫자_여러개() {
        //given
        String[] rawNumberList = new String[]{"1", "6.3", "2", "3"};

        //when
        Numbers numbers = NumberParser.parse(rawNumberList);

        //then
        assertThat(numbers.getNumberList()).containsExactly(1L, 6.3, 2L, 3L);
    }

    @Test
    @DisplayName("음수가 입력된 경우")
    void 음수() {
        //given
        String[] rawNumberList = new String[]{"-1", "1", "2", "3"};

        //when
        //then
        assertThatThrownBy(() -> NumberParser.parse(rawNumberList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0이 입력된 경우")
    void zero() {
        //given
        String[] rawNumberList = new String[]{"0", "1", "2", "3"};

        //when
        //then
        assertThatThrownBy(() -> NumberParser.parse(rawNumberList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 다른 문자가 입력된 경우")
    void Not_숫자() {
        //given
        String[] rawNumberList = new String[]{"1", "T", "2", "3"};

        //when
        //then
        assertThatThrownBy(() -> NumberParser.parse(rawNumberList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈문자열이 입력된 경우 경우")
    void 빈_문자열() {
        //given
        String[] rawNumberList = new String[]{"1", "", "2"};

        //when
        //then
        assertThatThrownBy(() -> NumberParser.parse(rawNumberList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}