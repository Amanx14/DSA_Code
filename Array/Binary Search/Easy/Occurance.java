import java.util.*;

public class Occurance {
    public static int[] findPos(int arr[], int target) {
        int n = arr.length;
        int firstOccur = -1, lastOccur = -1;

        int ans[] = new int[2];

        Arrays.fill(ans, -1);

        for(int i=0; i<n; i++) {
            if(firstOccur == -1 && arr[i] == target) {
                firstOccur = i;
            }
            if(lastOccur == -1 && arr[n-i-1] == target) {
                lastOccur = n-i-1;
            }
        }
        
        ans[0] = firstOccur;
        ans[1] = lastOccur;
        
        return ans;
    }

    // -----------------------Optimized approach works only for sorted array--------------------
    public static int lastOccur(int nums[], int target) {
        int start = 0;
        int end = nums.length-1;

        int posIdx = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) {
                posIdx = mid;
                start = mid+1;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return posIdx;
    }

    public static int firstOccur(int nums[], int target) {
        int start = 0;
        int end = nums.length-1;

        int posIdx = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) {
                posIdx = mid;
                end = mid-1;
            }
            else if(nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return posIdx;
    }

    public static int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[1] = lastOccur(nums, target);
        ans[0] = firstOccur(nums, target);

        return ans;
    }

    public static void main(String args[]) {
        int arr[] = {5,7,7,8,8,8,8,10};
        // int ans[] = findPos(arr, 8);
        int ans2[] = searchRange(arr, 8);

        for(int i : ans2) {
            System.out.print(i + " ");
        }
    }
}