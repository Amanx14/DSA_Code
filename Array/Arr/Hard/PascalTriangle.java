public class PascalTriangle {
    public static long nCr(int n, int r) {
        long res = 1;

        for(int i=0; i<r; i++) {
            res = res * (n - i); 
            res = res / (i+1);        
        }

        return res;
    }

    public static int pascalTriangle(int r, int c) {
        int ans = (int)nCr(r-1, c-1);
        return ans;
    }
    public static void main(String args[]) {
        int r = 5, c = 3;
        
        System.out.println(pascalTriangle(r, c));
    }
}