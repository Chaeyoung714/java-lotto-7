package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputPurchaseAmount() {
        System.out.println(System.lineSeparator()
                + "구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        InputValidator.validateInputInteger(purchaseAmount);
        return purchaseAmount;
    }

    public String inputWinningNumber() {
        System.out.println(System.lineSeparator()
                + "당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine();
        InputValidator.validateGeneralValueInput(winningNumbersInput);
        return winningNumbersInput;
    }
}
