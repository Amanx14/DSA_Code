import java.util.Stack;

class Code {
    public static String reverseWords(String s) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }

            String words = "";

            while (i < s.length() && s.charAt(i) != ' ') {
                words += s.charAt(i);
                i++;
            }

            st.push(words);
        }

        String ans = "";
        while (!st.isEmpty()) {
            ans += st.peek();
            st.pop();

            if (!st.isEmpty()) {
                ans += " ";
            }
        }

        return ans;
    }

    public static String reverseWordsB(String s) {
        String words = "";
        int i = s.length() - 1;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            int j = i;

            if (i < 0) {
                break;
            }

            while (i >= 0 && s.charAt(i) != ' ')
                i--;

            if (words.length() == 0) {
                words += s.substring(i + 1, j + 1);
            } else {
                words += (" " + s.substring(i + 1, j + 1));
            }
        }

        return words;
    }

    public static void main(String args[]) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}