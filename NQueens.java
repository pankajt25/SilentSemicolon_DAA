public class NQueens {
    static int N = 4; 

    static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1) return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        for (int i = row, j = col; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1) return false;

        return true;
    }

    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            System.out.println();
        }
        System.out.println();
    }

    static void solve(int[][] board, int row) {
        if (row == N) { printBoard(board); return; }
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                solve(board, row + 1);
                board[row][col] = 0; 
            }
        }
    }

    public static void main(String[] args) {
        solve(new int[N][N], 0);
    }
}
