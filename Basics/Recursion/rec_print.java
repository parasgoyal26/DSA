import java.util.*;

public class rec_print {
    public static void main(String[] args) {
        // countEncodings("12345");
        // System.out.println(count);
        int[] arr = {1,2,5,10};
        System.out.println(count(arr, 3));

    }

    // print maze paths with jumps
    public static void printMazePaths(int sr, int sc, int dr, int dc, String asf) {
        // base case
        if (sr == dr && sc == dc) {
            System.out.println(asf);
            return;
        }

        // horizontal call
        for (int jump = 1; sc + jump <= dc; jump++) {
            printMazePaths(sr, sc + jump, dr, dc, asf + "h" + jump);
        }

        // vertical calls
        for (int jump = 1; sr + jump <= dr; jump++) {
            printMazePaths(sr + jump, sc, dr, dc, asf + "v" + jump);
        }

        // diagonal calls
        for (int jump = 1; sr + jump <= dr && sc + jump <= dc; jump++) {
            printMazePaths(sr + jump, sc + jump, dr, dc, asf + "d" + jump);
        }
    }

    // print permutations
    public static void printPermutations(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String ch = str.charAt(i) + "";
            String ros = str.substring(0, i) + str.substring(i + 1);
            printPermutations(ros, asf + ch);
        }
    }

    // print encodings
    public static void printEncodings(String qsf, String asf) {

        if (qsf.length() == 0) {
            System.out.println(asf);
            return;
        }
        if (qsf.charAt(0) == '0') {
            return;
        }

        int num1 = qsf.charAt(0) - '0';
        printEncodings(qsf.substring(1), asf + (char) ('a' + num1 - 1));
        if (qsf.length() > 1) {
            int num2 = qsf.charAt(1) - '0';
            int num = num1 * 10 + num2;
            if (num <= 26) {
                printEncodings(qsf.substring(2), asf + (char) ('a' + num - 1));
            }
        }

    }

    // ===============================================================================
    // count encodings
    static int count = 0;

    public static void countEncodings(String qsf) {
        if (qsf.length() == 0) {
            count++;
            return;
        }
        if (qsf.charAt(0) == '0') {
            return;
        }
        int num1 = qsf.charAt(0) - '0';
        countEncodings(qsf.substring(1));
        if (qsf.length() > 1) {
            int num2 = qsf.charAt(1) - '0';
            int num = num1 * 10 + num2;
            if (num <= 26) {
                countEncodings(qsf.substring(2));
            }
        }

    }

    //coin change combination

    public static int count(int arr[], int n ){
        int table[]=new int[n+1];
        table[0] = 1;

        for(int i=0; i<arr.length; i++)
            for(int j=arr[i]; j<=n; j++)
                table[j] += table[j-arr[i]];

        return table[n];
    }


}
