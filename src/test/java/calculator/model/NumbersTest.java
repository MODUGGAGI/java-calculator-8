package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;

class NumbersTest {

    @Test
    @DisplayName("아무 입력도 되지 않은 경우")
    void 빈_경우() {
        //given
        Numbers numbers = new Numbers(List.of());

        //when
        Number result = numbers.calculateSum();

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자가 1개만 들어온 경우")
    void 숫자_1개() {
        //given
        Numbers numbers = new Numbers(List.of(1));

        //when
        Number result = numbers.calculateSum();

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("정수끼리만 합하는 경우")
    void 정수_합() {
        //given
        Numbers numbers = new Numbers(List.of(1, 2, 3));

        //when
        Number result = numbers.calculateSum();

        //then
        assertThat(result).isEqualTo(6L);
    }

    @Test
    @DisplayName("소수끼리 합해서 소수가 나오는 경우 (부동 소수점 문제 O)")
    void 소수_합_1() {
        // given
        Numbers numbers = new Numbers(List.of(1.1, 2.1, 3.1));

        // when
        Number result = numbers.calculateSum();

        // then
        assertThat(result.doubleValue()).isNotEqualTo(6.3);
        assertThat(result.doubleValue()).isCloseTo(6.3, within(1e-9));
    }

    @Test
    @DisplayName("소수끼리 합해서 소수가 나오는 경우 (부동 소수점 문제 X)")
    void 소수_합_2() {
        // given
        Numbers numbers = new Numbers(List.of(1.1, 2.2, 3.1));

        // when
        Number result = numbers.calculateSum();

        // then
        assertThat(result).isEqualTo(6.4);

    }

    @Test
    @DisplayName("소수끼리 합해서 정수가 나오는 경우")
    void 소수_합_3() {
        // given
        Numbers numbers = new Numbers(List.of(1.5, 2.3, 3.2));

        // when
        Number result = numbers.calculateSum();

        // then
        assertThat(result).isEqualTo(7L);
    }

    @Test
    @DisplayName("정수와 소수가 섞여서 합하는 경우 (부동 소수점 문제 O)")
    void 정수_소수_합_1() {
        // given
        Numbers numbers = new Numbers(List.of(1, 2.2, 3.1));

        // when
        Number result = numbers.calculateSum();

        // then
        assertThat(result.doubleValue()).isNotEqualTo(6.3);
        assertThat(result.doubleValue()).isCloseTo(6.3, within(1e-9));
    }

    @Test
    @DisplayName("정수와 소수가 섞여서 합하는 경우 (부동 소수점 문제 X)")
    void 정수_소수_합_2() {
        // given
        Numbers numbers = new Numbers(List.of(1, 2.21, 3.2));

        // when
        Number result = numbers.calculateSum();

        // then
        assertThat(result).isEqualTo(6.41);
    }

}