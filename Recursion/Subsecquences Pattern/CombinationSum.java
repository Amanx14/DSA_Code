import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    // Combination Sum 1

    public static void findCombination(int[] arr, int idx, int target, List<Integer> ans, List<List<Integer>> result) {
        // base case
        if(idx == arr.length) {
            if(target == 0) {
                result.add(new ArrayList<>(ans));
            }
            return;
        }

        // take 
        // check ki agar minus karte karte target 0 ho gaya toh back track kar jana hai couz idx repeat kar rahe usme

        if(arr[idx] <= target) {
            ans.add(arr[idx]);
            findCombination(arr, idx, target - arr[idx], ans, result);
            ans.remove(ans.size()-1);
        }
        // not take
        findCombination(arr, idx + 1, target, ans, result);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombination(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    // Combination Sum II
    
    public static void findCombination2(int arr[], int idx, int target, List<Integer> ds, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        // take
        for(int i = idx; i<arr.length; i++) {
            if(i > idx && arr[i] == arr[i-1]) {
                continue;
            }

            if(arr[i] > target) {
                break;
            }

            ds.add(arr[i]);
            findCombination2(arr, i+1, target - arr[i], ds, ans);
            ds.remove(ds.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

        findCombination2(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    // Combination Sum III

    public static void findCombination(int start, int k, int target, List<Integer> ds, List<List<Integer>> ans){     
        // base case
        if(target == 0 && ds.size() == k) {
            ans.add(new ArrayList<>(ds));
        }

        for(int i=start; i<=9; i++) {
            if(i > target) {
                break;
            }
            ds.add(i);
            findCombination(i+1, k, target-i, ds, ans);
            ds.remove(ds.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(1, k, n, new ArrayList<>(), ans);
        return ans;
    }
    public static void main(String[] args) {
        int candidates[] = {2,3,6,7}, target = 7;
        // Combination 1
        List<List<Integer>> combination1 = combinationSum(candidates, target);
        System.out.println(combination1);

        // Combination 2
        int arr[] = {10,1,2,7,6,1,5}, target2 = 8;
        List<List<Integer>> combination2 = combinationSum2(arr, target2);
        System.out.println(combination2);

        // Combination 3
        int k = 3, n = 7;
        List<List<Integer>> combination3 = combinationSum3(k, n);
        System.out.println(combination3);
    }
}
