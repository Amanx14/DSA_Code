public class CountInversion {
    public static int countInversions(int arr[]) {
        int count = 0;

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] > arr[j] ) {
                    count++;
                }
            }
        }

        return count;
    }

// ----------------------Optimized Version of CountInversion---------------------

    public static int merge(int arr[], int si, int mid, int ei) {
        int merged[] = new int[ei - si + 1];
        int x = 0; //merged idx

        int idx1 = si; //left
        int idx2 = mid+1; //right

        int count = 0;

        while(idx1 <= mid && idx2 <= ei) {
            if(arr[idx1] <= arr[idx2]) {
                merged[x] = arr[idx1];
                x++; idx1++;
            }
            else {
                //right is smaller
                merged[x] = arr[idx2];
                count += (mid - idx1 + 1); // --- 
                x++; idx2++;
            }
        }

        while(idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }
        
        while(idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        for(int i=0, j=si; i<merged.length; j++,i++) {
            arr[j] = merged[i];
        }
        
        return count;
    }
    public static int mergeSort(int arr[], int left, int right) {
        int count = 0;
        if(left >= right) {
            return count;
        }

        int mid = (left + right) / 2;

        count += mergeSort(arr, left, mid);
        count += mergeSort(arr, mid+1, right);

        count += merge(arr, left, mid, right);

        return count;
    }

    public static int countInversionOptimized(int arr[]) {
        return mergeSort(arr, 0, arr.length-1);
    }
    public static void main(String args[]) {
        int arr[] = {5,3,2,4,1};
        // System.out.println(countInversions(arr));

        System.out.println(countInversionOptimized(arr));
    }
}