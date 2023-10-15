package edu.hw1;

public class Task5 {
    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }

        return true;
    }

    private static String getDescendant(String s) {
        var result = new StringBuilder();

        for (int i = 0; i < s.length() - 1; i += 2) {
            result.append((s.charAt(i) - '0') + (s.charAt(i + 1) - '0'));
        }

        if (s.length() % 2 == 1)
            result.append(s.charAt(s.length() - 1));

        return result.toString();
    }

    private static boolean palindromeRec(String s) {
        if (s.length() < 2)
            return false;

        if (isPalindrome(s))
            return true;

        return palindromeRec(getDescendant(s));
    }

    public static boolean isPalindromeDescendant(int num) {
        return num >= 0 && palindromeRec(Integer.toString(num));
    }
}
