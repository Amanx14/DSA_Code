import java.util.ArrayList;

public class Substring {
    public static void generate(String word, int idx, ArrayList<String> str) {
        if (idx > word.length()) {
            // System.out.println(word);
            str.add(word);
            return;
        }

        // System.out.println(word);
        str.add(word);

        generate(word.substring(0, word.length()-1), idx+1, str); 
        generate(word.substring(1, word.length()), idx+1, str); 
    }
    public static void main(String[] args) {
        ArrayList<String> str = new ArrayList<>();
        generate("abcd" , 0, str);

        System.out.println(str);
    }
}