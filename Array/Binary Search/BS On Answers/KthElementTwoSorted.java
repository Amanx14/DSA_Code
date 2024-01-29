import java.util.ArrayList;
import java.util.Arrays;

public class KthElementTwoSorted {
   public static int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int n1, int n2, int k) {
        if(n1 > n2) {
            return kthElement(b, a, n2, n1, k); 
        }
        
        int low = Math.max(0,k-n2), high = Math.min(k,n1);
        int left = k;
        int n = n1 + n2;

        while(low <= high) {
            int mid1 = (low + high) / 2; 
            int mid2 = left - mid1; 

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE; 
            
            if(mid1 < n1) {
                r1 = a.get(mid1);
            }
            if(mid2 < n2) {
                r2 = b.get(mid2);
            }

            if(mid1 - 1 >= 0) {
                l1 = a.get(mid1-1);
            }
            if(mid2-1 >= 0) { 
                l2 = b.get(mid2-1);
            }

            if(l1 <= r2 && l2 <= r1) {
               return Math.max(l1, l2);
            }
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1; 
            }
        }
        return 0;
    }
    public static void main(String args[]) {
       ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(2,3,6,7,9));
       ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1,4,8,10));
       int k=5;

       System.out.println(kthElement(arr1, arr2, arr1.size(), arr2.size(), k));

    }
}