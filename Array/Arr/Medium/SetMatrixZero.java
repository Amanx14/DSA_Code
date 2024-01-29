public class SetMatrixZero {
    public static void markRow(int arr[][], int i) {
        for(int j=0; j<arr[0].length; j++) {
            if(arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    public static void markCol(int arr[][], int j) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }
    public static void setMatrixZeroBrute(int arr[][], int n, int m) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 0) {
                    markCol(arr, j);
                    markRow(arr, i);
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == -1) {
                   arr[i][j] = 0;
                }
            }
        }
    }

    public static void setMatrixZeroBetter(int arr[][], int n, int m) {
        int row[] = new int[n]; // row track
        int col[] = new int[m]; // col track

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i=0; i<row.length; i++) {
            for(int j=0; j<col.length; j++) {
                if(row[i] == 1 || col[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void optimal(int arr[][], int m, int n) {
        // int row[] = new int[n];  matrix[i][0];
        // int col[] = new int[m];  matrix[0][j];
        int  col0 = 1;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 0) {    
                    arr[i][0] = 0;

                    if(j==0) 
                       col0 = 0;
                    else 
                        arr[0][j] = 0;
                }
            }
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            } 
        }

        if(arr[0][0] == 0) {
            for(int j=0; j<m; j++) {
                arr[0][j] = 0;
            }
        }

        if(col0 == 0) {
            for(int i=0; i<n; i++) {
                arr[i][0] = 0;
            }
        }

    }
    public static void main(String args[]) {
        int arr[][] = {{1,1,1,1},{1,0,1,1}, {1,1,0,1}, {1,0,0,1}};
        int n = arr.length;
        int m = arr[0].length;

        // setMatrixZeroBrute(arr, n, m);
        // setMatrixZeroBetter(arr, n, m);
        optimal(arr, m, n);

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(); 
        }
    }
}