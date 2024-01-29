public class RotateMatrix90 {
    public static void rotate90(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Step : 1 Transpose
        for(int i=0; i<n; i++) {
            for(int j=i; j<m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Step 2 : Reverse j part

        for(int i=0; i<n; i++) {
            for(int j=0; j<m/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-j-1];
                matrix[i][m-j-1] = temp;
            }
        }
    }
    public static void main(String args[]) {
        int arr[][] = {{1,2,3},{4,5,6}, {7,8,9}};
        rotate90(arr);

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}