import java.util.*;

public class Leaders {
    public static void leaders(int arr[]) {
        ArrayList<Integer> leaders = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            int j=i+1;
            while(j < arr.length && arr[i] > arr[j]) {
                j++;
            }
            if(j == arr.length) {
                leaders.add(arr[i]);
            }
        } 
        
        System.out.println(leaders);
    }
    
    public static ArrayList<Integer> superiorElements(int []arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        int n = arr.length;
        int max = arr[n-1];

        ans.add(max);

        for(int i=n-2; i>=0; i--) {

            if(arr[i] > max) {
                ans.add(arr[i]);
                max = arr[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {4,7,1,0};
        // leaders(arr);
        ArrayList<Integer> ans = superiorElements(arr);
        System.out.println(ans);
    }
}