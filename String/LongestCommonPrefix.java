import java.util.Arrays;

class Code {
    public static String longestCommonPrefix(String[] strs) {
        String ans = "";

        for(int i=0; i<strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            boolean match = true;

            for(int j=1; j<strs.length; j++) {

                if(i >= strs[j].length() || ch != strs[j].charAt(i)) {
                    match = false;
                    break;
                }
            }

            if(match != false) {
                ans += ch;
            }
            else {
                break;
            }
        }
        return ans;
    }
    public static String optimized(String[] strs) {
        Arrays.sort(strs);

        String str1 = strs[0];
        String str2 = strs[strs.length-1];
        int idx = 0;

        while(idx < str1.length() && idx < str2.length()) {
            if(str1.charAt(idx) == str2.charAt(idx)) {
                idx++;
            }
            else {
                break;
            }
        }

        if(idx > 0) {
            return str1.substring(0, idx);
        }else {
            return "";
        }
    }
    public static void main(String[] args) {
        String[] str = {"flight", "flow", "flower"};
        System.out.println(optimized(str));
    }
}