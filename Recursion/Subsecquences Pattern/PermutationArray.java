import java.util.ArrayList;
import java.util.List;

public class PermutationArray {
    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void generatePermuation(int nums[], int idx, List<List<Integer>> ans) {
        // base case
        if(idx == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i<nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=idx; i<nums.length; i++) {
            swap(nums, i, idx);
            generatePermuation(nums, idx+1, ans);
            swap(nums, i, idx);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generatePermuation(nums, 0, ans);
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        List<List<Integer>> permutation = permute(arr);
        System.out.println(permutation);
    }
}
