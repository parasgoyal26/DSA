import java.util.*;

class array {
    public static void main(String[] args) {
        
        
    }

    // display 2d array
    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // matrix multiplication
    public static void mm(int[][] mat1, int[][] mat2) {
        if (mat1[0].length != mat2.length) {
            System.out.println("invalid output");
            return;
        }
        int[][] ans = new int[mat1.length][mat2[0].length];
        int cd = mat2.length;
        for (int i = 0; i < ans.length; i++) {
            for (j = 0; j < ans[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < cd; k++) {
                    sum += mat1[i][k] * mat2[k][j];
                }
                ans[i][j] = sum;
            }
        }
    }

    // wave traversal
    public static void wave(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for (int col = 0; col < m; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    System.out.println(arr[row][col]);
                }
            } else {
                for (int row = n - 1; row >= 0; row--) {
                    System.out.println(arr[row][col]);
                }
            }
        }
    }

    // spiral display
    public static void spiral(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int row_start = 0, col_start = 0, row_end = n - 1, col_end = m - 1;
        int eleCount = 0;
        int totalEle = n * m;
        while (eleCount < totalEle) {
            for (int i = row_start; i <= row_end && eleCount < totalEle; i++) {
                System.out.println(arr[i][col_start]);
                eleCount++;
            }
            col_start++;

            for (int i = col_start; i <= col_end && eleCount < totalEle; i++) {
                System.out.println(arr[row_end][i]);
                eleCount++;
            }
            row_end--;

            for (int i = row_end; i >= row_start && eleCount < totalEle; i--) {
                System.out.println(arr[i][col_end]);
                eleCount++;
            }
            col_end--;

            for (int i = col_end; i >= col_start && eleCount < totalEle; i--) {
                System.out.println(arr[row_start][i]);
                eleCount++;
            }
            row_start++;

        }
    }

    // exit point of a matrix
    public static void exitPoint(int[][] arr) {
        int dir = 0;
        int row = 0;
        int col = 0;
        while (true) {
            dir = (dir + arr[row][col]) % 4;
            if (dir == 0) {
                col++;

            } else if (dir == 1) {
                row++;

            } else if (dir == 2) {
                col--;

            } else if (dir == 3) {
                row--;

            }

            if (row < 0) {
                row++;
                break;
            } else if (col < 0) {
                col++;
                break;
            } else if (row == arr.length) {
                row--;
                break;
            } else if (col == arr[0].length) {
                col--;
                break;
            }

        }

        System.out.println(row);
        System.out.println(col);
    }

    // rotate matrix by 90 deg clockwise
    public static void rotate(int[][] arr){
        //transpose
        for(int i= 0 ; i < arr.length ; i++){
            for(int j = i ; j < arr[0].length ; j++){
                int temp = arr[i][j] ; 
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //reverse columns
        for(int i =0 ; i < arr.length ; i++){
            int li = 0;
            int ri = arr[0].length - 1;
            while(li < ri){
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;

                li++;
                ri--;
            }
        }
    }


    // diagonal traversal 
    public static void diag(int[][] arr){
        for(int g =0 ; g < arr.length ; g++){
            for(int i =0 , j = g ;j < arr.length ; i++, j++ ){
                System.out.println(arr[i][j]);
            }
        }
    }

    // ring rotate or shell rotate
    public static void ringRotate(int[][] arr){

    }

    //saddle point
    public static void saddle(int[][] arr){

    }
}
