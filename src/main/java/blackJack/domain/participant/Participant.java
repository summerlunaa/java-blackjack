package blackJack.domain.participant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import blackJack.domain.card.Card;
import blackJack.domain.card.Denomination;

public abstract class Participant {

    private static final String ERROR_MESSAGE_BLANK_NAME = "플레이어의 이름이 존재하지 않습니다.";
    private static final int BLACK_JACK = 21;
    private static final int OTHER_SCORE_OF_ACE_DENOMINATION = 1;

    private final String name;
    private final List<Card> cards;

    public Participant(String name) {
        validateName(name);
        this.name = name;
        this.cards = new ArrayList<>();
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BLANK_NAME);
        }
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        final int score = calculateScore();
        if (hasAceDenomination(score)) {
            return score - (Denomination.A.getScore() - OTHER_SCORE_OF_ACE_DENOMINATION);
        }
        return score;
    }

    private boolean hasAceDenomination(int score) {
        return score > BLACK_JACK &&
            cards.stream().anyMatch(card -> card.getDenomination() == Denomination.A);
    }

    private int calculateScore() {
        return cards.stream()
            .mapToInt(Card::getScore)
            .sum();
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Participant))
            return false;
        Participant that = (Participant)o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
