package edu.hw1;

public class Task3 {
    private static int find_max(int[] array) {
        var max = Integer.MIN_VALUE;

        for (int j : array) {
            if (j > max)
                max = j;
        }

        return max;
    }

    private static int find_min(int[] array) {
        var min = Integer.MAX_VALUE;

        for (int j : array) {
            if (j < min)
                min = j;
        }

        return min;
    }

    public static boolean isNestable(int[] array1, int[] array2) {
        var min1 = find_min(array1);
        var max1 = find_max(array1);
        var min2 = find_min(array2);
        var max2 = find_max(array2);

        return min1 > min2 && max1 < max2;
    }
}
