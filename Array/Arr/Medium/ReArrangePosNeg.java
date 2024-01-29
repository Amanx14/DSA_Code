import java.util.ArrayList;
import java.util.Collections;

public class ReArrangePosNeg {
    public static void reArrange(int arr[]) {
        int n = arr.length ;
        int temp[] = new int[n];
        int j = 0; // pos idx
        int k = 1; // neg idx
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > 0) {
                temp[j] = arr[i];
                j+=2;
            }
            else {
                temp[k] = arr[i];
                k+=2;        
            }
        }

        for(int i=0; i<arr.length; i++) {
            arr[i] = temp[i];
        }
    }

    public static ArrayList<Integer> optimal(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));

        int posIdx = 0, negIdx = 1;

        for(int i=0; i<n; i++) {
            if(arr[i] > 0) {
                ans.set(posIdx, arr[i]);
                posIdx += 2; 
            }
            else {
                ans.set(negIdx, arr[i]);
                negIdx += 2;
            }
        }

        return ans;
    }
    public static void main(String args[]) {
        int arr[] = {1,2,-3,-1,-2,3};
        // reArrange(arr);
        ArrayList<Integer> ans = optimal(arr);

        for(Integer i : ans) {
            System.out.print(i + " ");
        }
    }
}