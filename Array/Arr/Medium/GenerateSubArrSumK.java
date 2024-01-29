import java.util.*;

public class GenerateSubArrSumK {
    public static List<List<Integer>> subarraysWithSumK(int []arr, long k) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            int sum = 0;
            List<Integer> temp = new ArrayList<>();

            for(int j=i; j<arr.length; j++) {
                sum += arr[j];
                temp.add(arr[j]);

                if(sum == k) {
                    ans.add(new ArrayList<>(temp));
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,1,1};

        System.out.println(subarraysWithSumK(arr, 3));
    }   

} 