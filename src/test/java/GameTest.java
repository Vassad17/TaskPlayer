import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.ru.Game;
import ru.netology.ru.NotRegisteredException;
import ru.netology.ru.Player;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void shouldRegisterAndPlayGame() {
        Game game = new Game();
        Player player1 = new Player(1,"Faker",10);
        Player player2 = new Player(2,"Zanzarah",8);
        Player player3 = new Player(3,"DiamondProx",7);

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(player1, game.findByName("Faker"));
        Assertions.assertEquals(player2, game.findByName("Zanzarah"));
        Assertions.assertEquals(null, game.findByName("DiamondProx"));
    }

    @Test
    public void shouldThrowNotRegisteredExceptionWhenPlayer1IsNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1,"Faker",10);
        Player player2 = new Player(2,"Zanzarah",8);
        Player player3 = new Player(3,"DiamondProx",8);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Faker", "DiamondProx");
        });
    }

    @Test
    public void shouldThrowNotRegisteredExceptionWhenPlayer2IsNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1,"Faker",10);
        Player player2 = new Player(2,"Zanzarah",8);
        Player player3 = new Player(3,"DiamondProx",8);

        game.register(player1);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Zanzarah", "DiamondProx");
        });
    }
    @Test
    public void shouldThrowNotRegisteredExceptionWhenPlayerIsNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1,"Faker",10);
        Player player2 = new Player(2,"Zanzarah",8);
        Player player3 = new Player(3,"DiamondProx",8);



        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Zanzarah", "DiamondProx");
        });
    }


    @Test
    public void shouldReturnOneWhenPlayer1Wins() {
        Game game = new Game();
        Player player1 = new Player(1,"Faker",10);
        Player player2 = new Player(2,"Zanzarah",8);
        Player player3 = new Player(3,"DiamondProx",8);

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertEquals(-1, game.round("DiamondProx", "Faker"));
    }

    @Test
    public void shouldReturnTwoWhenPlayer2Wins() {
        Game game = new Game();
        Player player1 = new Player(1,"Faker",10);
        Player player2 = new Player(2,"Zanzarah",8);
        Player player3 = new Player(3,"DiamondProx",8);

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertEquals(1, game.round("Faker", "DiamondProx"));
    }

    @Test
    public void shouldReturnZeroWhenDraw() {
        Game game = new Game();
        Player player1 = new Player(1,"Faker",10);
        Player player2 = new Player(2,"Zanzarah",8);
        Player player3 = new Player(3,"DiamondProx",8);

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertEquals(0, game.round("Zanzarah", "DiamondProx"));
}


}
