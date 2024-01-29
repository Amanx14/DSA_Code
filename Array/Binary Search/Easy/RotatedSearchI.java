public class RotatedSearchI {
    public static int rotatedSearchRec(int nums[], int target, int start, int end) {

        if(start > end) {
            return -1;
        }
    
        while(start <= end) {
            int mid = start + (end - start) / 2; 

            if(nums[mid] == target) {
                return mid;
            }
            else {
                if(nums[start] <= nums[mid]) {
                    if(target >= nums[start] && target <= nums[mid]) {
                        return rotatedSearchRec(nums, target, start, mid-1);
                    }
                    else {
                        return rotatedSearchRec(nums, target, mid+1, end);
                    }
                }
                else {
                    if(target >= nums[mid] && target <= nums[end]) {
                        return rotatedSearchRec(nums, target, mid+1, end);
                    }
                    else {
                        return rotatedSearchRec(nums, target, start, mid-1);
                    }
                }
            }
        }
        return -1;
    }

    public static int rotatedSearch(int nums[], int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else {
                if(nums[start] <= nums[mid]) {
                    if(nums[start] <= target && target <= nums[mid]) {
                        end = mid - 1;
                    }
                    else {
                        start = mid + 1;
                    }
                }
                else {
                    if(nums[mid] <= target && target <= nums[end]) {
                        start = mid + 1;
                    }
                    else {
                        end = mid - 1;
                    }
                }
            }
        }   
        return -1;
    }
    public static void main(String args[]) {
        int arr[] = {4,5,6,7,0,1,2,3}, target = 6;
        System.out.println(rotatedSearchRec(arr, target, 0, arr.length-1));
        System.out.println(rotatedSearch(arr, target));

    }
}