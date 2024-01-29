public class MinDaystoMakeBouket {
    public static boolean possible(int arr[], int day, int m, int k) {
        int count = 0;
        int noOfBoquets = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] <= day) {
                count++;
            }
            else {
                noOfBoquets += (count / k);
                count = 0;
            }
        }

        noOfBoquets += (count/k);

        if(noOfBoquets >= m) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int roseGarden(int arr[], int m, int k) {
        int n = arr.length;

        if(m*k > n) {
            return -1;
        }
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for(int i=0; i<n; i++)  {
            mini = Math.min(arr[i], mini);
            maxi = Math.max(arr[i], maxi);
        }

        for(int i=mini; i<=maxi; i++) {
            if(possible(arr, i, m, k) == true) {
                return i;
            }
        }

        return -1;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if(m * k > n) {
            return -1;
        }

        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            maxi = Math.max(bloomDay[i], maxi);
            mini = Math.min(bloomDay[i], mini);
        }

        int low = mini;
        int high = maxi;
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(possible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }
    public static void main(String args[]) {
        int N = 8, arr[] = {7, 7, 7, 7, 13, 11, 12, 7}, m = 2, k = 3;

        System.out.println(roseGarden(arr, m, k));
        System.out.println(minDays(arr, m, k));
    }
}