public class PeakElementII {
    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int temp[] = new int[2];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                //checking with the top element
                if(i>0 && mat[i-1][j] > mat[i][j]) {
                    continue;
                }
                //checking with the right element
                if(j<m-1 && mat[i][j+1] > mat[i][j]) {
                    continue;
                }
                //checking with the bottom element
                if(i<n-1 && mat[i+1][j]  > mat[i][j]) {
                    continue;
                }
                //checking with the left element
                if(j > 0 && mat[i][j-1] > mat[i][j]) {
                    continue;
                }
                
                temp[0] = i;
                temp[1] = j;
            }
        }

        return temp;
    }

    public static int[] findPeakGridOptimized(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int stCol = 0, endCol = m-1;

        while(stCol <= endCol) {
            int midCol = (stCol + endCol) / 2;
            int maxRow = 0;

            for(int i=0; i<n; i++) {
                if(arr[i][midCol] >= arr[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            if((midCol == 0 || arr[maxRow][midCol] >  arr[maxRow][midCol-1]) &&
             (midCol == m -1 || arr[maxRow][midCol] > arr[maxRow][midCol-1])) {
                return new int[] {maxRow, midCol};
            }
            else if(midCol > 0 && arr[maxRow][midCol-1] > arr[maxRow][midCol]) {
                endCol = midCol - 1;
            }
            else {
                stCol = midCol + 1;
            }
        }
        return new int[] {-1,-1};
    }
    public static void main(String args[]) {
        int matrix[][] = {{10,20,15},{21,30,14},{7,16,32}};

        int ans[] = findPeakGridOptimized(matrix);
        for(int i : ans) {
            System.out.print(i + " ");
        }
    }
}