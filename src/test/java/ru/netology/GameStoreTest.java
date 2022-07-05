package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.HashMap;
import java.util.Map;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    // другие ваши тесты

    @Test
    public void shouldReturnFalseAddGames() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = new Game("Дюна", "Стратегия", store);

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldReturnFalseContainsGame() {

        GameStore store = new GameStore();

        Game game2 = new Game("Дюна", "Стратегия", store);

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldGetMostPlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("Alex", 3);
        store.addPlayTime("Joker", 9);
        store.addPlayTime("Mike", 6);


        String actual = store.getMostPlayer();
        String expected = "Joker";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerEqualsZero() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Alex", 0);

        String actual = store.getMostPlayer();
        String expected = "Alex";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerReturnNull() {

        GameStore store = new GameStore();

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullGetMostPlayerNegativeValue() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Alex", -1);

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRegisteredAddPlayTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Alex", 0);
        store.addPlayTime("Alex", 2);


        String actual = store.getMostPlayer();
        String expected = "Alex";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerEquallyOne() {

        GameStore store = new GameStore();

        store.addPlayTime("Alex", 1);

        String actual = store.getMostPlayer();
        String expected = "Alex";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Alex", 1);
        store.addPlayTime("Joker", 4);
        store.addPlayTime("Mike", 2);

        int actual = store.getSumPlayedTime();
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroGetSumPlayedTime() {

        GameStore store = new GameStore();

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumZeroPlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Alex", 0);
        store.addPlayTime("Joker", 0);
        store.addPlayTime("Mike", 0);

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);

    }

    @Test
    public void shouldGetSumOnePlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Alex", 0);
        store.addPlayTime("Joker", 1);
        store.addPlayTime("Mike", 0);

        int actual = store.getSumPlayedTime();
        int expected = 1;
        assertEquals(expected, actual);

    }
}