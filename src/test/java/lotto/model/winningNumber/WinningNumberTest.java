package lotto.model.winningNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.common.Exceptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberTest {
    @Test
    @DisplayName("[success] 당첨번호 6개를 리스트에 저장한다.")
    void saveWinningNumberList() {
        List<Integer> testNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(testNumbers);

        for (int number : testNumbers) {
            assertThat(winningNumber.getNumbers()).contains(number);
        }
    }

    @ParameterizedTest
    @DisplayName("[fail] 당첨번호가 6개가 아니면 예외가 발생한다.")
    @MethodSource("wrongWinnerNumberSizeProvider")
    void fail_IfWinnerNumberSizeNotSix(List<Integer> testNumbers) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new WinningNumber(testNumbers))
                .withMessage(Exceptions.WRONG_LOTTERY_NUMBER_SIZE.getMessage());
    }
    static Stream<List<Integer>> wrongWinnerNumberSizeProvider() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7)
        );
    }

    @ParameterizedTest
    @DisplayName("[fail] 당첨번호에 1 이상 45 이하가 아닌 숫자가 있으면 예외가 발생한다.")
    @ValueSource(ints = {-1, 0, 46})
    void fail_IfNotInRangeWinnerNumberExists(int wrongNumber) {
        List<Integer> numbersIncludingInvalidRange = new ArrayList<>(Arrays.asList(wrongNumber, 1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new WinningNumber(numbersIncludingInvalidRange))
                .withMessage(Exceptions.OUT_OF_LOTTERY_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("[fail] 당첨번호 중 중복되는 번호가 있으면 예외가 발생한다.")
    void fail_IfDuplicatedWinningNumberExists() {
        List<Integer> numbersIncludingDuplication = new ArrayList<>(Arrays.asList(5, 1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new WinningNumber(numbersIncludingDuplication))
                .withMessage(Exceptions.DUPLICATED_LOTTERY_NUMBER.getMessage());
    }

    @Test
    @DisplayName("[fail] getter로 받은 당첨번호 리스트를 수정하는 경우 예외가 발생한다.")
    void fail_IfModifyWinningNumberList() {
        WinningNumber winningNumber = new WinningNumber(
                new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumberList = winningNumber.getNumbers();

        assertThatThrownBy(() -> winningNumberList.add(7))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> winningNumberList.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
