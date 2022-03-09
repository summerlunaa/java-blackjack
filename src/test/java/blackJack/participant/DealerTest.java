package blackJack.participant;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import blackJack.domain.Card;
import blackJack.domain.Denomination;
import blackJack.domain.Symbol;

public class DealerTest {

    @Test
    @DisplayName("Dealer 생성 테스트")
    void createValidDealer() {
        assertThat(new Dealer()).isNotNull();
    }

    @Test
    @DisplayName("Dealer 카드 합계 계산 테스트")
    void calculateScore() {
        Dealer dealer = new Dealer();
        dealer.receiveCard(new Card(Symbol.CLOVER, Denomination.EIGHT));
        assertThat(dealer.calculateScore()).isEqualTo(8);
    }
}
