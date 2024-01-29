import java.sql.RowId;

public class SpecialPattern {
    public static void main(String args[]) {
        int n = 5;

        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i;
            if (i > n) {
                stars = 2 * n - i;
            }
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
        System.out.println("---------------------------------");
        int space = 2 * (n - 1);

        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i;

            if (i > n) {
                stars = 2 * n - i;
            }

            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            if (i < n) {
                space -= 2;
            } else {
                space += 2;
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * i - 2; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= 2 * i - 2; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
        System.out.println("---------------------------------");

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(j==1 || j==n || i==1 || i==n) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}