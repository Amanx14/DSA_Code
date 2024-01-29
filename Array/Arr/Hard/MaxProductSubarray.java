public class MaxProductSubarray {
    public static int maxproductSubArrBrute(int arr[]) {
        int n = arr.length;

        int maxProduct = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int product = 1;
                for(int k=i; k<=j; k++) {
                    product = product * arr[k];
                }
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    public static int maxproductSubArrBetter(int arr[]) {
        int n = arr.length;
        int maxProduct = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            int product = 1;
            for(int j=i; j<n; j++) {
                product *= arr[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }

    public static int maxproductSubArrOptimal(int arr[]) {
        int n = arr.length;
        int prefix = 1, suffix = 1;
        int maxProduct = 0;

        for(int i=0; i<n; i++) { // {1,2,-3,0,-4,-5}
            if(prefix == 0) {
                prefix = 1;
            }
            if(suffix == 0) {
                suffix = 1;
            }
            prefix *= arr[i];
            suffix *= arr[n-i-1];
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }

        return maxProduct;
    }
    public static void main(String args[]) {
        int arr[] = {1,2,3,4,5,0};
        int arr2[] = {1,2,-3,0,-4,-5};

        // System.out.println(maxproductSubArrBrute(arr2));
        // System.out.println(maxproductSubArrBetter(arr));
        System.out.println(maxproductSubArrOptimal(arr2));
    }
}