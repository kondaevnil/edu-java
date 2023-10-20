package edu.hw1;
import java.util.Arrays;

public class Task6 {
    private static void reverseArray(char[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            var tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        }
    }

    private static int findK(String s, int counter) {
        if (s.equals("6174"))
            return counter;

        var num1 = s.toCharArray();
        Arrays.sort(num1);
        reverseArray(num1);

        var num2 = s.toCharArray();
        Arrays.sort(num2);

        var newNumber = String.valueOf(Integer.parseInt(new String(num1)) - Integer.parseInt(new String(num2)));
        return findK(newNumber, counter + 1);
    }

    public static int countK(int n) {

        if (n > 9999 || n < 1001)
            return -1;

        return findK(Integer.toString(n), 0);
    }
}
