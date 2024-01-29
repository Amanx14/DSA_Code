public class LeftRotateByOne {

    public static void leftRotate(int arr[]) {
        int temp = arr[0];
        for(int i=0; i<arr.length;i++) {
            if(i < arr.length-1) {
                arr[i] = arr[i+1];
            }
            else {
                arr[i] = temp;
            }
        }
    }

    public static void leftRotateByK(int arr[], int K, int n) { // 1,2,3,4,5,6,7
        int temp[] = new int[K];
        
        for(int i=0; i<K; i++) {
            temp[i] = arr[i];
        }

        for(int i=0; i<n-K; i++) {
            arr[i] = arr[i+K];
        }
        for(int i=n-K; i<n; i++) {
            arr[i] = temp[i-n+K];
        }
    }

    public static void rightRotatebyK(int arr[], int K, int n) {  // 1,2,3,4,5,6,7
        
        int temp[] = new int[K]; 
        
        for(int i=n-K; i<n; i++) {
            temp[i-n+K] = arr[i];
        }

        for(int i=n-K-1; i>=0; i--) {
            arr[i+K] = arr[i];
        }

        for(int i=0; i<temp.length; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int K=2;
        // leftRotate(arr);
        leftRotateByK(arr, K, arr.length);

        // rightRotatebyK(arr, K, arr.length);

        for(int i :arr) {
            System.out.print(i + " ");
        }
    }
} 
