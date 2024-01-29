public class AdvanceSorting {
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si-1;

        for(int j=si; j<ei; j++) {
            if(arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }
    public static void quickSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }

        int pIdx = partition(arr, si, ei); // partiton idx

        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx+1, ei);
    }
    
    public static void merge(int arr[], int start, int mid, int end) {
        int merged[] = new int[end -  start + 1]; // dono k merge karna hai
        int idx = 0; // merged Idx

        int i=start, j=mid+1;

        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                merged[idx] = arr[i];
                idx++; i++;
            }
            else {
                merged[idx] = arr[j];
                idx++; j++;
            }
        }

        while(i <= mid){
            merged[idx] = arr[i];
            idx++; i++;
        }
        
        while(j <= end) {
            merged[idx] = arr[j];
            idx++; j++;
        }

        for(idx=0, i=start; idx<merged.length; idx++, i++) {
            arr[i] = merged[idx]; 
        }
    }
    public static void mergeSort(int arr[], int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = start + (end-start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    public static void bubbleSortRec(int arr[], int i, int n) {
        if(i==n) {
            return;
        }

        for(int j=0; j<n; j++) {
            if(arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }

        bubbleSortRec(arr, i+1, n);
    }

    public static void insertionSort(int arr[], int i, int n) {
        if(i==n) {
            return;
        }
        
        int temp = arr[i];
        int j=i-1;

        while(j>=0 && arr[j] > temp) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = temp;    

        insertionSort(arr, i+1, n);
    }
    public static void main(String[] args) {
        int arr[] = {13,46,24,52,20,9};
        // mergeSort(arr, 0, arr.length-1);
        // bubbleSortRec(arr, 0, arr.length-1);
        // insertionSort(arr, 1, arr.length);
        quickSort(arr, 0, arr.length-1);

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
