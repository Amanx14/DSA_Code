import java.util.*;

public class MajorityElement2 {
    public static List<Integer> majorityElement(int arr[], int n) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(result.size() == 0 || result.get(result.size()-1) != arr[i]) {
                int count = 1;
                for(int j=i+1; j<n; j++) {
                    if(arr[j] == arr[i]) {
                        count++;
                    }
                }

                if(count > n/3) {
                    result.add(arr[i]);
                }
            }

            if(result.size() == 2) {
                break; // 2 se jada majority ele allowed nai hai
            }
        }

        return result; 
    }

    public static List<Integer> majorityElementBetter(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int majEle = nums.length / 3;

        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }   

        List<Integer> ans = new ArrayList<>();

        for(Map.Entry<Integer, Integer> mapEle : map.entrySet()) {
            if(mapEle.getValue() > majEle) {
                ans.add(mapEle.getKey());
            } 

            if(ans.size() == 2) {
                break;
            }
        }

        return ans;
    }

    public static List<Integer> majElementOptimized(int arr[]) {
        int count1 = 0;
        int count2 = 0;

        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            if(count1 == 0 && arr[i] != ele2) {
                count1++;
                ele1 = arr[i];
            }
            else if(count2 == 0 && arr[i] != ele1) {
                count2++;
                ele2 = arr[i];
            }
            else if(arr[i] == ele1) {
                count1++;
            }
            else if(arr[i] == ele2) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        List<Integer> ans = new ArrayList<>();

        count1 = 0; count2 = 0;

        for(int i :  arr) {
            if(i == ele1) {
                count1++;
            }
            if(i == ele2) {
                count2++;
            }
        }

        if(count1 > arr.length / 3) {
            ans.add(ele1);
        }
        if(count2 > arr.length/3) {
            ans.add(ele2);
        }

        return ans;
    }
    public static void main(String args[]) {
        int arr[] = {11, 33, 33, 11, 33, 11};
        // List<Integer> ans = majorityElement(arr, 6);
        List<Integer> ans = majElementOptimized(arr);

        System.out.println(ans);
    }
}