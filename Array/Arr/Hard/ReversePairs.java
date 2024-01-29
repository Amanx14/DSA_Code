public class ReversePairs {
    public static int reversePair(int arr[]) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > 2 * arr[j]) {
                    count += 1;
                }
            }
        }

        return count;
    }

    public static void merge(int arr[], int low, int mid, int high) {
        int merged[] = new int[high - low + 1];
        int idx = 0; // merged Idx

        int i = low, j = mid + 1;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                merged[idx] = arr[i];
                idx++;
                i++;
            } else {
                merged[idx] = arr[j];
                idx++;
                j++;
            }
        }

        while (i <= mid) {
            merged[idx] = arr[i];
            idx++;
            i++;
        }

        while (j <= high) {
            merged[idx] = arr[j];
            idx++;
            j++;
        }

        for (idx = 0, i = low; idx < merged.length; idx++, i++) {
            arr[i] = merged[idx];
        }
    }

    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) arr[i] > 2 * (long) arr[right])
                right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid); // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += countPairs(arr, low, mid, high); // Modification
        merge(arr, low, mid, high); // merging sorted halves
        return cnt;
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String args[]) {
        int arr[] = { 1, 3, 2, 3, 1 };
        int arr2[] = { 2, 4, 3, 5, 1 };
        // System.out.println(reversePair(arr2));
        System.out.println(reversePairs(arr2));
    }
}