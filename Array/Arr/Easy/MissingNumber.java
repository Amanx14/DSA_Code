import java.util.HashMap;

public class MissingNumber {
    public static int bruteForce(int arr[], int N) {
        
        for(int i=1; i<=N; i++) { // i -> 1 2 3 4 5
            int flag = 0; 
            for(int j=0; j<arr.length; j++) { //arr -> 1 2 4 5
                if(i == arr[j]) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                return i;
            }
        }
        return 0; // yeh line sirf warning avoid karne ke liye hai kabhi execute nai hota
    }

    public static int betterApproach(int arr[], int N) {

        int[] freq =  new int[N+1];

        for(int i=0; i<arr.length; i++) {
            freq[arr[i]]++;
        }

        for(int i=1; i<=N; i++) {
            if(freq[i] == 0) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,5};
        int N = 5;
        
        System.out.println(bruteForce(arr, N));
        System.out.println(betterApproach(arr, N));
    }
}