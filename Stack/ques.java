import java.util.*;

public class ques {

    public static void main(String[] args) {
        que();
    }

    public static void que() {
        // String exp = "(((a+b))+(c+d))";
        // System.out.println(duplicateBrackets(exp));
        int[] arr = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(arr));
    }

    public static void game() {
        String[] arr = { "5", "2", "C", "D", "+" };
        int ans = calPoints(arr);
        System.out.println(ans);
    }

    // dupicate brackets
    public static boolean duplicateBrackets(String exp) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == ' ') {
                continue;
            } else if (ch == ')') {
                if (st.peek() == '(') {
                    return true;
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }

            } else {
                st.push(ch);
            }
        }
        return false;
    }

    // balanced brackets
    public static boolean balancedBrackets(String exp) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            if (ch == ')') {
                if (st.isEmpty() == false && st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            }
            if (ch == '}') {
                if (st.isEmpty() == false && st.peek() == '{') {
                    st.pop();
                } else {
                    return false;
                }
            }
            if (ch == ']') {
                if (st.isEmpty() == false && st.peek() == '[') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    // Next greater element to the right
    public static int[] ngor(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (st.size() != 0 && arr[st.peek()] < arr[i]) {
                ans[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }

        while (st.size() != 0) {
            ans[st.pop()] = -1;
        }

        return ans;
    }

    public static int[] ngol(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() != 0 && arr[st.peek()] < arr[i]) {
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        while (st.size() != 0) {
            ans[st.pop()] = -1;
        }

        return ans;
    }

    public static int[] nsor(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (st.size() != 0 && arr[st.peek()] > arr[i]) {
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        while (st.size() != 0) {
            ans[st.pop()] = n;
        }
        return ans;
    }

    public static int[] nsol(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() != 0 && arr[st.peek()] > arr[i]) {
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        while (st.size() != 0) {
            ans[st.pop()] = -1;
        }
        return ans;
    }

    // stock span
    public static int[] stockSpan(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int[] ngol = ngol(arr);
        for (int i = 0; i < n; i++) {
            ans[i] = i - ngol[i];
        }
        return ans;
    }

    // leetcode 739 -> Daily Temparatures
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int[] ngor = ngor(arr); // jinka ngor nhi h unke liye ngor[i] = i -> taaki jab (ngor[i] - i) calculate
                                // ho tab zero aaye
        for (int i = 0; i < n; i++) {
            ans[i] = ngor[i] - i;
        }
        return ans;

    }

    // leetcode 682 - baseball game
    public static int calPoints(String[] arr) {
        int sum = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if (s == "+") {
                int a = st.pop();
                int b = st.peek();
                st.push(a);
                st.push(a + b);
            } else if (s == "D") {
                st.push(2 * st.peek());
            } else if (s == "C") {
                st.pop();
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        while (st.size() != 0) {
            sum += st.pop();
        }
        return sum;
    }

    // leetcode 84 -> largest rectangle in histogram
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int[] nsor = nsor(heights);
        int[] nsol = nsol(heights);

        for (int i = 0; i < n; i++) {
            int width = nsor[i] - nsol[i] - 1;
            int area = width * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    // leetcode 85 -> maximal rectangle
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];

        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[j] = matrix[i][j] == '1' ? arr[j] + 1 : 0;
            }
            area = Math.max(area, largestRectangleArea(arr));
        }
        return area;
    }

    // leetcode 239 -> sliding window max
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

    }

    // leetcode 503 -> next greater element 2
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (st.size() != 0 && arr[st.peek()] < arr[i % n]) {
                ans[st.peek()] = arr[i % n];
                st.pop();
            }
            if (i < n) {
                st.push(i);
            }
        }
        while (st.size() != 0) {
            ans[st.pop()] = -1;
        }
        return ans;
    } 
}
