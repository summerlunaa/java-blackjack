package blackJack.domain.participant;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final String ERROR_MESSAGE_DUPLICATE_PLAYER_NAME = "플레이어의 이름은 중복될 수 없습니다.";
    private static final String ERROR_MESSAGE_PLAYER_COUNT = "플레이어의 인원수는 1명 이상 7명 이하여야 합니다.";

    private static final int MINIMUM_COUNT = 1;
    private static final int MAXIMUM_COUNT = 7;

    private final Dealer dealer;
    private final List<Player> players;

    public Participants(List<String> playerNames) {
        this(new Dealer(), convertToPlayers(playerNames));
    }

    private Participants(Dealer dealer, List<Player> players) {
        validateDuplicatePlayerName(players);
        validatePlayerCount(players);
        this.dealer = dealer;
        this.players = players;
    }

    private static List<Player> convertToPlayers(List<String> playerNames) {
        return playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateDuplicatePlayerName(List<Player> players) {
        if (players.size() != new HashSet<>(players).size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_PLAYER_NAME);
        }
    }

    private void validatePlayerCount(List<Player> players) {
        if (players.size() < MINIMUM_COUNT || players.size() > MAXIMUM_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PLAYER_COUNT);
        }
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
