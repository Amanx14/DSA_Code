import java.util.HashMap;

public class LongestSubArrNegative {
    public static int longgestSubarrNegatives(int arr[], int k) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        int maxLength = 0;
        int sum = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];

            if(sum == k) { // if pehle hi koi match ho jaye toh
                maxLength = Math.max(maxLength, i+1);
            }

            int rem = sum - k;

            if(prefixSumMap.containsKey(rem)) {
                int len = i - prefixSumMap.get(rem);
                maxLength = Math.max(maxLength, len);
            }

            if(!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }
        return maxLength;
    }
    public static void main(String args[]) {
        int arr[] = {1,-1,1};
        int k = 1;

        System.out.println(longgestSubarrNegatives(arr, k));
    }
}