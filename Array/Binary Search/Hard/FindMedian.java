class Code {
    public static int countSmallerThanMid(int[] A, int mid, int n) {
        int l = 0, h = n - 1;

        while (l <= h) {
            int md = (l + h) >> 1;
            if (A[md] <= mid) {
                l = md + 1;
            } else {
                h = md - 1;
            }
        }
        return l;
    }

    public static int findMedian(int[][] A, int row, int col) {
        int low = 1;
        int high = 1000000000;
        int n = row;
        int m = col;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += countSmallerThanMid(A[i], mid, col);
            }
            if (cnt <= (n * m) / 2)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static void main(String args[]) {
        int matrix[][] = { { 10, 20, 15 }, { 21, 30, 14 }, { 7, 16, 32 } };

        System.out.println(findMedian(matrix, 3, 3));
    }
}