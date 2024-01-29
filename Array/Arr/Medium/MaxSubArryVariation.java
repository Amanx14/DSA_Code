public class MaxSubArryVariation {
    public static void printRange(int arr[], int i, int j) {
        for(int k=i; k<=j; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }
    public static int maxSubArr(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int range1 = -1;
        int range2 = -1;
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int sum = 0;
                for(int k=i; k<=j; k++) {
                    sum += arr[k];
                }
                if(sum > maxSum) {
                    maxSum = sum;
                    range1 = i;
                    range2 = j;
                }
            }
        }
        printRange(arr, range1, range2);
        return maxSum;
    }

    public static int better(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int range1 = -1;
        int range2 = -1;
        
        for(int i=0; i<arr.length; i++) {
            int sum = 0;
            for(int j=i; j<arr.length; j++) {
                sum += arr[j];
                if(sum > maxSum) {
                    maxSum = sum;
                    range1 = i;
                    range2 = j;
                }
            }
        }
        printRange(arr, range1, range2);
        return maxSum;
    }

    public static int optimalSol(int arr[]) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int range1 = -1, range2 = -1;

        for(int i=0; i<arr.length; i++) {
            if(sum == 0) { // 2,1,-3,4,-1,2,1,-5,4
                range1 = i;
            }
            sum += arr[i];
            
            if(sum > maxSum) {
                maxSum = sum;
                range2 = i;
            }

            if(sum < 0) {
                sum = 0;
            }
        }
        printRange(arr, range1, range2);
        return maxSum;
    }
    public static void main(String args[]) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        // System.out.println(maxSubArr(arr));
        // System.out.println(better(arr));
        System.out.println(optimalSol(arr));
    }
}