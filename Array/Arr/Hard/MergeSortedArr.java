import java.util.*;

public class MergeSortedArr {
    public static void print(int arr[]) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void mergeSortedBetter(int arr1[], int arr2[]) {
        int i=arr1.length-1;
        int j=0;

        while(i>=0 && j<arr2.length) {
            if(arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] =  temp;
                i--; j++;
            } else {
                break;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    public static void main(String args[]) {
        int arr1[] = {1,4,8,10};
        int arr2[] = {2,3,9};

        mergeSortedBetter(arr1, arr2);

        for(int i : arr1) {
            System.out.print(i + " ");
        }

        for(int i : arr2) {
            System.out.print(i + " ");
        }
    }
}