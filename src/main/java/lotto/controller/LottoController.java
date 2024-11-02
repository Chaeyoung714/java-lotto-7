package lotto.controller;

import lotto.model.LottoAmount;
import lotto.model.Lottos;
import lotto.model.WinningNumber;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        LottoAmount lottoAmount = purchaseLottos();
        Lottos lottos = lottoMachine.issueLottos(lottoAmount);
        outputView.outputIssuedLottos(lottos);
        String winningNumberInput = inputView.inputWinningNumber();
    }

    private LottoAmount purchaseLottos() {
        try {
            String purchaseAmount = inputView.inputPurchaseAmount();
            return new LottoAmount(purchaseAmount);
        } catch (IllegalArgumentException e) {
            outputView.outputExceptionMessage(e.getMessage());
            return purchaseLottos();
        }
    }
}
