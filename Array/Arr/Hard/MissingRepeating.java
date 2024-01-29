public class MissingRepeating {
    public static int[] MissingRepeatingBrute(int []arr) {
        
        int freq[] = new int[arr.length+1];
        
        for(int i=0; i<arr.length; i++) {
            freq[arr[i]]++;
        }

        int repeating = -1;
        int missing = -1;
        
        for(int i=0; i<freq.length; i++) {
            if(freq[i] == 2) {
                repeating = i;
            }
            
            if(i > 0 && freq[i] == 0) {
                missing = i;
            }
        }

        return new int[]{repeating, missing};
    }
    public static int[] missingRepeatingOptimal(int arr[]) {
        int n = arr.length;
        long Sn = (n * (n + 1)) / 2;
        long Sn2 = (n * (n + 1) * (2*n + 1)) / 6;

        long S = 0, S2 = 0;

        for(int i=0; i<n; i++) {
            S += arr[i];
            S2 += (long)arr[i] *  (long)arr[i];
        }

        long eqn1 = S - Sn; // x - y
        long eqn2 = S2- Sn2; // x2 - y2

        eqn2 = eqn2 / eqn1; // x + y;

        long x = (eqn1 + eqn2) / 2;

        long y = eqn2 - x;

        int ans[] = {(int)x, (int)y};
        return ans;
    }

    public static int[] missingRepeatingOptimal2(int arr[]) {
        int n = arr.length;
        int xr = 0;

         //Step 1: Find XOR of all elements:
        for (int i = 0; i < n; i++) {
            xr = xr ^ a[i];
            xr = xr ^ (i + 1);
        }

        //Step 2: Find the differentiating bit number:
        int number = (xr & ~(xr - 1));

        //Step 3: Group the numbers:
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            //part of 1 group:
            if ((a[i] & number) != 0) {
                one = one ^ a[i];
            }
            //part of 0 group:
            else {
                zero = zero ^ a[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            //part of 1 group:
            if ((i & number) != 0) {
                one = one ^ i;
            }
            //part of 0 group:
            else {
                zero = zero ^ i;
            }
        }

        // Last step: Identify the numbers:
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == zero) cnt++;
        }

        if (cnt == 2) return new int[] {zero, one};
        return new int[] {one, zero};
    }
    public static void main(String[] args) {  
        int arr[] = {3,1,2,5,3};
        
        int ans[] = missingRepeatingOptimal(arr);
        
        for(int i : ans) {
            System.out.print(i + " ");
        }
    }
}