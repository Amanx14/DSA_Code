public class Pattern {
    public static void main(String[] args) {
        int n = 4; 
        int min = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i<j) {
                    min = i;
                    System.out.print(n - min + 1 + " ");
                }
                else {
                    min = j;
                    System.out.print(n - min + 1 + " ");
                }
            }
            for(int j=n-1; j>=1; j--) {
                if(i<j) {
                    min = i;
                    System.out.print(n - min + 1 + " ");
                }
                else {
                    min = j;
                    System.out.print(n - min + 1 + " ");
                }
            }
            System.out.println();
        }

        for(int i=n-1; i>=1; i--) {
            for(int j=1; j<=n; j++) {
                if(i<j) {
                    min = i;
                    System.out.print(n - min + 1 + " ");
                }
                else {
                    min = j;
                    System.out.print(n - min + 1 + " ");
                }
            }
            for(int j=n-1; j>=1; j--) {
                if(i<j) {
                    min = i;
                    System.out.print(n - min + 1 + " ");
                }
                else {
                    min = j;
                    System.out.print(n - min + 1 + " ");
                }
            }
            System.out.println();
        }
    }
}
