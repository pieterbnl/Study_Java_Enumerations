package com.pbe;

import java.util.Random;

// enumeration of possible answers
enum Answer {
    NO, YES, MAYBE, LATER, SOON, NEVER
}

// Constructor
public class Question {

    // Create an object of type Random
    Random rand = new Random();

    // Generate a random number and depending on the number return a certain enum constant
    Answer ask() {
        int prob = (int) (100 * rand.nextDouble());
        if (prob < 15)
            return Answer.MAYBE;
        else if (prob < 30)
            return Answer.NO;
        else if (prob < 60)
            return Answer.YES;
        else if (prob < 75)
            return Answer.LATER;
        else if (prob < 98)
            return Answer.YES;
        else
            return Answer.NEVER;
    }
}