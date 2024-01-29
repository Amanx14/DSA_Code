import java.util.*;

public class SingleNonDuplicate {

    public static int singleNonDuplicateBrute(List<Integer> arr){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.size(); i++) {
            if(map.containsKey(arr.get(i))) {
                map.put(arr.get(i), map.get(arr.get(i)) + 1);
            }
            else {
                map.put(arr.get(i), 1);
            }
        } 

        for(Integer i : map.keySet()) {
            if(map.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        if(nums[0] != nums[1]) {
            return nums[0];
        }
        if(nums[n-1] != nums[n-2]) {
            return nums[n-1];
        }

        int low = 1, high = n - 2;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }
            //even, odd
            else if(mid % 2 == 1 && nums[mid-1] == nums[mid] || 
                mid % 2 == 0 && nums[mid + 1] == nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1; // dummy return
    }
    public static void main(String args[]) {
        int arr[] = {1,1,2,2,3,3,4,5,5,6,6};
        // List al = Arrays.asList(arr);

        // System.out.println(al);
        System.out.println(singleNonDuplicate(arr));
    }
}