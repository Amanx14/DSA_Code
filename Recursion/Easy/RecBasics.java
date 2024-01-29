public class RecBasics {
    // Printing name n times
    public static void printName(int i, int n) {
        if(i > n) {
            return;
        }
        System.out.println("Aman");
        printName(i, n);
    }

    // Print 1 - N

    public static void print(int i, int n) {
        if(i>n) {
            return;
        }

        System.out.println(i);
        print(i+1, n);
    }

    // Print N-1

    public static void printNto1(int i, int n) {
        if(i==0) {
            return;
        }

        System.out.println(i);
        printNto1(i-1, n);
    }

    // Backtracking

    // Print 1 to N;

    public static void show(int i, int n) {
        if(i==0) {
            return;
        } 

        show(i-1, n);
        System.out.println(i);
    }

    // Sum of first n numbers
    public static void sumTillN(int sum, int i) {
        if(i == 0) {
            System.err.println(sum);
            return;
        }

        // sum += i;
        sumTillN(sum+i, i-1);
    }

    // functional way
    public static int sumTillN2(int n) {
        if(n == 0) {
            return 0;
        }

        return n + sumTillN2(n-1); 
    }

    // factorial 

    public static int factorial(int n) {
        if(n == 1) {
            return 1;
        }

        return n * factorial(n-1);
    }
    public static void main(String[] args) {
        int n = 5;
        // printName(1, n);
        // print(1, n);
        // printNto1(5, n);
        // show(n, n);
        // sumTillN(0, 5);
        System.out.println(sumTillN2(n));
        System.out.println(factorial(n));
    }
}
