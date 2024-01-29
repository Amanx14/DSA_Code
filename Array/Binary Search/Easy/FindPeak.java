public class FindPeak {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;

        if(n==1) {
            return 0;
        }

        if(nums[0] > nums[1]) {
            return 0;
        }
        if(nums[n-1] > nums[n-2]) {
            return n-1;
        }

        for(int i=1; i<n-1; i++) {
            if(nums[i-1] < nums[i] && nums[i+1] < nums[i]) {
                return i;
            }
        }

        return -1;
    }

    public static int findPeakElementOptimal(int[] nums) {
        int n = nums.length;
        //Edge Cases
        if(n==1) {
            return 0;
        }
        if(nums[0] > nums[1]) {
            return 0;
        }
        if(nums[n-1] > nums[n-2]) {
            return n-1;
        }

        int low = 1, high = n-2;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            else if(nums[mid] > nums[mid-1]) {
                low = mid + 1;
            }
            else {
                high = mid  - 1;
            }
        }

        return -1;
    }
    public static void main(String args[]) {
        int arr[] = {1,2,3,4,5,6,7,8,5,1};
        System.out.println(findPeakElementOptimal(arr));
    }
}