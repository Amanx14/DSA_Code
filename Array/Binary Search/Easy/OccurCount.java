public class OccurCount {
    public static int firstOccur(int arr[], int x) {
        int start = 0, end = arr.length-1;
        int firstOccur = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == x) {
                firstOccur = mid;
                end = mid - 1;
            }
            else if(arr[mid] < x) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return firstOccur;
    }

    public static int LastOccur(int arr[], int x) {
        int start = 0, end = arr.length-1;
        int LastOccur = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == x) {
                LastOccur = mid;
                start = mid + 1;
            }
            else if(arr[mid] < x) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return LastOccur;
    }
    public static int count(int arr[], int x) {
        int firstOcc = firstOccur(arr, x);
        int LastOcc = LastOccur(arr, x);

        if(firstOcc == -1 && LastOcc == -1) {
            return 0;
        }

        int noOfoccur = LastOcc - firstOcc + 1;
        return noOfoccur;
    }

    public static void main(String args[]) {
        int arr[] = {2, 2 , 3 , 3 , 3 , 3 , 4}, x = 3;
        System.out.println(count(arr, x));

    }
}