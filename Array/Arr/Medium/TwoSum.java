import java.util.HashMap;

public class TwoSum {
    public static boolean twoSum(int arr[], int target) {
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] twoSumBetter(int arr[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[2];
        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(target - arr[i])) {
                ans[1] = i;
                ans[0] = map.get(target - arr[i]);
                return ans;
            }
            map.put(arr[i], i);
        }
        
        return new int[]{-1, -1};
    }
    public static void main(String args[]) {
        int arr[] = {2,6,5,8,11};
        int target = 17;

        // System.out.println(twoSum(arr, target));
        int ans[] = twoSumBetter(arr, target);

        for(int i : ans) {
            System.out.println(i);
        }
    }
}