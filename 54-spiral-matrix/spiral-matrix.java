import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return ans;

        int minr = 0;
        int minc = 0;
        int maxr = matrix.length - 1;
        int maxc = matrix[0].length - 1;

        int te = matrix.length * matrix[0].length; // total elements
        int c = 0;

        while (c < te) {

            // left → right
            for (int i = minc; i <= maxc && c < te; i++) {
                ans.add(matrix[minr][i]);
                c++;
            }
            minr++;

            // top → bottom
            for (int i = minr; i <= maxr && c < te; i++) {
                ans.add(matrix[i][maxc]);
                c++;
            }
            maxc--;

            // right → left
            for (int i = maxc; i >= minc && c < te; i--) {
                ans.add(matrix[maxr][i]);
                c++;
            }
            maxr--;

            // bottom → top
            for (int i = maxr; i >= minr && c < te; i--) {
                ans.add(matrix[i][minc]);
                c++;
            }
            minc++;
        }

        return ans;
    }
}
