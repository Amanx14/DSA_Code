import java.util.*;

public class MaxMinFreq {
    public static void countFreq(int arr[]) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int maxIdx = -1 , minIdx = -1;
        boolean visited[] = new boolean[arr.length];

        for(int i=0; i<arr.length; i++) {
            if(visited[i] == true) {
                continue;
            }

            int count = 1;
            visited[i] = true;

            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            if(count > max) {
                max = count;
                maxIdx = i;
            } 
            if(count < min) {
                min = count;
                minIdx = i;
            }
        }
        System.out.println("Max = " + arr[maxIdx]);
        System.out.println("Min = " + arr[minIdx]);
    }

    public static void countFreqOptimized(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else {
                map.put(arr[i], 1);
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int maxIdx = -1 , minIdx = -1;

        Set<Integer> key = map.keySet();

        for(Integer i : key) {
            if(map.get(i) > max) {
                max = map.get(i);
                maxIdx = i;
            }
            if(map.get(i) < min) {
                min = map.get(i);
                minIdx = i;
            }
        }

        System.out.println("Max = " + maxIdx);
        System.out.println("Min = " + minIdx);
    }
    
    public static void main(String[] args) {
        int arr[] = {10,5,10,15,10,5};
        // countFreq(arr);
        countFreqOptimized(arr);
    }
}