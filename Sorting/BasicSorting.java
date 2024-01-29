public class BasicSorting {

    public static void selectionSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            int minimum = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[minimum] >= arr[j]) {
                    minimum = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minimum];
            arr[minimum] = temp;

        }
    }

    public static void bubbleSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int arr[]) {
        for(int i=1; i<arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while(j>=0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
    public static void main(String[] args) {
        int arr[] = {13,46,24,52,20,9};
        // selectionSort(arr);
        // bubbleSort(arr);
        insertionSort(arr);

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
