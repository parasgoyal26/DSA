import java.util.Arrays;
import java.util.Scanner;
public class countsort {
    public static void countSort(int[] arr, int min, int max) {
        // write your code here
        int[] fmap = freq(arr, min , max);
        System.out.println(Arrays.toString(fmap));

        int indx = 0;
        for(int i = 0 ; i  < fmap.length ; i++){
            int f = fmap[i];        //freq of i + min value 
            int val = i + min;
            for(int j = 0; j < f ; j++){
                arr[indx] = val;
                indx++;
            }
        }

    }

    public static int[] freq(int[] arr, int min , int max){
        int size = max - min + 1;
        int[] freq = new int[size];
        for(int  i =0; i < arr.length ; i++){
            int idx = arr[i];
            freq[idx - min]++;
        }
        return freq;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // int[] arr = new int[n];
        int[] arr = {1,2,5,7,8,9,6,12,0,-1,1};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            // arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        print(arr);
    }
}
