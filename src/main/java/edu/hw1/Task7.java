package edu.hw1;

public class Task7 {
    private static int findFirstOne(int n) {
        int pos = 31;

        for (; pos != 0; pos--) {
            if ((n & (1 << pos)) != 0)
                break;
        }

        return pos;
    }

    static int rotateRight(int n, int shift) {
        var cycleSize = findFirstOne(n);

        for (var i = 0; i < shift; i++) {
            var rightBit = n & 1;
            n = (n >> 1) | (rightBit << cycleSize);
        }

        return n;
    }

    static int rotateLeft(int n, int shift) {
        var cycleSize = findFirstOne(n);

        for (var i = 0; i < shift; i++) {
            var rightBit = n & (1 << cycleSize);
            n = ((n << 1) | (rightBit >> cycleSize)) & ~(1 << cycleSize + 1);
        }

        return n;
    }
}
