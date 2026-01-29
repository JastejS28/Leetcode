class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        QueenProblem(board, n, 0);
        return ans;
    }

    public void QueenProblem(boolean[][] board, int tq, int row) {
        if (tq == 0) {
            ans.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (IsItSafe(board, row, col)) {
                board[row][col] = true;
                QueenProblem(board, tq - 1, row + 1);
                board[row][col] = false;
            }
        }
    }

    public boolean IsItSafe(boolean[][] board, int row, int col) {

        // up
        for (int r = row - 1; r >= 0; r--) {
            if (board[r][col]) return false;
        }

        // left diagonal
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c]) return false;
        }

        // right diagonal
        for (int r = row - 1, c = col + 1; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c]) return false;
        }

        return true;
    }

    private List<String> construct(boolean[][] board) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j] ? 'Q' : '.');
            }
            temp.add(sb.toString());
        }
        return temp;
    }
}
