class Solution {

    public void solveSudoku(char[][] board) {
        SudokuSolver(board, 0, 0);
    }

    private boolean SudokuSolver(char[][] board, int row, int col) {

        if (col == 9) {
            col = 0;
            row++;
        }

        if (row == 9) {
            return true; // solved
        }

        if (board[row][col] != '.') {
            return SudokuSolver(board, row, col + 1);
        } else {
            for (char val = '1'; val <= '9'; val++) {
                if (IsItSafe(board, row, col, val)) {
                    board[row][col] = val;

                    if (SudokuSolver(board, row, col + 1)) {
                        return true; // stop after first valid solution
                    }

                    board[row][col] = '.';
                }
            }
        }

        return false;
    }

    private boolean IsItSafe(char[][] board, int row, int col, char val) {

        // row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == val) return false;
        }

        // column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) return false;
        }

        // 3x3 box
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }

        return true;
    }
}
