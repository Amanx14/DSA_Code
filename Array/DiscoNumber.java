import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiscoNumber {
    public static int findMin(int matrix[][], int row) {
        int min = Integer.MAX_VALUE;

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[row][j] < min) {
                    min = matrix[row][j];
                }
            }
        }

        return min;
    }

    public static int findMax(int matrix[][], int col) {
        int max = Integer.MIN_VALUE;

        // [13,  7,   8] 
        // [2,  11, 13]
        // [15, 16, 17]

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][col] > max) {
                    max = matrix[i][col];
                }
            }
        }

        return max;
    }
    public static List<Integer> findDiscoNumber(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> discoNumber = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int max = findMax(matrix, j);
                int min = findMin(matrix, i);

                if(matrix[i][j] == max && matrix[i][j] == min) {
                    discoNumber.add(matrix[i][j]);
                }
            }
        }

        return discoNumber;
    } 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int matrix[][] = {{13, 7, 8},
                         {2, 11, 13},
                         {15, 16, 17}};
        
        List<Integer> ans = findDiscoNumber(matrix);
        System.out.println(ans);
    }
}