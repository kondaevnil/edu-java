package edu.hw1;

public class Task4 {
    public static String fixString(String s) {
        var result = new StringBuilder();

        for (var i = 0; i < s.length() - 1; i += 2) {
            result.append(s.charAt(i + 1));
            result.append(s.charAt(i));
        }

        if (s.length() % 2 == 1)
            result.append(s.charAt(s.length() - 1));

        return result.toString();
    }
}
