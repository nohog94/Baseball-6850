import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    private static Game game;

    @BeforeAll
    static void beforeAll() {
        game = new Game();
    }

    @Test
    void createGame() {
        assertNotNull(game);
    }

    @Test
    void throwExceptionWhenInputisNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.guess(null);
        });
    }

    @Test
    void throwExceptionWhenInputLengthisUnmatched() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.guess("12");
        });
    }
}
