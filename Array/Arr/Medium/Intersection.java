import java.util.*;

public class Intersection {
    // Brute Force
    public static int[] intersection(int arr1[], int arr2[]) {
        
        int n1 = arr1.length;
        int n2 = arr2.length;

        List<Integer> ans = new ArrayList<>();
        int visited[] = new int[n2];
        Arrays.fill(visited, 0);

        for(int i=0; i<n1; i++) {
            for(int j=0; j<n2; j++) {
                if(arr1[i] == arr2[j] && visited[j] == 0) {
                    ans.add(arr1[i]);
                    visited[j] = 1;
                    break;
                }

                if(arr2[j] > arr1[i]) {
                    break;
                }
            }

        }

        int result[] = new int[ans.size()];

        for(int i=0; i<result.length; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    // Optimized 

    public static int[] optimizedIntersection(int arr1[], int arr2[]) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0;
        int j = 0;  

        Set<Integer> ans = new HashSet<>();

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] == arr2[j]) {
                ans.add(arr1[i]);
                i++;
                j++;
            }
            else if(arr1[i] < arr2[j]) {
                i++;
            }
            else {
                j++;
            }
        }

        int result[] = new int[ans.size()];

        int k=0;
        for(Integer s : ans) {
            result[k] = s;
            k++;
        }

        return result;
    }
    public static void main(String args[]) {
        int arr1[] = {1, 2, 2, 3, 5};
        int arr2[] = {1, 2, 7};

        int ans[] = optimizedIntersection(arr1, arr2);

        System.out.println(Arrays.toString(ans));
    }
}