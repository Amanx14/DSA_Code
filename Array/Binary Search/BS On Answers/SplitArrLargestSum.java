import java.util.*;

class Code {
    public static int partitonCount(int nums[], int largestSum) {
        int partitions = 1; int subArrSum=0;

        for(int i=0; i<nums.length; i++) {
            if(subArrSum + nums[i] <= largestSum) {
                subArrSum += nums[i];
            }
            else {
                partitions++;
                subArrSum = nums[i];
            }
        }
        return partitions;
    }
    
    public static int splitArray(int[] nums, int k) {
        int maxi = Integer.MIN_VALUE;
        int sumArr = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > maxi) {
                maxi = nums[i];
            }

            sumArr += nums[i];
        }

        int low = maxi, high = sumArr;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int countPartition = partitonCount(nums, mid);

            if(countPartition <= k) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[] = {7,2,5,10,8}, k = 2;
        System.out.println(splitArray(arr, k));
    }
}