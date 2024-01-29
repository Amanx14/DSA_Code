public class UpperLowerBound {
    public static int lowerBound(int []nums, int n, int x) {
        int start = 0, end = n-1;
        int ans = n;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(nums[mid] == x) {
                ans = mid;
                return ans;
            }
            else if(nums[mid] < x) {
                start = mid + 1;
                
            }
            else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;
    }

    public static int upperBound(int nums[], int N, int x) {
        int start = 0, end = N-1;
        int ans = N;
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] > x) {
                ans = mid;
                end = mid - 1;
            }
            else if(nums[mid] == x) {
                start = mid + 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int N = 5, arr[] = {3,5,8,15,19}, x = 8;
        System.out.println(lowerBound(arr, N, x));

        System.out.println(upperBound(arr, N, x));
    }
}