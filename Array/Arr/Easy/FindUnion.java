import java.util.*;

public class FindUnion {

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> Union = new ArrayList<>();

        for(int i=0; i<arr1.length; i++) {
            map.put(arr1[i], i);
        }

        for(int i=0; i<arr2.length; i++) {
            map.put(arr2[i], i);
        }
        
        Set<Integer> key = map.keySet();

        for(Integer i : key) {
            Union.add(i);
        }

        return Union;
    }

    public static ArrayList<Integer> findUnionOptimized(int arr1[], int arr2[], int n, int m) {
        int i=0, j=0;
        ArrayList<Integer> Union = new ArrayList<>();
        
        while(i<n && j<m) {
            if(arr1[i] <= arr2[j]) {
                if(Union.size() == 0 || Union.get(Union.size()-1) != arr1[i]) {
                    // Union.get(Union.size()-1) != arr1[i]) =>  dublicate check
                    Union.add(arr1[i]);
                }
                i++;
            }
            else {
                if(Union.size() == 0 || Union.get(Union.size()-1) != arr2[j]) {
                    Union.add(arr2[j]);
                }
                j++;
            }
        }

        while(i<n) {
            if(Union.size() == 0 || Union.get(Union.size()-1) != arr1[i]) {
                Union.add(arr1[i]);
            }
            i++;
        }

        while(j<m) {
            if(Union.size() == 0 || Union.get(Union.size()-1) != arr2[j]) {
                Union.add(arr2[j]);
            }
            j++;
        }

        return Union;
    }
    public static void main(String args[]) {
        
        int arr1[] = {1,2,3,4,5,6,7,8,9,10};
        int arr2[] = {2,3,4,4,5,11,12};

        // System.out.println(linearSearch(arr1, 3));
        
        ArrayList<Integer> ans = findUnionOptimized(arr1, arr2, arr1.length, arr2.length);

        for(Integer i : ans) {
            System.out.print(i + " ");
        } 
    }
}