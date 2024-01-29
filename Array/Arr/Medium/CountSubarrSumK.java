import java.util.HashMap;

public class CountSubarrSumK {
    public static int countSubarrSumK(int arr[], int K) {
        int count = 0;

        for(int i=0; i<arr.length; i++) {
            int sum = 0;
            for(int j=i; j<arr.length; j++) {
                sum += arr[j];
                if(sum == K) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int countSubarraySumK(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i=0; i<nums.length; i++) {
            prefixSum += nums[i];

            int rem = prefixSum - k; // remaining

            count += map.getOrDefault(rem, 0);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
    public static void main(String args[]) {
        int arr[] = {4,6,8,3,5,6,2,4,2,2};
        System.out.println(countSubarrSumK(arr, 8));
        System.out.println(countSubarraySumK(arr, 8));
    }
}