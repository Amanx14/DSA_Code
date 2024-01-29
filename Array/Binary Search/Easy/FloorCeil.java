public class FloorCeil {
    public static int[] floorCeil(int arr[], int x) {
        int n = arr.length;

        int floor = -1;
        int ceil = -1;
        for(int i=0; i<n; i++) {
            //floor
            if(floor == -1 && arr[n-i-1] <= x) {
                floor = arr[n-i-1];
            }

            if(ceil == -1 && arr[i] >= x) {
                ceil = arr[i];
            }
        }

        int ans[] = new int[]{floor, ceil};
        return ans;
    }

    // ----------- Modified Approach--------------//
    static int findFloor(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] <= x) {
                ans = arr[mid];
                //look for smaller index on the left
                low = mid + 1;
            } else {
                high = mid - 1; // look on the right
            }
        }
        return ans;
    }

    static int findCeil(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = arr[mid];
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
        int f = findFloor(arr, n, x);
        int c = findCeil(arr, n, x);
        return new int[] {f, c};
    }

    public static void main(String args[]) {
        int arr[] = {3,4,4,7,8,10}, x = 8;

        int ans[] = getFloorAndCeil(arr, arr.length, x);
        
        for(int i : ans) {
            System.out.print(i + " ");
        }
    }
}