package edu.hw1;

public class Task3 {
    private static int findMax(int[] array) {
        var max = Integer.MIN_VALUE;

        for (int j : array) {
            if (j > max)
                max = j;
        }

        return max;
    }

    private static int findMin(int[] array) {
        var min = Integer.MAX_VALUE;

        for (int j : array) {
            if (j < min)
                min = j;
        }

        return min;
    }

    public static boolean isNestable(int[] array1, int[] array2) {
        var min1 = findMin(array1);
        var max1 = findMax(array1);
        var min2 = findMin(array2);
        var max2 = findMax(array2);

        return min1 > min2 && max1 < max2;
    }
}
