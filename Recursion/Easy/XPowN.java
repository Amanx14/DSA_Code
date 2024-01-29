import java.util.ArrayList;

public class XPowN {
    public static double solve(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return solve(1 / x, -n);
        }

        double temp = solve(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        }
        return x * temp * temp;
    }

    public static double myPow(double x, int n) {
        return solve(x, (int) n);
    }

    // Count good Numbers
    public static long MOD = 1_000_000_007;

    public static long power(long x, long n) {
        if (n == 0) {
            return 1;
        }

        long temp = power(x, n / 2);

        if (n % 2 == 0) {
            return temp * temp % MOD;
        }

        return (x * temp * temp) % MOD;
    }

    public static int countGoodNumbers(long n) {
        long evenPow = 0;
        long oddPow = 0;

        if (n % 2 == 0) {
            evenPow = power(5, n / 2) % MOD;
        } else {
            evenPow = (power(5, n / 2) * 5) % MOD;
        }

        oddPow = power(4, n / 2) % MOD;

        return (int) ((evenPow * oddPow) % MOD);
    }

    public static void main(String[] args) {
        int x = 2, n = 2;
        // System.out.println(myPow(x, n));
        System.out.println(countGoodNumbers(n));
    }
}
