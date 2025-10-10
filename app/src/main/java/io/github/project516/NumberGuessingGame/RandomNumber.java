package io.github.project516.NumberGuessingGame;

import java.util.*;

public class RandomNumber {

    Random random = new Random();

    int number(int max) {

        return random.nextInt(max + 1);
    }
}
