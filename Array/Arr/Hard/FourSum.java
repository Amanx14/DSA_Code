import java.util.*;

public class FourSum {
    public static ArrayList<ArrayList<Integer>> fourSumBrute(int arr[], int target) {
        HashSet<ArrayList<Integer>> set = new HashSet<>();

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                for(int k=j+1; k<arr.length; k++) {
                    for(int l=k+1; l<arr.length; l++) {

                        int sum = arr[i] + arr[j] + arr[k] + arr[l];
                        if(sum == target) {
                            ArrayList<Integer> ans = new ArrayList<>();
                            ans.add(arr[i]);
                            ans.add(arr[j]);
                            ans.add(arr[k]);
                            ans.add(arr[l]);
                            Collections.sort(ans);
                            set.add(ans);
                        }
                    }
                    
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static ArrayList<ArrayList<Integer>> fourSumBetter(int arr[], int target) {
        int n = arr.length;
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {

                HashSet<Long> hashSet = new HashSet<>();

                for(int k=j+1; k<n; k++) {
                    long sum = arr[i] + arr[j] + arr[k];
                    long forth = target - sum;
                    if(hashSet.contains(forth)) {
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(arr[i]);
                        ans.add(arr[j]);
                        ans.add(arr[k]);
                        ans.add((int)forth);
                        
                        set.add(ans);
                    }

                    hashSet.add((long)arr[k]);
                }

            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> fourSumOptimized(int []nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue; // duplicate skip

            for(int j=i+1; j<nums.length; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue; //duplicate skip

                int left = j+1;
                int right = nums.length-1;

                while(left < right) {
                    List<Integer> ans = new ArrayList<>();
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[left];
                    sum += nums[right];

                    if(sum == target) {
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[left]);
                        ans.add(nums[right]);
                        result.add(ans);

                        left++;
                        right--;

                        while(left < right && nums[left] == nums[left-1]) left++; //duplicate skip
                        while(left < right && nums[right] == nums[right+1]) right--; //duplicate skip
                    }
                    else if(sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int arr[] = {1,0,-1,0,-2,2}, target = 0;
        // ArrayList<ArrayList<Integer>> list = fourSumBrute(arr, target);

        // ArrayList<ArrayList<Integer>> list2 = fourSumBetter(arr, target);
        
        List<List<Integer>> ans = fourSumOptimized(arr, target);
        System.out.println(ans);
    }
}