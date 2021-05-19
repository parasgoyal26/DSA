import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class test {
    // public static void main(String[] args) {
    //     // Scanner scn = new Scanner(System.in);
    //     // int n = scn.nextInt();
    //     // int b = scn.nextInt();
    //     // int num = dectoanybase(n, b);
    //     // String s = Integer.toString(num);
    //     // int ans = countMaxZero(s);
    //     // System.out.println(ans);
    //     int[] arr = { 2, 3, 6, 7 };
    //     int tar = 7;
    //     ArrayList<ArrayList<Integer>> res = combinationSum(arr, tar);
    //     System.out.println(res);
    // }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] sudoku = new char[9][9];
        for(int i =0 ; i < sudoku.length ; i++){
            for(int j =0 ; j < sudoku[0].length ; j++){
                sudoku[i][j] = scn.next().charAt(0);
            }
        }
        solveSudoku(sudoku);
        // System.out.println("solved");
        // for(int i =0 ; i < sudoku.length ; i++){
        //     for(int j =0 ; j < sudoku[0].length ; j++){
        //         System.out.print(sudoku[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
    }

    // diff between 2nd max and 2nd min in an array
    public static void diff(int[] arr) {
        int max = -(int) 1e9;
        int min = (int) 1e9;
        int smax = -(int) 1e9;
        int smin = (int) 1e9;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                int temp = max;
                max = arr[i];
                smax = temp;
            } else if (arr[i] > smax && arr[i] < max) {
                smax = arr[i];
            }

            if (arr[i] < min) {
                int temp = min;
                min = arr[i];
                smin = temp;
            } else if (arr[i] < smin && arr[i] > min) {
                smin = arr[i];
            }

        }
        int ans = smax - smin;
        System.out.println(ans);
    }

    // check mirror in inverse of array
    public static void mirror(int[] arr) {
        int[] mirror = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            mirror[arr[i]] = i;
        }

        for (int i = 0; i < mirror.length; i++) {
            System.out.print(mirror[i] + " ");
        }
        System.out.println();
        boolean ans = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != mirror[i]) {
                ans = false;
                break;
            }
        }
        System.out.println(ans);
    }

    // all indices of an array

    // running sum of array
    public static int[] runningSum(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += arr[j];
            }
            ans[i] = sum;
        }

        return ans;
    }

    // richest in 2d
    public static void richest(int[][] arr) {
        int max = 0;
        int idx = -1;
        for (int i = 0; i < arr.length; i++) {
            int sum = colSum(arr, i);
            if (sum > max) {
                max = sum;
                idx = i;
            }
        }
        System.out.println(idx);
    }

    public static int colSum(int[][] arr, int r) {
        int sum = 0;
        for (int j = 0; j < arr[0].length; j++) {
            sum += arr[r][j];
        }
        return sum;
    }

    // plus one in array
    public static int[] plusOne(int[] arr) {
        int[] ans = new int[arr.length + 1];
        ans[ans.length - 1] = 1;
        int carry = 0;
        for (int i = 1; i <= arr.length; i++) {
            int n = ans[ans.length - i] + arr[arr.length - i] + carry;
            int d = n % 10;
            carry = n / 10;
            ans[ans.length - i] = d;
        }
        if (carry != 0) {
            ans[0] = carry;
        }

        return ans;
    }

    public static int dectoanybase(int n, int b) {
        int ans = 0;
        int power = 1;
        while (n != 0) {
            int rem = n % b;
            n = n / b;
            ans = ans + (rem * power);
            power *= 10;
        }
        return ans;
    }

    public static int countMaxZero(String num) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < num.length(); i++) {
            int d = num.charAt(i) - '0';
            if (d != 0) {
                count = 0;
            } else {
                count++;
                max = Math.max(max, count);
            }
        }
        if (max == 0) {
            return -1;
        }
        return max;
    }

    ///////////////////////// ===================================================================================================

    // leetcode 39 combination sum
    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if (candidates.length == 0) {
            return res;
        }

        ArrayList<Integer> combination = new ArrayList();
        combination(res, combination, candidates, target, 0);
        return res;
    }

    public static void combination(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> combination, int[] numbers,
            int target, int idx) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(combination));
            return;
        }

        for (int i = idx; i < numbers.length; i++) {
            if (numbers[i] <= target) {
                combination.add(numbers[i]);
                combination(res, combination, numbers, target - numbers[i], i);
                combination.remove(combination.size() - 1);
            }
        }

    }

    // leetcode n queens

    // leetcode 37 sudoku solver

    public static void solveSudoku(char[][] board) {
        sudokuSolver(board, 0, 0);
    }

    public static boolean flag = false;

    public static void sudokuSolver(char[][] board, int i, int j) {
        if (i == 9) {
            flag = true;
            return;
        }
        int ni = 0;
        int nj = 0;

        if (j == 8) {
            nj = 0;
            ni = i + 1;
        } else {
            ni = i;
            nj = j + 1;
        }

        if (board[i][j] == '.') {
            for (int po = 1; po <= 9; po++) {
                if (isSafe(board, i, j, (po + "").charAt(0)) == true) {
                    board[i][j] = (po + "").charAt(0);
                    sudokuSolver(board, ni, nj);
                    if (flag == true)
                        return;
                    board[i][j] = '.';
                }
            }

        } else {
            sudokuSolver(board, ni, nj);
        }

    }

    public static boolean isSafe(char[][] board, int r, int c, char val) {
        int si = (r / 3) * 3;
        int sj = (c / 3) * 3;
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == val || board[i][c] == val)
                return false;
        }
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (board[si + i][sj + j] == val)
                    return false;
            }
        }
        return true;
    }

}