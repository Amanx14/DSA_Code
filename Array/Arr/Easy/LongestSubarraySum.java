public class LongestSubarraySum {
    public static int bruteForce (int arr[], int K) {
        int maxLength = 0;

        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int sum = 0;
                for(int k=i; k<=j; k++) {
                    sum += arr[k];
                }
                if(sum == K) {
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }

    public static int naiveApproach(int arr[], int k) {
        int maxLength = 0;
        
        for(int i=0; i<arr.length; i++) {
            int sum = 0;
            for(int j=i; j<arr.length; j++) {
                
                sum += arr[j];
                
                if(sum == k) {
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }

    public static int OptimalApproach(int a[], int k) {
        int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }
    public static void main(String args[]) {
        int arr[] = {2,3,5,1,9};
        int K=10;
        System.out.println(bruteForce(arr, K));   
        System.out.println(naiveApproach(arr, K));
        System.out.println(OptimalApproach(arr, K));
    }
}