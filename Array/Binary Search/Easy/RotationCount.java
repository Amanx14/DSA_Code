public class RotationCount {
    public static int findMinInRotatedArr(int arr[]) {
        int ans = Integer.MAX_VALUE;
        int ansIdx = -1;

        int start = 0, end = arr.length-1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[start] <= arr[mid]) {
                if(arr[start] < ans) {
                    ans = arr[start];
                    ansIdx = start;
                }
                start = mid + 1;
            }
            else {
                if(arr[mid] < ans) {
                    ans = arr[mid];
                    ansIdx = mid;
                }
                end = mid - 1;
            }
        }

        return ansIdx;
    }
    public static int findKRotation(int []arr){
        int minIdx = findMinInRotatedArr(arr);
        int noOfRotations = minIdx - 0;
        return noOfRotations;
    }
    public static void main(String args[]) {
        int arr[] = {4,5,6,7,0,1,2,3};
        System.out.println(findKRotation(arr));
    }
}