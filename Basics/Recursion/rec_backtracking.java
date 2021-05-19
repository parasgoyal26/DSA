import java.util.*;

public class rec_backtracking {
    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // int m = scn.nextInt();
        // int[][] arr = new int[n][m];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // arr[i][j] = scn.nextInt();
        // }
        // }
        // boolean[][] vis = new boolean[n][m];
        // int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        // char[] move = {'t', 'l', 'd', 'r'};
        // floodfill2(arr, 0 , 0, "" ,vis,dir,move );

        // int n = 4;
        // boolean[][] board = new boolean[n][n];
        // nqueen(board, 0, "");

        // int n = 5;
        // int[][] board = new int[n][n];
        // knightTour(board, 2, 0, 1);
    }

    // flood fill
    // stupid call and smart base case
    public static void floodfill(int[][] maze, int sr, int sc, String asf, boolean[][] visited) {
        if (sr == maze.length - 1 && sc == maze[0].length - 1) {
            System.out.println(asf);
            return;
        }

        if (sc < 0 || sr < 0 || sr >= maze.length || sc >= maze[0].length || maze[sr][sc] == 1
                || visited[sr][sc] == true) {
            return;
        }

        visited[sr][sc] = true;

        floodfill(maze, sr - 1, sc, asf + "t", visited);
        floodfill(maze, sr, sc - 1, asf + "l", visited);
        floodfill(maze, sr + 1, sc, asf + "d", visited);
        floodfill(maze, sr, sc + 1, asf + "r", visited);

        visited[sr][sc] = false;
    }

    // flood fill
    // smart calls
    public static void floodfill2(int[][] maze, int sr, int sc, String asf, boolean[][] vis, int[][] dir, char[] move) {
        if (sr == maze.length - 1 && sc == maze[0].length - 1) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < dir.length; i++) {
            int row = sr + dir[i][0];
            int col = sc + dir[i][1];

            if (vis[row][col] == false && maze[row][col] == 0 && row >= 0 && row < maze.length && col >= 0
                    && col < maze[0].length) {
                vis[row][col] = true;
                floodfill2(maze, row, col, asf + move[i] + "", vis, dir, move);
                vis[row][col] = false;
            }
        }
    }
//---------------------------------------------------------------------------------------------------------------------
    // target sum subset
    public static void tss(int[] arr, int tar, int idx, String asf, int ssf) {
        if (idx == arr.length && ssf == tar) {
            System.out.println(asf + ".");
            return;
        }
        if (idx >= arr.length) {
            return;
        }
        if (ssf > tar) {
            return;
        }
        tss(arr, tar, idx + 1, asf + arr[idx] + ", ", ssf + arr[idx]);
        tss(arr, tar, idx + 1, asf, ssf);
    }

//-------------------------------------------------------------------------------------------------------------------------
    // n queen
    static int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

    public static boolean isQueenSafe(boolean[][] board, int r, int c) {
        for (int rad = 1; rad < board.length; rad++) {
            for (int[] d : dir) {
                int nr = r + (rad * d[0]);
                int nc = c + (rad * d[1]);
                if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                    if (board[nr][nc] == true) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void nqueen(boolean[][] board, int r, String asf) {
        if (r == board.length) {
            System.out.println(asf);
            return;
        }

        for (int c = 0; c < board[0].length; c++) {
            if (isQueenSafe(board, r, c) == true) {
                // place it
                board[r][c] = true;
                nqueen(board, r + 1, asf + r + "_" + c + ", ");
                // unplace it
                board[r][c] = false;
            }
        }
    }
//------------------------------------------------------------------------------------------------------------------------------
    // knight tour

    static int[][] move = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };

    public static void knightTour(int[][] board, int r, int c, int step) {
        if(step == board.length * board[0].length){
            board[r][c] = step;
            displayBoard(board);
            board[r][c] = 0;
            return;
        }

        board[r][c] = step;
    
        for (int[] d : move) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 0) {
                knightTour(board, nr, nc, step + 1);
            }
        }
        board[r][c] = 0;
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
