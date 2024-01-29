public class KokoEatingBananas {
    public static int maxBananas(int piles[]) {
        int maxi = Integer.MIN_VALUE;

        for(int i=0; i<piles.length; i++) {
            if(piles[i] > maxi) {
                maxi = piles[i];
            }
        }

        return maxi;
    }
    public static int findTotalHours(int arr[], int hourly) {
        int totalHours = 0;

        for(int i=0; i<arr.length; i++) {
            totalHours += Math.ceil((double)(arr[i]) / (double)(hourly));
        }

        return totalHours;
    }

    public static int minEatingSpeedBrute(int []piles, int h) {
        int maxPiles = maxBananas(piles);

        for(int i=1; i<=maxPiles; i++) {
            int totalHrs = findTotalHours(piles, i);
            if(totalHrs <= h) {
                return i;
            }
        }

        return maxPiles;
    }
    public static int minEatingSpeed(int[] piles, int h) {
        
        int maxPiles = maxBananas(piles);
        int low = 1, high = maxPiles;
        int ans = 0;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int totalHrs = findTotalHours(piles, mid);

            if(totalHrs <= h) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int N = 4, a[] = {7, 15, 6, 3}, h = 8;
        System.out.println(minEatingSpeedBrute(a, h));
        System.out.println(minEatingSpeed(a, h));
    }
}