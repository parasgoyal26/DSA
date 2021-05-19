import java.util.*;

public class prime {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 9, 15, 12, 3, 4, 9, 7, 5, 12, 19, 17, 15, 5 };
        sieve(arr);
    }

    public static boolean isPrimwe(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printPrime(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (isPrimwe(arr[i])) {
                System.out.println(arr[i] + " is Prime");
            } else {
                System.out.println(arr[i] + " is not Prime");
            }
        }
    }

    // another method
    // sieve of eratosthenes (sieve theorem)

    public static void sieve(int[] queries) {
        int range = 20; // queries[] less than 20 honge
        boolean[] primes = new boolean[range + 1];

        Arrays.fill(primes, true);

        for (int i = 2; i * i <= range; i++) {
            if (primes[i] == false)
                continue;
            for (int j = i; j <= range; j++) {
                primes[j] = false;
            }
        }

        for (int q = 0; q < queries.length; q++) {
            int num = queries[q];
            if (primes[num] == true) {
                System.out.println(num + " is prime");
            } else {
                System.out.println(num + " is not prime");
            }
        }
    }

}
