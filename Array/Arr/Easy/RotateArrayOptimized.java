public class RotateArrayOptimized {
    public static void reverse(int arr[], int start, int end) {
    
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void rotate(int arr[], int n, int k) {
        k = k % n; // in case k jada ho n se

        reverse(arr, 0, n-k-1); // first n-k elements reverse -> 5 4 3 2 1
        reverse(arr, n-k, n-1); // reverse last K elements -> 7 6
        reverse(arr, 0, n-1); // -> 6 7 1 2 3 4 5
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int k = 2;

        rotate(arr, arr.length, k);

        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
