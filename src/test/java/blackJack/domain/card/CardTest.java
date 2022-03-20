package blackJack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    @DisplayName("특정 카드를 가져올 수 있는지 테스트")
    void getCard() {
        assertThat(Card.of(Symbol.SPADE, Denomination.KING)).isNotNull();
    }

    @Test
    @DisplayName("카드 숫자에 따라 점수가 반환되는지 테스트")
    void checkScoreByDenomination() {
        Card card = Card.of(Symbol.SPADE, Denomination.KING);
        assertThat(card.getPoint()).isEqualTo(10);
    }
}
