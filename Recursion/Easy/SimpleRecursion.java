import java.util.ArrayList;

public class SimpleRecursion {
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Using two pointers
    public static void reverse(int arr[], int first, int last) {
        if(first > last) {
            return;
        }
        swap(arr, first, last);

        reverse(arr, first+1, last-1);
    }

    //  Using single variable
    public static void reverse(int arr[], int i) {
        if(i >= arr.length/2) {
            return;
        }
        swap(arr, i, arr.length-i-1);

        reverse(arr, i+1);
    }

    // Check Palindrome

    public static boolean isPalindrome(String str, int i) {
        if(i == str.length()/2) {
            return true;
        }
        
        if(str.charAt(i) != str.charAt(str.length()-i-1)) {
            return false;
        }
        return isPalindrome(str, i+1);
    }

    // Nth fibonacci
    public static int fib(int n) {
        if(n==0 || n==1) {
            return n;
        }

        int last = fib(n-1);
        int secLast = fib(n-2);

        return last + secLast;
    }

    // Print all subsecquence of an array

    public static void printSubsec(int arr[], int idx,  ArrayList<Integer> list) {
        if(idx == arr.length) {
            if(list.size() == 0) {
                System.out.println("{}");
            }
            else {
                System.out.println(list);
            }
            return;
        }
        
        // Step 1 : adding
        list.add(arr[idx]);
        printSubsec(arr, idx+1, list);
        list.remove(list.size()-1);

        // Step 2 : not adding
        printSubsec(arr, idx+1, list);
    }
    public static void main(String[] args) {
        // int arr[] = {1,2,3,2,1}; 
        // reverse(arr, 0);

        // for(int i : arr) {
        //     System.out.print(i + " ");
        // }
        
        // String str = "racecar";
        // System.out.println(isPalindrome(str, 0));

        // System.out.println(fib(4));
        
        int array[] = {3,1,2};
        ArrayList<Integer> list = new ArrayList<>();
        printSubsec(array, 0, list);
    }
}
