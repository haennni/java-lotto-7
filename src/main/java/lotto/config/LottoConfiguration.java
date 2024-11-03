package lotto.config;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.input.InputHandler;
import lotto.input.InputParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoConfiguration {
    private int purchaseAmount;
    private int lottoCount;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    LottoConfiguration(InputHandler inputHandler, InputParser inputParser) {
        this.purchaseAmount = inputHandler.inputPurchaseAmount();
        this.lottoCount = calculateLottoCount(purchaseAmount);
        this.lottos = createLotto(lottoCount);
        String winningNumber = createWinningNumbers(inputHandler);
        this.winningNumbers = inputParser.splitWinningNumbers(winningNumber);
        this.bonusNumber = inputHandler.inputBonusNumber();
    }

    private int calculateLottoCount(int purchaseAmount){
        int lottoCount = purchaseAmount / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }
    private List<Lotto> createLotto(int lottoCount) {
        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            showLottoNumbers(lottoNumbers);
            generatedLottos.add(new Lotto(lottoNumbers));
        }
        return generatedLottos;
    }
    private void showLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }
    private String createWinningNumbers(InputHandler inputHandler) {
        return inputHandler.inputWinningNumbers();
    }
}
