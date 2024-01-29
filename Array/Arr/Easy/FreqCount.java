import java.util.*;

public class FreqCount {
    public static void countFreq(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else {
                map.put(arr[i], 1);
            }
        }

        for(Integer key : map.keySet()) {
            System.out.println(key + " occurs " + map.get(key) + " times in the array");
        }

    }

    public static void countFrequency(int arr[]) {
        boolean visited[] = new boolean[arr.length]; 

        for(int i=0; i<arr.length; i++) { // 10, 5, 10, 15, 10, 5
            
            if(visited[i] == true) {
                continue;
            }

            int count = 1;
            visited[i] = true;

            for(int j=i+1; j<arr.length; j++) {
        
                if(visited[j] == false && arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + "->" + count);
        }
    }
    public static void main(String args[]) {
        int arr[] = {10, 5, 10, 15, 10, 5};
        countFrequency(arr);
        
    }
}