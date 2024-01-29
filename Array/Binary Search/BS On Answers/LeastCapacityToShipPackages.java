public class LeastCapacityToShipPackages {
    public static int findReqDays(int wt[], int cap) {
        int days = 1; int load = 0;

        for(int i=0; i<wt.length; i++) {
            
            if(load + wt[i] <= cap) {
                load += wt[i];
            }
            else {
                days = days + 1;
                load = wt[i];
            }
        }
        return days;
    }
    public static int shipWithinDays(int wt[], int days) {
        int maxi = Integer.MIN_VALUE;
        int sumArr = 0;
        // for finding capacity range
        for(int i=0; i<wt.length; i++) {
            sumArr += wt[i];
            maxi = Math.max(wt[i], maxi);
        }

        for(int i=maxi; i<=sumArr; i++) {
            int reqDays = findReqDays(wt, i);
            if(reqDays <= days) {
                return i;
            }
        }

        return 0;
    }

    public static int shipWithinDaysOptimized(int[] weights, int days) {
        int maxi = Integer.MIN_VALUE;
        int sumArr = 0;

        // finding the range
        for(int i=0; i<weights.length; i++) {
            sumArr += weights[i];
            maxi = Math.max(maxi, weights[i]);
        }

        int low = maxi, high = sumArr;
        int ans = 0;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int reqDays = findReqDays(weights, mid);

            if(reqDays <= days) {
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
        int wt[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        System.out.println(shipWithinDaysOptimized(wt, days));
    }
}