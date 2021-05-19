public class stableSort {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 7, 8, 9, 6, 12, 0, 5, 5, 8, 9 };
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int[] fmap = freq(arr, min, max);
        int[] prefix = new int[fmap.length];
        prefix[0] = fmap[0] - 1;
        for (int i = 1; i <= fmap.length; i++) {
            prefix[i] = prefix[i - 1] + fmap[i];
        }

        for (int i = arr.length - 1; i >= 0; i++) {
            
        }
    }

    public static int[] freq(int[] arr, int min, int max) {
        int size = max - min + 1;
        int[] freq = new int[size];
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i];
            freq[idx - min]++;
        }
        return freq;
    }
}
