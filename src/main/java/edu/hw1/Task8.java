package edu.hw1;

public class Task8 {
    private static final int fieldSize = 8;
    private static void isFieldCorrect(int[][] array) throws IllegalArgumentException {
        if (array.length != fieldSize)
            throw new IllegalArgumentException();

        for (var row: array) {
            if (row.length != fieldSize)
                throw new IllegalArgumentException();

            for (var elem: row) {
                if (elem > 1 || elem < 0)
                    throw new IllegalArgumentException();
            }
        }
    }

    private static boolean checkKnightAttacksSomeone(int x, int y, int[][] array) {
        int[] dirX = { 2, 2, 1, -1, -2, -2, -1, 1 };
        int[] dirY = { -1, 1, 2, 2, 1, -1, -2, -2 };

        for (int i = 0; i < 8; i++) {
            var xPos = x + dirX[i];
            var yPos = y + dirY[i];

            if (0 <= xPos && xPos < fieldSize && 0 <= yPos && yPos < fieldSize && array[yPos][xPos] == 1) {
                return true;
            }
        }

        return false;
    }

    public static boolean knightBoardCapture(int[][] array) throws IllegalArgumentException {
        isFieldCorrect(array);

        for (var i = 0; i < fieldSize; i++) {
            for (var j = 0; j < fieldSize; j++) {
                if (array[i][j] == 1 && checkKnightAttacksSomeone(i, j, array))
                    return false;
            }
        }

        return true;
    }
}
