package lotto.model.winningNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import lotto.common.Exceptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberGeneratorTest {
    @Test
    @DisplayName("[success] 당첨번호를 split해 순서대로 저장하여 WinningNumber를 생성한다.")
    void splitAndcreateWinningNumber() {
        String testNumbers = "1,2,3,4,5,6";

        WinningNumber winningNumber = NumberGenerator.registerWinningNumber(testNumbers);
        List<Integer> winningNumberList = winningNumber.getNumbers();

        for (int i = 0; i < 6; i++) {
            int expectedWinningNumber = i + 1;
            assertThat(winningNumberList.get(i)).isEqualTo(expectedWinningNumber);
        }
    }

    @ParameterizedTest
    @DisplayName("[success] 당첨번호와 번호 사이의 띄어쓰기는 무시한다.")
    @ValueSource(strings = {" 45", "45 ", "    45", "45   "})
    void success_WhenBlankExistsBetweenNumberAndNumber(String numberWithBlank) {
        String testNumber = "1,2,3,4,5," + numberWithBlank;
        assertThatCode(() -> NumberGenerator.registerWinningNumber(testNumber))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("[fail] 하나의 번호 중간에 띄어쓰기 또는 숫자가 아닌 문자가 있으면 예외가 발생한다.")
    @ValueSource(strings = {"3 3", "33 3", "3   3", "3@3", "33@3", "3 @ 3"})
    void fail_IfNonIntegerExistsInsideNumber(String numberWithNonInteger) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> NumberGenerator.registerWinningNumber(numberWithNonInteger))
                .withMessage(Exceptions.NON_INTEGER_INCLUDED.getMessage());
    }
}
