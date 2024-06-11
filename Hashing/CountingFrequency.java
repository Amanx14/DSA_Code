import java.util.*;

public class CountingFrequency {
    // USING Frequency Array
    public static void freqCount(int arr[]) {
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            max = Math.max(i, max);
        }

        int hash[] = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                System.out.println(i + "->" + hash[i]);
            }
        }
    }

    // USING VISITED ARRAY
    public static void freqCount2(int arr[]) {
        boolean visited[] = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == true) {
                continue;
            }

            int count = 1;
            visited[i] = true;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            System.out.println(arr[i] + "->" + count);
        }
    }

    // USING HASHMAP

    public static void freqCount3(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> mapEle : map.entrySet()) {
            System.out.println(mapEle.getKey() + "->" + mapEle.getValue());
        }
    }

    // MIN_MAX Frequency of an Element

    public static void minMaxFreq(int arr[]) {
        boolean visited[] = new boolean[arr.length];

        int minFreq = Integer.MAX_VALUE, maxFreq = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(visited[i] == true) {
                continue;
            } 

            int count = 1;
            visited[i] = true;

            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] == arr[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            minFreq = Math.min(count, minFreq);
            maxFreq = Math.max(count, maxFreq);
        }

        System.out.println("MinFreq " + minFreq);
        System.out.println("MaxFreq " + maxFreq);
    }

    // USING HASHMAP
    public static void minMaxFreq2(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {

            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }   
            else {
               map.put(arr[i], 1); 
            }
        }

        int minEle = Integer.MAX_VALUE, minFreq = Integer.MAX_VALUE;
        int maxEle = Integer.MIN_VALUE, maxFreq = Integer.MIN_VALUE;

        for(Map.Entry<Integer, Integer> mapEle : map.entrySet()) {
            int count = mapEle.getValue();
            int key = mapEle.getKey();

            if(count > maxFreq) {
                maxFreq = count;
                maxEle = key;
            }

            if(count < minFreq) {
                minFreq = count;
                minEle = key;
            }
        }

        System.out.println(minEle +"->" + minFreq);
        System.out.println(maxEle +"->" + maxFreq);
              
    }

    public static void main(String args[]) {
        int arr[] = { 10, 15, 10, 15, 10, 10, 2 };

        // freqCount(arr);
        // freqCount2(arr);
        // freqCount3(arr);
        // minMaxFreq(arr);
        minMaxFreq2(arr);
    }
}