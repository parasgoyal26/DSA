import java.util.*;

public class rec_Array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        display(arr, 0);
    }

    // display array
    public static void display(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }
        System.out.print(arr[idx]);
        display(arr, idx + 1);
    }

    public static void display1(int[] arr, int idx) {
        if (idx == arr.length) {
            System.out.println();
            return;
        }
        System.out.print(arr[idx] + " ");
        display(arr, idx + 1);
    }

    // diplay reverse
    public static void displayArrReverse(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }
        displayArrReverse(arr, idx + 1);
        System.out.println(arr[idx]);
    }

    // max of array
    public static int maxOfArray(int[] arr, int idx) {
        if (idx == arr.length) {
            return -(int) 1e8;
        }
        int currMax = maxOfArray(arr, idx + 1);
        return Math.max(arr[idx], currMax);
    }

    // min of array
    public static int minOfArray(int[] arr, int idx) {
        if (idx == arr.length) {
            return (int) 1e8;
        }
        int currMax = minOfArray(arr, idx + 1);
        return Math.min(arr[idx], currMax);
    }

    //find in array
    public static boolean find(int[] arr, int idx, int x){
        if(idx == arr.length){
            return false;
        }
        
        if(arr[idx] == x){
            return true;
        }
        else{
            return find(arr, idx+1, x);
        }
    }

    // first index
    public static int firstIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }

        if (arr[idx] == x) {
            return idx;
        } else {
            return firstIndex(arr, idx + 1, x);
        }
    }

    // last index
    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }

        int recAns = lastIndex(arr, idx + 1, x);
        if (recAns != -1) {
            return recAns;
        } else {
            if (arr[idx] == x) {
                return idx;
            } else {
                return -1;
            }
        }
    }

    // all indices of array
    public static int[] allIndices(int[] arr, int x, int idx, int count) {
        // write ur code here
        if(idx == arr.length){
            int[] bans = new int[count];
            return bans; 
        }
        if(arr[idx] == x){
            count++;
        }
        int[] rr = allIndices(arr, x, idx + 1, count);
        if(arr[idx] == x){
            rr[count-1] = idx;
        }

        return rr;
    }
}
