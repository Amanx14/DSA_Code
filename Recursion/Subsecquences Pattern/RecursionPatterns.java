import java.util.*;

public class RecursionPatterns {
    // Condition based recursion
    public static void subSequenceHelper(int arr[], int idx, List<Integer> ans, int sum, int target) {

        if(idx == arr.length) {
            if(sum == target) {
                System.out.println(ans);
            }
            return;
        }

        // Taking
        ans.add(arr[idx]);
        sum += arr[idx];
        subSequenceHelper(arr, idx+1, ans, sum, target);
        ans.remove(ans.size()-1);
        sum -= arr[idx];

        // Not taking
        subSequenceHelper(arr, idx+1, ans, sum, target);
    }
    public static void subSequence(int arr[], int target) {
        List<Integer> ans = new ArrayList<>();

        subSequenceHelper(arr, 0, ans, 0,target);
    }

    // Technique to print only one answer
    public static boolean subSeqHelper(int arr[], int idx, List<Integer> ans, int sum, int target) {
        if(idx == arr.length) {
            if(sum == target) {
                System.out.println(ans);
                return true;
            }
            return false;
        }

        // taking
        ans.add(arr[idx]);
        sum += arr[idx];

        if(subSeqHelper(arr, idx+1, ans, sum, target) == true) {
            return true;
        }

        ans.remove(ans.size()-1);
        sum -= arr[idx];

        // not taking

        if(subSeqHelper(arr, idx+1, ans, sum, target) == true) {
            return true;
        }
        return false;
    }

    public static void printOneSubsec(int arr[], int target) {
        List<Integer> ans = new ArrayList<>();
        subSeqHelper(arr, 0, ans, 0, 3);
    }

    // Technique to find any count or number of ways using recursion
    public static int count(int arr[], int idx, int sum, int target) {
        if(idx == arr.length) {
            if(sum == target) {
                return 1;
            }
            else 
                return 0;
        }

        //taking

        sum += arr[idx];

        int l = count(arr, idx+1, sum, target); 

        sum -= arr[idx];

        // not taking
        int r = count(arr, idx+1, sum, target);

        return l + r;
    }
    public static int countSubSecqSumEqualsK(int arr[], int target) {
        return count(arr, 0, 0, target);
    }
    
    public static void main(String args[]) {
        int arr[] = {2,0,1};
        // subSequence(arr, 3);
        // printOneSubsec(arr, 3);
        System.out.println(countSubSecqSumEqualsK(arr, 3));
       
    }
}