import java.util.HashMap;

public class MajorityElement {
    public static int bruteForce(int arr[]) {
        int maxCount = 0;
        int maxIdx = -1;

        for(int i=0; i<arr.length; i++) {
            int count = 1;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] == arr[i]) {
                    count++;
                }
            }
            if(count > maxCount) {
                maxCount = count;
                maxIdx = i;
            }
        }

        if(maxCount > arr.length / 2) {
            return arr[maxIdx];
        }
        else {
            return -1;
        }
    }

    public static int betterSol(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else {
                map.put(arr[i], 1);
            }
        }

        int majEle = arr.length/2;

        for(Integer i : map.keySet()) {
            if(map.get(i) > majEle) {
                return i;
            }
        }
        return -1;
    }

    public static int optimalSol(int arr[]) { //2,2,2,1,1,1,2
        int count = 1;
        int majEle = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(arr[i] == majEle) {
                count++;
            }
            else {
                count--;
            }

            if(count == 0) {
                count = 1;
                majEle = arr[i];
            }
        }

        if(count > 0) {
            return majEle;
        }
        return -1;
    }
    public static void main(String args[]) {
        int arr[] = {2,2,2,1,1,1,2};
        // System.out.println(bruteForce(arr));
        // System.out.println(betterSol(arr));

        System.out.println(optimalSol(arr));
    }
}