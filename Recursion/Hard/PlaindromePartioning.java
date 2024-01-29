import java.util.ArrayList;
import java.util.List;

public class PlaindromePartioning {
    public static void partition(String s, int idx, List<String> ans, List<List<String>> result) {
        // base case 
        if(idx == s.length()) {
            result.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i=idx; i<s.length(); i++) {
            if(isPalindrome(s, idx, i)) {
                ans.add(s.substring(idx, i+1));
                partition(s, i+1, ans, result);
                ans.remove(ans.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++; end--;
        }
        return true;
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int idx = 0;

        partition(s, idx, list, result);
        return result;
    }

    public static void main(String[] args) {
        String str = "aab";

        List<List<String>> ans =  partition(str);
        System.out.println(ans);
    }
}
