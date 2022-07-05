package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() { //++++++++++++++++++++
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    // другие ваши тесты
    @Test
    public void shouldSumGenreIfPlayTimeZero() { //++++++++++++++++++++
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Баттл", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 0);
        player.play(game2, 0);
        int expected = 0;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckOnPlayWithoutInstall() { //+++++++++++++++++
        GameStore store = new GameStore();
        Game game = store.publishGame("Баттл", "Аркады");

        Player player = new Player("Alex");

        assertThrows(RuntimeException.class, () -> player.play(game, 2));
    }

    @Test
    public void shouldCheckPlayToSumHoursSameGenreGames() { //+++++++++++++++++++++++
        GameStore store = new GameStore();
        Game game = store.publishGame("Баттл", "Аркады");
        Game game2 = store.publishGame("KKKK", "Аркады");

        Player player = new Player("Alex");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 1);
        player.play(game2, 3);

        int expected = 4;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckPlayOnExceptions() {  //+++++++++++++++++++++++
        GameStore store = new GameStore();
        Game game = store.publishGame("Баттл", "Аркады");
        Game game2 = store.publishGame("Бат", "Аркады");

        Player player = new Player("Alex");

        player.installGame(game);
        player.play(game, 3);

        assertThrows(RuntimeException.class, () -> player.play(game2, 5));
    }

    @Test
    public void shouldInstallGame() {  //  ++++++++++++++++++++++++++++++++++++
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);
        player.installGame(game);

        int expected = 3;
        int actual = player.sumGenre("Аркады");

        assertEquals(expected, actual);
    }

    @Test
    public void mostPlayerByGenre() { //++++++++++++++++++++++++++++++
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("KKKK", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 5);
        player.play(game2, 3);

        String expected = player.mostPlayerByGenre("Аркады");
        String actual = game.getTitle();

        assertEquals(expected, actual);
    }

    @Test
    public void mostPlayerByGenreWithMinesTimeAndDifGenre() { //++++++++++++++++++++++++++++++
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("KKKK", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, -4);

        String expected = player.mostPlayerByGenre("Гонки");
        String actual = null;

        assertEquals(expected, actual);
    }
}
