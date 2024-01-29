import java.util.*;

public class Code {
    public static int findDivisorSum(int arr[], int divisor) {
        int divSum = 0;

        for(int i=0; i<arr.length; i++) {
            divSum += Math.ceil((double)arr[i] / (double)divisor);
        }

        return divSum;
    }
    public static int smallestDivisor(int arr[], int limit) {
        int maxi = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > maxi) {
                maxi = arr[i];
            }
        }

        for(int i=1; i<=maxi; i++) {
            int divSum = findDivisorSum(arr, i);
            if(divSum <= limit) {
                return i;
            }
        }

        return 0;
    }

    public static int smallestDivisorOptimal(int[] nums, int threshold) {
        int maxi = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > maxi) {
                maxi = nums[i];
            }
        }    

        int ans = 0;
        int low = 1, high = maxi;

        while(low<=high) {
            int mid = low + (high - low) / 2;
            int divisorSum = findDivisorSum(nums, mid);
            if(divisorSum <= threshold) {
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
        // int arr[] = {1, 2, 3, 4, 5} , limit = 8;
        int arr[] = {8, 4, 2, 3}, limit = 10;
        System.out.println(smallestDivisorOptimal(arr, limit));
    }
}