class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            int oldRow = i / n;
            int oldCol = i % n;
            int newRow = i / c;
            int newCol = i % c;

            result[newRow][newCol] = mat[oldRow][oldCol];
        }

        return result;
    }
}