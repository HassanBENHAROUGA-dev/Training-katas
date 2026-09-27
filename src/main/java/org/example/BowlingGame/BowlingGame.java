package org.example.BowlingGame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    List<Integer> rolls = new ArrayList<>();

    public int score() {
        int total = 0;
        int index = 0;

        for (int i = 0; i < 10; i++) {
            if (rolls.get(index) == 10) {
                total += 10 + rolls.get(index + 1) + rolls.get(index + 2);
                index++;
            } else if (rolls.get(index) + rolls.get(index + 1) == 10) {
                total += 10 + rolls.get(index + 2);
                index += 2;
            } else {
                total += rolls.get(index) + rolls.get(index + 1);
                index += 2;
            }
        }

        return total;
    }
    // nombre de quilles tombées à un lancer
    void roll(int pins){
        rolls.add(pins);
    }

    public static void main(String[] args) {

    }
}
