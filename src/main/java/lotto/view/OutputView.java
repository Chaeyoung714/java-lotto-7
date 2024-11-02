package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningRank;
import lotto.model.WinningResults;

public class OutputView {
    public void outputExceptionMessage(String message) {
        System.out.println(message);
    }

    public void outputIssuedLottos(Lottos lottos) {
        outputLottoAmount(lottos);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(Messages.ISSUED_LOTTO(lotto));
        }
    }

    private void outputLottoAmount(Lottos lottos) {
        System.out.println(System.lineSeparator() +
                String.format("%d개를 구매했습니다.", lottos.getLottos().size()));
    }

    public void outputWinningResultStartLine() {
        System.out.println(System.lineSeparator() + "당첨 통계");
        System.out.println(System.lineSeparator() + "---");
    }

    public void outputWinningRanks(WinningResults winningResults) {
        List<WinningRank> descendingWinningRanks = Utils.sortDescending(WinningRank.findRanksExceptFail());
        for (WinningRank winningRank : descendingWinningRanks) {
            System.out.println(String.format(
                    "%s (%s원) - %d개"
                    , Messages.MATCHING_CONDITION(winningRank)
                    , winningRank.getMatchingAmount()
                    , Messages.PRICE(winningRank.getPrice())
                    , winningResults.findLottoAmountByRank(winningRank)
            ));
        }
    }
}
