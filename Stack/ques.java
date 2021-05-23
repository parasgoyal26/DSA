import java.util.*;

public class ques {

    public static void main(String[] args) {
        // que();
        // eval();
        fun();
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
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        while (st.size() != 0) {
            ans[st.pop()] = arr.length;
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

    // =========================================================================================================================
    public static void eval() {
        String s = "(7 - (4 + 2 * 3)+6/2)+9*2";
        String str = "a*(b-c+d)/e";
        System.out.println(infixToPrefix(s));
        // String postfix = infixToPostfix(s);
        // System.out.println(postfix);
        // System.out.println(postfixEvaluation(postfix));
        // System.out.println(postfixToInfix(postfix));
        // System.out.println(postfixToPrefix(postfix));
        // String prefix = infixToPrefix(s);
        // System.out.println(prefix);
        // System.out.println(prefixEvaluation(prefix));
        // System.out.println(prefixToPostfix(prefix));
        // System.out.println(prefixToInfix(prefix));
    }
    // infix - postfix - prefix evaluations

    public static int priority(char op) {
        if (op == '*' || op == '/') {
            return 2;
        } else if (op == '+' || op == '-') {
            return 1;
        } else {
            return 0;
        }
    }

    public static int evaluate(int val1, int val2, char op) {
        if (op == '/') {
            return val1 / val2;
        } else if (op == '*') {
            return val1 * val2;
        } else if (op == '+') {
            return val1 + val2;
        } else if (op == '-') {
            return val1 - val2;
        } else {
            return 0;
        }
    }

    // infix
    public static int infixEvaluation(String exp) {
        Stack<Character> oStack = new Stack<>();
        Stack<Integer> vStack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (ch == '(') {
                oStack.push(ch);

            } else if (ch == '/' || ch == '*' || ch == '+' || ch == '-') {
                // imp step
                while (oStack.size() != 0 && oStack.peek() != '(' && priority(oStack.peek()) >= priority(ch)) {
                    char op = oStack.pop();
                    int val2 = vStack.pop();
                    int val1 = vStack.pop();
                    int res = evaluate(val1, val2, op);
                    vStack.push(res);
                }
                oStack.push(ch); // jo opr aaya h vo to push hoga na process krwa kr ya phir bina process krwaye
            } else if (ch == ')') {
                while (oStack.peek() != '(') {
                    char op = oStack.pop();
                    int val2 = vStack.pop();
                    int val1 = vStack.pop();
                    int res = evaluate(val1, val2, op);
                    vStack.push(res);
                }
                oStack.pop(); // pop the opening bracket
            } else {
                // ch is a digit
                // always push it
                vStack.push(ch - '0');
            }
        }
        // jaruri to nahi ki ostack empty ho jaye to usko manage krne k liye
        while (oStack.size() != 0) {
            char op = oStack.pop();
            int val2 = vStack.pop();
            int val1 = vStack.pop();
            int res = evaluate(val1, val2, op);
            vStack.push(res);
        }
        return vStack.peek();
    }

    public static String infixToPrefix(String exp) {
        Stack<Character> oStack = new Stack<>();
        Stack<String> vStack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (ch == '(') {
                oStack.push(ch);

            } else if (ch == '/' || ch == '*' || ch == '+' || ch == '-') {
                // imp step
                while (oStack.size() != 0 && oStack.peek() != '(' && priority(oStack.peek()) >= priority(ch)) {
                    char op = oStack.pop();
                    String val2 = vStack.pop();
                    String val1 = vStack.pop();
                    // int res = evaluate(val1, val2, op);
                    String res = op + val1 + val2;
                    vStack.push(res);
                }
                oStack.push(ch); // jo opr aaya h vo to push hoga na process krwa kr ya phir bina process krwaye
            } else if (ch == ')') {
                while (oStack.peek() != '(') {
                    char op = oStack.pop();
                    String val2 = vStack.pop();
                    String val1 = vStack.pop();
                    // int res = evaluate(val1, val2, op);
                    String res = op + val1 + val2;
                    vStack.push(res);
                }
                oStack.pop(); // pop the opening bracket
            } else {
                // ch is a digit
                // always push it
                vStack.push(ch + "");
            }
        }
        // jaruri to nahi ki ostack empty ho jaye to usko manage krne k liye
        while (oStack.size() != 0) {
            char op = oStack.pop();
            String val2 = vStack.pop();
            String val1 = vStack.pop();
            // int res = evaluate(val1, val2, op);
            String res = op + val1 + val2;
            vStack.push(res);
        }
        return vStack.peek();
    }

    public static String infixToPostfix(String exp) {
        Stack<Character> oStack = new Stack<>();
        Stack<String> vStack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (ch == '(') {
                oStack.push(ch);

            } else if (ch == '/' || ch == '*' || ch == '+' || ch == '-') {
                // imp step
                while (oStack.size() != 0 && oStack.peek() != '(' && priority(oStack.peek()) >= priority(ch)) {
                    char op = oStack.pop();
                    String val2 = vStack.pop();
                    String val1 = vStack.pop();
                    // int res = evaluate(val1, val2, op);
                    String res = val1 + val2 + op;
                    vStack.push(res);
                }
                oStack.push(ch); // jo opr aaya h vo to push hoga na process krwa kr ya phir bina process krwaye
            } else if (ch == ')') {
                while (oStack.peek() != '(') {
                    char op = oStack.pop();
                    String val2 = vStack.pop();
                    String val1 = vStack.pop();
                    // int res = evaluate(val1, val2, op);
                    String res = val1 + val2 + op;
                    vStack.push(res);
                }
                oStack.pop(); // pop the opening bracket
            } else {
                // ch is a letter
                // always push it
                vStack.push(ch + "");
            }
        }
        // jaruri to nahi ki ostack empty ho jaye to usko manage krne k liye
        while (oStack.size() != 0) {
            char op = oStack.pop();
            String val2 = vStack.pop();
            String val1 = vStack.pop();
            // int res = evaluate(val1, val2, op);
            String res = val1 + val2 + op;
            vStack.push(res);
        }
        return vStack.peek();

    }

    // prefix
    public static int prefixEvaluation(String exp) {
        Stack<Integer> st = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (ch >= '0' && ch <= '9') {
                st.push(ch - '0');
            } else {
                int val1 = st.pop();
                int val2 = st.pop();
                int res = evaluate(val1, val2, ch);
                st.push(res);
            }
        }
        return st.peek();
    }

    public static String prefixToPostfix(String exp) {
        Stack<String> st = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (ch >= '0' && ch <= '9') {
                st.push("" + ch);
            } else {
                String val1 = st.pop();
                String val2 = st.pop();
                String res = val1 + val2 + ch;
                st.push(res);
            }
        }
        return st.peek();
    }

    public static String prefixToInfix(String exp) {
        Stack<String> st = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (ch >= '0' && ch <= '9') {
                st.push("" + ch);
            } else {
                String val1 = st.pop();
                String val2 = st.pop();
                String res = "(" + val1 + ch + val2 + ")";
                st.push(res);
            }
        }
        return st.peek();
    }

    // postfix
    public static int postfixEvaluation(String exp) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch >= '0' && ch <= '9') {
                st.push(ch - '0');
            } else {
                int val2 = st.pop();
                int val1 = st.pop();
                int res = evaluate(val1, val2, ch);
                st.push(res);
            }
        }
        return st.peek();
    }

    public static String postfixToInfix(String exp) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch >= '0' && ch <= '9') {
                st.push(ch + "");
            } else {
                String val2 = st.pop();
                String val1 = st.pop();
                String res = "(" + val1 + ch + val2 + ")";
                st.push(res);
            }
        }
        return st.peek();
    }

    public static String postfixToPrefix(String exp) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch >= '0' && ch <= '9') {
                st.push(ch + "");
            } else {
                String val2 = st.pop();
                String val1 = st.pop();
                String res = ch + val1 + val2;
                st.push(res);
            }
        }
        return st.peek();
    }

    // ====================================================================================================================

    // leetcode 239 -> sliding window max
    public static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        int[] ngor = ngor(arr);
        int j = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            if (j < i) {
                j = i;
            }
            while (i + k > ngor[j]) {
                j = ngor[j];
            }
            ans[i] = arr[j];
        }
        return ans;
    }

    // leetcode 277 - celebrity problem (locked)
    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"

        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int i = st.pop();
            int j = st.pop();
            if (arr[i][j] == 1) {
                st.push(j);
            } else {
                st.push(i);
            }
        }

        int candidate = st.pop();

        for (int c = 0; c < n; c++) {
            if (arr[candidate][c] == 1) {
                System.out.println("none");
                return;
            }
        }

        for (int r = 0; r < n; r++) {
            if (r != candidate && arr[r][candidate] == 0) {
                System.out.println("none");
                return;
            }
        }

        System.out.println(candidate);
    }

    public static class Pair implements Comparable<Pair> {
        int st;
        int end;

        public Pair(int st, int end) {
            this.st = st;
            this.end = end;
        }

        public int compareTo(Pair other) {
            return this.st - other.st;
        }
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < pairs.length; i++) {
            int st = arr[i][0];
            int end = arr[i][1];
            pairs[i] = new Pair(st, end);
        }

        Arrays.sort(pairs);
        Pair res = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            Pair p = pairs[i];
            if (res.end >= p.st) {
                if (res.end < p.end) {
                    res.end = p.end;
                }
            } else {
                System.out.println(res.st + " " + res.end);
                res = p;
            }
        }
        System.out.println(res.st + " " + res.end);
    }

    // =============================================================================================================
    
    // smallest number following pattern
    public static void snfp(String str) {
        Stack<Integer> st = new Stack<>();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'd') {
                st.push(count);
                count++;
            } else {
                st.push(count);
                count++;
                // print stack
                while (st.size() != 0) {
                    System.out.print(st.pop());
                }
            }
        }
        // after completion of loop
        st.push(count);
        while (st.size() != 0) {
            System.out.print(st.pop());
        }

    }

    public static void fun() {
        // int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        // int k = 3;
        // int[] ans = maxSlidingWindow(arr, k);
        // System.out.println(Arrays.toString(ans));
        int[][] arr = { { 5, 12 }, { 1, 8 }, { 14, 19 }, { 22, 28 }, { 25, 27 }, { 27, 30 } };
        mergeOverlappingIntervals(arr);
    }

}
