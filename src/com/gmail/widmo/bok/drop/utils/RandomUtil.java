package com.gmail.widmo.bok.drop.utils;

import java.util.Random;

public class RandomUtil {

    public static Random random = new Random();

    public static Double getRandomDouble(double min, double max) throws IllegalArgumentException
    {
        return random.nextInt((int) (max - min + 1)) + min;
    }

    public static int getRandomInteger(int min, int max) throws  IllegalArgumentException
    {
        return random.nextInt(max-min+1)+min;
    }

    public static boolean getChance(double chance)
    {
        return chance >= 100.0 || chance >= getRandomDouble(0.0,100.0);
    }

}
