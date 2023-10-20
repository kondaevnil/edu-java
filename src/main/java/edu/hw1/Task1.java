package edu.hw1;

import java.math.BigInteger;

public class Task1 {
    public static BigInteger minutesToSeconds(String time) {
        var parsedString = time.split(":");
        if (parsedString.length != 2)
            return new BigInteger("-1");

        try {
            var minutes = new BigInteger(parsedString[0]);
            var seconds = new BigInteger(parsedString[1]);
            if (new BigInteger("60").compareTo(seconds) <= 0 || BigInteger.ZERO.compareTo(seconds) > 0
                    || BigInteger.ZERO.compareTo(minutes) > 0)
                return new BigInteger("-1");

            return minutes.multiply(new BigInteger("60")).add(seconds);
        } catch (Exception e) {
            return new BigInteger("-1");
        }
    }
}
