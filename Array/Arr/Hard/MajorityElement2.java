import java.util.*;

public class MajorityElement2 {
    public static ArrayList<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0; //{1,2,2,3,2};

        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            if(count1 == 0 && nums[i] != ele2) {
                count1 = 1;
                ele1 = nums[i];
            } 
            else if(count2 == 0 && nums[i] != ele1) {
                count2 = 1;
                ele2 = nums[i];
            }
            else if(nums[i] == ele1) {
                count1++;
            }
            else if(nums[i] == ele2) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        count1 = 0; count2 = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == ele1) {
                count1++;
            }
            if(nums[i] == ele2) {
                count2++;
            }
        }

        if(count1 > nums.length / 3) {
            ans.add(ele1);
        }
        if(count2 > nums.length / 3) {
            ans.add(ele2);
        }

        return ans;
    }
    public static void main(String args[]) {
        int arr[] = {1,2,2,3,2};
        ArrayList<Integer> ans = majorityElement(arr);
        System.out.println(ans);
    }
}