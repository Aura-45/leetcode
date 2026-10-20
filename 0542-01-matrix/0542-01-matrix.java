
import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] directions = {
            {-1, 0}, 
            {1, 0}, 
            {0, -1}, 
            {0, 1}   
        };
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    mat[nr][nc] == -1) {

                    mat[nr][nc] = mat[row][col] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return mat;
    }
}
