import java.util.*;
public class recursion{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //pid(1,n);
        pzz(n);
    }

    //print decreasing
    public static void pd(int n){
        if(n == 0){
            return;
        }
        System.out.print(n + " ");
        pd(n-1);
    }

    //print increasing
    public static void pi(int n){
        if(n == 0){
            return;
        }
        pi(n-1);
        System.out.println(n);
    }

    //print dec inc
    public static void pdi(int n){
        if(n == 0){
            return;
        }
        System.out.print(n + " ");
        pdi(n-1);
        System.out.print(n + " ");
    }

    // print inc - dec
    public static void pid(int n, int k){
        if(n == k+1){
            return;
        }

        System.out.print(n + " ");
        pid(n+1,k);
        System.out.print(n + " ");
    }

    // print zig zag
    public static void pzz(int n){
        if(n == 0) {
            return;
        }
        System.out.print(n + " ");
        pzz(n-1);
        System.out.print(n + " ");
        pzz(n-1);
        System.out.print(n + " ");
    }

    // print factorial
    public static int fact(int n){
        if(n == 0){
            return 1;
        }
        return n * fact(n-1);
    } 

    //power linear
    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        return x * power(x , n-1);
    }


    //power logarithmic

    public static int powerLog(int x,int n){
        if(n == 0){
            return 1;
        }
        int f1 = powerLog(x, n/2);
        if(n%2 == 0){
            return f1 * f1;
        }else{
            return f1 * f1 * x ;
        }
    }
}