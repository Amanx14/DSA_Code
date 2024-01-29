public class SecElementArr {
    public static void getSecondOrderElements(int n, int []a) {

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for(int i=0; i<a.length; i++) {
            if(a[i] > max) {
                max = a[i];
            }

            if(a[i] < min) {
                min = a[i];
            }
        }

        int secMin = Integer.MAX_VALUE; 
        int secMax = Integer.MIN_VALUE;

        for(int i=0; i<a.length; i++) {
            if(a[i] == min || a[i] == max) {
                continue;
            }

            if(a[i] > secMax) {
                secMax = a[i];
            }
            if(a[i] < secMin) {
                secMin = a[i];
            }
        }

        System.out.println(secMax);
        System.out.println(secMin);
    }

    public static void secElementsOptimized(int arr[]) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                secMax = max;
                max = arr[i];
            }
            else if(arr[i] > secMax && arr[i] != max){
                secMax = arr[i];
            }
        }
        System.out.println(secMax);
    }

    public static int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE, secMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > max) {
                thirdMax = secMax;
                secMax = max;
                max = nums[i];
            }
            else if(nums[i] > secMax && nums[i] != max) {
                thirdMax = secMax;
                secMax = nums[i];
            }
            else if(nums[i] > thirdMax && nums[i] != max && nums[i] != secMax){
                thirdMax = nums[i];
            }
        }

        if(thirdMax == Long.MIN_VALUE) {
            return (int)max;
        }
        return (int)thirdMax;
    }
    public static void main(String args[]) {
        int arr[] = {1,1,2,6,6,4,5,5};

        // getSecondOrderElements(arr.length, arr);
        secElementsOptimized(arr);
    }
}