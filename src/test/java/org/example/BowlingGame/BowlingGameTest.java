package org.example.BowlingGame;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {

    @Test
    void scoreMustBeEqualToZero() {
        BowlingGame bowlingGame = new BowlingGame();

        List<Integer> lancers = List.of(
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        );

        for (int pins : lancers) {
            bowlingGame.roll(pins);
        }

        assertEquals(0, bowlingGame.score());
    }

    @Test
    void scoreOnePinPerThrow() {
        BowlingGame bowlingGame = new BowlingGame();

        List<Integer> lancers = List.of(
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        );

        for (int pins : lancers) {
            bowlingGame.roll(pins);
        }

        assertEquals(20, bowlingGame.score());
    }

    @Test
    void scoreMustBeEqualTo16AfterSpare() {
        BowlingGame bowlingGame = new BowlingGame();

        List<Integer> lancers = List.of(
                5, 5, 3, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0
        );

        for (int pins : lancers) {
            bowlingGame.roll(pins);
        }

        assertEquals(16, bowlingGame.score());
    }

    @Test
    void scoreMustBeEqualTo9() {
        BowlingGame bowlingGame = new BowlingGame();

        List<Integer> lancers = List.of(
                2, 3, 4, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0
        );

        for (int pins : lancers) {
            bowlingGame.roll(pins);
        }

        assertEquals(9, bowlingGame.score());
    }

    @Test
    void scoreStrikeEqualsTo24() {
        BowlingGame bowlingGame = new BowlingGame();

        List<Integer> lancers = List.of(
                10, 3, 4,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0
        );

        for (int pins : lancers) {
            bowlingGame.roll(pins);
        }

        assertEquals(24, bowlingGame.score());
    }

    @Test
    void twoConsecutiveStrikesScore47() {
        BowlingGame bowlingGame = new BowlingGame();

        List<Integer> lancers = List.of(
                10, 10, 3, 4,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0
        );

        for (int pins : lancers) {
            bowlingGame.roll(pins);
        }

        assertEquals(47, bowlingGame.score());
    }

    @Test
    void callingScoreTwiceReturnsTheSameResult() {
        BowlingGame bowlingGame = new BowlingGame();

        List<Integer> lancers = List.of(
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        );

        for (int pins : lancers) {
            bowlingGame.roll(pins);
        }

        assertEquals(20, bowlingGame.score());
        assertEquals(20, bowlingGame.score());
    }
}