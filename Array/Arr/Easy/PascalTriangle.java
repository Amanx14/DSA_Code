import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    // Pascal Triangle 1
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i=1; i<=numRows; i++) {
            List<Integer> ans = new ArrayList<>();
            for(int j=1; j<=i; j++) {

                if(j==1 || j==i) {
                    ans.add(1);
                }
                else {
                    ans.add(result.get(i-2).get(j-2) + result.get(i-2).get(j-1));
                }
            }
            result.add(ans);
        }
        return result;
    }

    // Pascal Triangle 2
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();

        for(int i=1; i<=rowIndex+1; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j=1; j<=i; j++) {
                if(j==1 || j==i) {
                    temp.add(1);
                }
                else {
                    temp.add(ans.get(j-1) + ans.get(j-2));
                }
            }
            ans = temp; // ans array ko update karna
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> ans = generate(n);
        System.out.println(ans);

        List<Integer> ans2 = getRow(4);
        System.out.println(ans2);
    }
}