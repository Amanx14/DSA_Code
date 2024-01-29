import java.util.*;

public class BookAllocation {
        public static int countStud(ArrayList<Integer> arr, int pages) {
            int studCount = 1; int pagesStudHave = 0;
    
            for(int i=0; i<arr.size(); i++) {
                if(pagesStudHave + arr.get(i) <= pages) {
                    pagesStudHave += arr.get(i);
                }
                else {
                    studCount++;
                    pagesStudHave = arr.get(i);
                }
            }
            return studCount;
        }
        public static int findPages(ArrayList<Integer> arr, int n, int m) {
            if(m > n) {
                return -1;
            }
    
            int maxi = Integer.MIN_VALUE;
            int sumArr = 0;
    
            for(int i=0; i<n; i++) {
                maxi = Math.max(maxi, arr.get(i));
                sumArr += arr.get(i);
            }
    
            int low = maxi, high = sumArr;
            // int ans = 0;
    
            while(low <= high) {
                int mid = low + (high-low) / 2;
                int studCount = countStud(arr, mid);
    
                if(studCount <= m) {
                    // ans = mid;
                    high = mid - 1;
                }
                else {  
                    low = mid + 1;
                }
            }
            // return ans;
            return low;
        }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int n = 5, m = 4;
        
        System.out.println(findPages(arr, n, m));
    }   
}