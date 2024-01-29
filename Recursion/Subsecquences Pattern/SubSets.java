import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubSets {
    // Subset Sum1
    public static void findSum(int nums[], int idx, int sum, ArrayList<Integer> ans) {
        if(idx == nums.length) {
            ans.add(sum);
            return;
        }

        // take 
        sum += nums[idx];
        findSum(nums, idx + 1, sum, ans);
        sum -= nums[idx];

        // not take
        findSum(nums, idx + 1, sum, ans);
    }
    public static ArrayList<Integer> subsetSum(int nums[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0;
        findSum(nums, 0, sum, ans);
        Collections.sort(ans);
        return ans;
    }

    // SubSet Sum2
    public static void subSets(int arr[], int idx, ArrayList<Integer> ds, 
	ArrayList<ArrayList<Integer>> ans) {

		// base case
		ans.add(new ArrayList<>(ds));

		for(int i=idx; i<arr.length; i++) {
            if(i > idx && arr[i] == arr[i-1]) {
                continue;
            }

            ds.add(arr[i]);
		    subSets(arr, i + 1, ds, ans);
		    ds.remove(ds.size()-1);
        }
	}
	
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

		subSets(nums, 0, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }
    public static void main(String args[]) {
        int arr[] = {1,2,3};
        ArrayList<Integer> ans= subsetSum(arr);
        System.out.println(ans);

        List<List<Integer>> result = subsetsWithDup(arr);
        System.out.println(result);
    }
}