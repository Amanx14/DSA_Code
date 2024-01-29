public class MedianOfTwoArr {
    public static int[] merge(int arr1[], int arr2[]) {
        int merged[] = new int[arr1.length + arr2.length];
        int idx = 0; // merged idx

        int i=0, j=0;

        while(i<arr1.length && j<arr2.length) {
            if(arr1[i] <= arr2[j]) {
                merged[idx] = arr1[i];
                idx++; i++;
            }
            else {
                merged[idx] = arr2[j];
                idx++; j++;
            }
        }

        while(i<arr1.length) {
            merged[idx] = arr1[i];
            idx++; i++;
        }

        while(j<arr2.length) {
            merged[idx] = arr2[j];
            idx++; j++;
        }

        return merged;
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int merged[] = merge(nums1, nums2);
        int n = merged.length;
        double avg = 0;

        if(n % 2 == 0) {
            int mid1 = n / 2;
            int mid2 = (n / 2) - 1;

            avg = (merged[mid1] + merged[mid2]) / 2.0;
            return avg;
        }
        else {
            int mid = n / 2;
            return merged[mid];
        }
    }

    public static double Optimized(int[] nums1, int[] nums2) {
        int n1 = nums1.length; 
        int n2 = nums2.length;

        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2; // odd even dono pe chalega

        int low = 0; int high = n1;

        while(low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int l1 = (mid1 > 0) ? nums1[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2-1] : Integer.MIN_VALUE;

            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1) {
                if(n % 2 == 1) {
                    return Math.max(l1,l2);
                }
                else {
                    return (double)((Math.max(l1,l2) + Math.min(r1,r2)) / 2.0); 
                }
            }
            else if(l1 > r2) {
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1;
            }
        }
        return 0;
    }
    public static void main(String args[]) {
        int arr1[] = {2,4,6};
        int arr2[] = {1,3,5};

        // System.out.println(findMedianSortedArrays(arr1, arr2));
        System.out.println(Optimized(arr1, arr2));
    }
}