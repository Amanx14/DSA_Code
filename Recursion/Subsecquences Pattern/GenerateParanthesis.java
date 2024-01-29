import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public static void helper(List<String> ans, String str, int open, int close, int n) {
        if(str.length() == 2*n) {
            ans.add(str);
            return;
        }

        if(open < n) {
            helper(ans, str + "(", open + 1, close, n);
        }
        if(close < open) {
            helper(ans, str + ")", open, close+1, n);
        }

    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, "", 0, 0, n);
        return ans;
    }

    public static void main(String args[]) {
        int n = 3;
        List<String> ans = generateParenthesis(n);
        System.out.println(ans);
    }
}