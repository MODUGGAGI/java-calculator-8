package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputTest {

    @Test
    @DisplayName("커스텀 구분자가 입력되지 않은 경우")
    public void 기본_구분자() {
        //given
        Input input = new Input("1,2;3");

        //when
        Number result = input.getNumbers().calculateSum();

        //then
        assertThat(result).isEqualTo(6L);
    }

    @Test
    @DisplayName("커스텀 구분자가 1개 입력된 경우")
    public void 커스텀_구분자_1개() {
        //given
        Input input = new Input("//@\\n1@2;3");

        //when
        Number result = input.getNumbers().calculateSum();

        //then
        assertThat(result).isEqualTo(6L);
    }

    @Test
    @DisplayName("커스텀 구분자가 여러개 입력된 경우")
    public void 커스텀_구분자_여러개() {
        //given
        Input input = new Input("//@\\n//###\\n1@2###3;4");

        //when
        Number result = input.getNumbers().calculateSum();

        //then
        assertThat(result).isEqualTo(10L);
    }

    @Test
    @DisplayName("빈 문자열이 입력된 경우")
    public void 빈_문자열() {
        //given
        Input input = new Input("");

        //when
        Number result = input.getNumbers().calculateSum();

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("소수가 포함된 경우")
    public void 소수_포함() {
        //given
        Input input = new Input("1.5,2.3;3.2");

        //when
        Number result = input.getNumbers().calculateSum();

        //then
        assertThat(result).isEqualTo(7L);
    }
}