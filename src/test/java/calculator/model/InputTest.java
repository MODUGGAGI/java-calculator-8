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
        //then
        assertThat(input.getNumbers().getNumberList()).containsExactly(1L, 2L, 3L);
    }

    @Test
    @DisplayName("커스텀 구분자가 1개 입력된 경우")
    public void 커스텀_구분자_1개() {
        //given
        Input input = new Input("//@\\n1@2;3");

        //when
        //then
        assertThat(input.getNumbers().getNumberList()).containsExactly(1L, 2L, 3L);
    }

    @Test
    @DisplayName("커스텀 구분자가 여러개 입력된 경우")
    public void 커스텀_구분자_여러개() {
        //given
        Input input = new Input("//@\\n//###\\n1@2###3;4");

        //when
        //then
        assertThat(input.getNumbers().getNumberList()).containsExactly(1L, 2L, 3L, 4L);
    }
}