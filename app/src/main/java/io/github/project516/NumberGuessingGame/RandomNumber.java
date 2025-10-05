package io.github.project516.NumberGuessingGame;

import java.util.*;

public class RandomNumber {
    Random random = new Random();

    int number() {

        return random.nextInt(101);
    }
}
