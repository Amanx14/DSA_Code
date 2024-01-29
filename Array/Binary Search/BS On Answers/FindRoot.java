import java.util.Scanner;

public class FindRoot {
    public static int sqrt(int n) {
        int ans = 0;
        for(int i=1; i<=n; i++) {
            if(i * i <= n) {
                ans =  i;
            }
        }
        return ans;
    }
    public static int optimalSol(int n) {
        int ans = 0;
        int low = 1, high = n;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(mid * mid <= n) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }

    //------------Nth Root of a number-----------------
    public static int nthRoot(int n, int m) {
        int ans = 0;

        for(int i=1; i<=m; i++) {
            int currPowN = (int)Math.pow(i, n);
            if(currPowN == m) {
                ans = i;
            }
        }

        return ans;
    }
    public static int NthRoot(int n, int m) {

        int low = 1, high = m;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            long currPowN = (long)Math.pow(mid, n);
            if(currPowN == m) {
                return mid;
            }
            else if(currPowN > m) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {

        int n = 22;
        System.out.println(sqrt(n));

        // int N = 3, M = 27;
        // // System.out.println(NthRoot(N, M));
    }
}