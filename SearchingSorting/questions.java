public class questions {
    public static void main(String[] args) {
        // int[] arr = {0,1,1,2,0,1,0,1,1,0,0,1,1,1,0,0,2,2};
        // sort01(arr, 0, arr.length -1);
        // sort012(arr);
        // for(int i =0 ; i < arr.length ; i++){
        // System.out.print(arr[i] + " ");
        // }

        // System.out.println(fun(2, 3));
        int[] a = { -2, 5, 9, 11, 11 };
        int[] b = { 4, 6, 8, 11 };
        int[] arr = mergeTwoSortedArrays(a, b);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // sort 0-1
    public static void sort01(int[] arr, int lo, int hi) {
        while (lo <= hi) {
            if (arr[lo] == 0) {
                if (arr[hi] == 1) {
                    lo++;
                    hi--;
                } else if (arr[hi] == 0) {
                    lo++;
                }
            } else if (arr[lo] == 1) {
                if (arr[hi] == 0) {
                    // swap
                    int t = arr[hi];
                    arr[hi] = arr[lo];
                    arr[lo] = t;
                    lo++;
                    hi--;
                } else if (arr[hi] == 1) {
                    hi--;
                }
            }
        }
    }

    // sort 01 better approach
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort01_better(int[] arr) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (arr[j] == 1) {
                j++;
            } else {
                swap(arr, j, i);
                i++;
                j++;
            }
        }
    }

    // ---------------------------------------------------------------------------------------------------------------

    // sort 012
    public static void sort012(int[] arr) {
        int i = 0;
        int j = 0;
        int k = arr.length - 1;
        while (j <= k) {
            if (arr[j] == 2) {
                swap(arr, j, k);
                k--;
            } else if (arr[j] == 1) {
                j++;

            } else if (arr[j] == 0) {
                swap(arr, j, i);
                i++;
                j++;
            }
        }
    }

    // =====================================================================================================

    // solve polynomial
    public static int fun(int x, int N) {
        int sum = 0;
        int n = N;
        int xpower = x;
        for (int i = 1; i <= N; i++) {
            sum += n * xpower;
            n--;
            xpower *= x;
        }
        return sum;
    }

    // =====================================================================================================

    // merger two sorted arrays
    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        int[] ans = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                ans[k] = b[j];
                k++;
                j++;
            } else {
                ans[k] = a[i];
                k++;
                i++;
            }
        }
        while (i < a.length) {
            ans[k] = a[i];
            k++;
            i++;
        }

        while (j < b.length) {
            ans[k] = b[j];
            k++;
            j++;
        }

        return ans;
    }

    // ==================================================================================
    // partition an array
    public static void partition(int[] arr, int pivot) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (arr[j] <= pivot) {
                swap(arr, j, i);
                j++;
                i++;
            } else {
                j++;
            }
        }
    }

    //partition index
    public static void partition(int[] arr, int pivot) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (arr[j] <= pivot) {
                swap(arr, j, i);
                j++;
                i++;
            } else {
                j++;
            }
        }
    }
}
