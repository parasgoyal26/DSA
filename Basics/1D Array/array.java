import java.util.*;

class array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
    }

    // sum of two arrays
    public static int[] sum(int[] arr1, int[] arr2) {
        int size = Math.max(arr1.length, arr2.length) + 1;
        int[] ans = new int[size];
        int idx1 = arr1.length - 1;
        int idx2 = arr2.length - 1;
        int idx3 = ans.length - 1;

        int carry = 0;
        while (idx1 >= 0 || idx2 >= 0 || carry > 0) {
            int sum = carry;
            if (idx1 >= 0) {
                sum += arr1[idx1];
            }
            if (idx2 >= 0) {
                sum += arr2[idx2];
            }

            int q = sum / 10;
            int r = sum % 10;
            ans[idx3] = r;
            idx1--;
            idx2--;
            idx3--;
            carry = q;
        }
        return ans;
    }

    // difference of two arrays
    public static int[] diff(int[] arr1, int[] arr2) {
        int[] ans = new int[arr2.length];
        int i1 = arr1.length - 1;
        int i2 = arr2.length - 1;
        int i3 = ans.length - 1;
        int carry = 0;
        while (i2 >= 0) {
            int diff = arr2[i2] - carry;
            if (i1 >= 0) {
                diff -= arr1[i1];
            }
            if (diff < 0) {
                diff += 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ans[i3] = diff;
            i1--;
            i2--;
            i3--;
        }
        return ans;
    }

    // print all subarrays
    public static void printSubArray(int[] arr) {
        for (int sp = 0; sp < arr.length; sp++) {
            for (int ep = sp; ep < arr.length; ep++) {
                for (int i = sp; i <= ep; i++) {
                    System.out.print(arr[i] + "\t");
                }
                System.out.println();
            }
        }
    }

    // find pair given diff (gfg)
    public static int findDiff(int[] arr, int k) {
        int ans = -1;
        int find;
        int find2;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                find = k + arr[i];
                find2 = find;
            } else {
                find = arr[i] - k;
                find2 = arr[i] + k;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == find || arr[j] == find2) {
                    ans = 1;
                    return ans;
                }
            }
        }
        return ans;
    }
}