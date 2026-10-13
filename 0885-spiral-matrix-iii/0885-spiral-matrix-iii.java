
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int[][] result = new int[rows * cols][2];

        int[][] directions = {
            {0, 1},   // East
            {1, 0},   // South
            {0, -1},  // West
            {-1, 0}   // North
        };

        int count = 0;
        int r = rStart;
        int c = cStart;

        result[count++] = new int[]{r, c};

        int steps = 1;
        int direction = 0;

        while (count < rows * cols) {

            for (int repeat = 0; repeat < 2; repeat++) {

                int dr = directions[direction][0];
                int dc = directions[direction][1];

                for (int i = 0; i < steps; i++) {
                    r += dr;
                    c += dc;

                    if (r >= 0 && r < rows &&
                        c >= 0 && c < cols) {

                        result[count++] = new int[]{r, c};

                        if (count == rows * cols) {
                            return result;
                        }
                    }
                }

                direction = (direction + 1) % 4;
            }

            steps++;
        }

        return result;
    }
}
