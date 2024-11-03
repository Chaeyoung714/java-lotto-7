package lotto.model.lotto;

import static lotto.Exceptions.NOT_DIVISIBLE_BY_LOTTO_PRICE;
import static lotto.model.lotto.LotteryRule.LOTTO_PRICE;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int calculateLottoAmount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_LOTTO_PRICE.getMessage());
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
