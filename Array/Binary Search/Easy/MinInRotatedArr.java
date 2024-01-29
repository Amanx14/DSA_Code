public class MinInRotatedArr {
    public static int minRotatedArr(int arr[]) {
        int ans = Integer.MAX_VALUE;
        int start = 0, end = arr.length-1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[start] <= arr[mid]) {
                ans = Math.min(ans, arr[start]);
                start = mid + 1;
            }
            else {
                ans = Math.max(ans, arr[mid]);
                end = mid - 1;
            }
        }

        return ans;
    }
    public static void main(String args[]) {
        int arr[] = {4,5,6,7,0,1,2,3};
        System.out.println(minRotatedArr(arr));
    }
}