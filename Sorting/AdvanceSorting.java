public class AdvanceSorting {
    // Merge Sort
    public static void merge(int arr[], int left, int mid, int right) {
        int mergedArr[] = new int[right - left + 1];
        int x = 0; // merged array index

        int idx1 = left;
        int idx2 = mid+1;

        while(idx1 <= mid && idx2 <= right) {
            if(arr[idx1] <= arr[idx2]) {
                mergedArr[x] = arr[idx1];
                x++; idx1++;
            }
            else {
                mergedArr[x] = arr[idx2];
                x++; idx2++;
            }
        }

        while(idx1 <= mid) {
            mergedArr[x] = arr[idx1];
            x++; idx1++;
        }

        while(idx2 <= right) {
            mergedArr[x] = arr[idx2];
            x++; idx2++;
        }

        for(int i=left; i<=right; i++) {
            arr[i] = mergedArr[i-left];
        }
    }

    public static void mergeSort(int arr[], int left, int right) {
        // Base Case
        if(left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);

        merge(arr, left, mid, right);
    }

    // Quick Sort

    public static int partiton(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low-1;

        for(int j=low; j<high; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[high];
        arr[high] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void quickSort(int arr[], int low, int high) {
        // base case
        if(low >= high) {
            return;
        } 

        int pIdx = partiton(arr, low, high);

        quickSort(arr, low, pIdx-1);
        quickSort(arr, pIdx+1, high);
    }

    public static void recBubbleSort(int arr[], int n) {
        if (n == 0) {
            return;
        }

        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        recBubbleSort(arr, n - 1);
    }

    public static void recInsertionSort(int arr[], int i, int n) {
        if(i == n) {
            return;
        }

        int temp = arr[i];
        int j=i-1;

        while(j>=0 && arr[j] >= temp) {
            arr[j+1] = arr[j];
            j--;
        }

        arr[j+1] = temp;

        recInsertionSort(arr, i+1, n);
    }
    public static void main(String args[]) {
        int arr[] = {11, 2, 1, 12, 5, 3, 4, 7};

        // mergeSort(arr, 0, arr.length-1);
        // quickSort(arr, 0, arr.length-1);
        // recBubbleSort(arr, arr.length);
        // recInsertionSort(arr, 1, arr.length);

        for(int i : arr) {
            System.out.print(i + " ");
        }

    }
}