package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.model.Lottos;
import lotto.model.WinningNumber;
import lotto.model.WinningRank;
import lotto.model.WinningResults;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMachineTest {
    private final LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 구매_개수만큼_로또를_발행한다() {
        String purchaseAmount = "2000";
        LottoAmount lottoAmount = new LottoAmount(purchaseAmount);

        Lottos lottos = lottoMachine.issueLottos(lottoAmount);

        assertThat(lottos.getLottos().size()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value =  {"FIRST:1", "SECOND:1", "THIRD:1", "FOURTH:1", "FIFTH:1", "FAIL:3"}
            , delimiter = ':')
    void 등수별로_로또_당첨을_확인한다(WinningRank winningRank, int expectedLottoAmount) {
        Lottos lottos = new Lottos(new ArrayList<>(Arrays.asList(
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))),
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 7))),
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 8))),
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 8, 9))),
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 8, 9, 10))),
                new Lotto(new ArrayList<>(List.of(1, 2, 8, 9, 10, 11))),
                new Lotto(new ArrayList<>(List.of(1, 8, 9, 10, 11, 12))),
                new Lotto(new ArrayList<>(List.of(8, 9, 10, 11, 12, 13)))
        )));
        WinningNumber winningNumber = new WinningNumber(new ArrayList<>(
                List.of(1, 2, 3, 4, 5, 6)
        ));
        BonusNumber bonusNumber = new BonusNumber(7);

        WinningResults winningResults = lottoMachine.checkLottoWinningResult(
                lottos, winningNumber, bonusNumber
        );

        assertThat(winningResults.findLottoAmountByRank(winningRank))
                .isEqualTo(expectedLottoAmount);
    }
}
