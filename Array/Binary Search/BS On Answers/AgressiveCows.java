import java.util.*;

public class AgressiveCows {
    public static boolean canWePlaceCows(int stalls[], int dist, int cows) {
        int countCows = 1; 
        int last = stalls[0]; //last cow

        for(int i=1; i<stalls.length; i++) {
            if(stalls[i] - last >= dist) {
                countCows++;
                last = stalls[i];
            }
            if(countCows >= cows) {
                return true;
            }
        }
        return false;
    }
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        
        int range = stalls[n-1] - stalls[0];
        for(int i=1; i<=range; i++) {
            if(canWePlaceCows(stalls, i, k)) {
                continue;
            }
            else {
                return (i-1);
            }
        }
        return range;
    }   

    public static int aggressiveCowsOptimized(int []stalls, int cows) {
        Arrays.sort(stalls);
        int n = stalls.length;
        
        int range = stalls[n-1] - stalls[0];
        int low = 1, high = range, ans = 0;

        while(low <= high) {
            int mid = low + (high-low) / 2;
            
            if(canWePlaceCows(stalls, mid, cows)) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int stalls[] = {0,3,4,7,10,9};
        int cows = 4;
        System.out.println(aggressiveCowsOptimized(stalls, cows));
    }   
}