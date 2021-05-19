import java.util.Scanner;

class dp {
    public static void main(String[] args) {
        // int n = 10;
        // int[] dp = new int[n + 1];
        // int[] arr = { 3, 3, 0, 2, 1, 2, 4, 2, 0, 0 };

        // System.out.println(climbMinJumps(0, n, arr, dp));
        int[] coins = { 2, 3, 5, 6 };
        int target = 7;
        System.out.println(coinChangeCom_dp(coins, target));

    }

    // -----------------------------------------------------------------------------------------------------------------
    public static void fib() {

    }

    // --------------------------------------------------------------------------------------------------------------

    // climb stairs
    public static void climb() {
        int n = 4;
        int[] dp = new int[n + 1];
        System.out.println(climbStairs(0, n, dp));

    }

    public static int climbStairs(int i, int n, int[] dp) {
        if (i == n)
            return dp[i] = 1;

        if (dp[i] != 0)
            return dp[i];

        int count = 0;
        for (int jump = 1; jump <= 3 && i + jump <= n; jump++) {
            count += climbStairs(i + jump, n, dp);
        }

        return count;
    }

    // climb stairs with variable jumps

    public static int climbVariableJumps(int i, int n, int[] arr, int[] dp) {
        if (i == n)
            return dp[i] = 1;

        if (dp[i] != 0)
            return dp[i];

        int count = 0;
        for (int jump = 1; jump <= arr[i] && i + jump <= n; jump++) {
            count += climbVariableJumps(i + jump, n, arr, dp);
        }

        return count;
    }

    // climb stairs with minimum moves

    public static int climbMinJumps(int i, int n, int[] arr, int[] dp) {
        if (i == n)
            return dp[i] = 0;

        if (dp[i] != 0)
            return dp[i];

        int minJumps = (int) 1e8;
        for (int jump = 1; jump <= arr[i] && i + jump <= n; jump++) {
            minJumps = Math.min(minJumps, climbMinJumps(i + jump, n, arr, dp));
        }

        return minJumps + 1;
    }

    // ==========================================================================================================================
    public static void solve() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        System.out.println(mazeMin(arr, 0, 0));
    }

    // min cost of maze traversal
    public static int mazeMin(int[][] arr, int r, int c) {
        if (r == arr.length - 1 && c == arr[0].length - 1) {
            return arr[r][c];
        }

        if (r >= arr.length || c >= arr[0].length) {
            return (int) 1e8;
        }

        int hpath = mazeMin(arr, r, c + 1);
        int vpath = mazeMin(arr, r + 1, c);
        int ans = arr[r][c] + Math.min(hpath, vpath);
        return ans;
    }

    public static int minCostPath_tab(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        int[][] dp = new int[n][m];

        for (int r = n - 1; r >= 0; r--) {
            for (int c = m - 1; c >= 0; c--) {
                if (r == n - 1 && c == m - 1) {
                    dp[r][c] = maze[r][c];
                } else if (r == n - 1) {
                    dp[r][c] = maze[r][c] + dp[r][c + 1];
                } else if (c == m - 1) {
                    dp[r][c] = maze[r][c] + dp[r + 1][c];

                } else {
                    dp[r][c] = maze[r][c] + Math.min(dp[r][c + 1], dp[r + 1][c]);
                }
            }
        }

        return dp[0][0];
    }

    // ---------------------------------------------------------------------------------------------------------------
    // goldmine

    // -------------------------------------------------------------------------------------------------------------

    // coin change permutations
    public static int coinChangePer_rec(int[] coins, int target) {
        if (target == 0) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            if (target - coin >= 0) {
                count += coinChangePer_rec(coins, target - coin);
            }
        }
        return count;
    }

    public static int coinChangePer_memo(int[] coins, int target, int[] dp) {
        if (target == 0) {
            return dp[target] = 1;
        }

        if (dp[target] != 0) {
            return dp[target];
        }

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            if (target - coin >= 0) {
                count += coinChangePer_memo(coins, target - coin, dp);
            }
        }
        return dp[target] = count;
    }

    public static int coinChangePer_dp(int[] coins, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int t = 1; t <= target; t++) {
            int count = 0;
            for (int i = 0; i < coins.length; i++) {
                int coin = coins[i];
                if (t - coin >= 0) {
                    count += dp[t - coin];
                }
            }
            dp[t] = count;
        }
        return dp[target];
    }

    // coin change combinations
    public static int coinChangeCom_rec(int[] coins, int target, int coin_idx) {
        if (target == 0) {
            return 1;
        }

        int count = 0;

        for (int i = coin_idx; i < coins.length; i++) {
            int coin = coins[i];
            if (target - coin >= 0) {
                count += coinChangeCom_rec(coins, target - coin, i);  //imp step - i se call lagaya h
            }
        }
        return count;
    }

    public static int coinChangeCom_dp(int[] coins , int target){
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int i =0 ; i < coins.length ; i++){
            int coin = coins[i];
            for(int t = coin ; t <= target ; t++){
                dp[t] += dp[t - coin];
            }
        }
        return dp[target];
    }


    //==========================================================================================================================

    //target sum suubset
    public static boolean tss(int[] arr , int target){
         
    }
}