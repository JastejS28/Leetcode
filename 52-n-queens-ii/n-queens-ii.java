class Solution {
    public int totalNQueens(int n) {
		boolean [][] board= new boolean[n][n];
		return QueenProblem(board, n, 0);
	}

	public static int QueenProblem(boolean[][] board, int tq, int row ) {

		if(tq==0) {
            return 1;
		}

         int count = 0;

		for(int col=0; col<board[0].length; col++) {
			if(IsItSafe(board, row, col)==true) {
				board[row][col]=true;
				count= count+QueenProblem(board, tq-1, row+1);
				board[row][col]=false;
			}
		}	
        return count;	
	}

	public static boolean IsItSafe(boolean[][] board, int row, int col) {
		int r=row;
		//up
		while(r>=0) {
			if(board[r][col]==true) {
				return false;
			}
			r--;
		}
		
		//left diagonal
		int c=col;
        r=row;
		while(r>=0 && c>=0) {
			if(board[r][c]==true) {
				return false;
			}
			r--;
			c--;
		}
		
		r=row;
		c=col;
		//right diagonal
		while(r>=0 && c<board[0].length) {
			if(board[r][c]==true) {
				return false;
			}
			r--;
			c++;
		}
		
		return true;
	}
	


}