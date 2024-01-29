import java.util.*;

public class PhoneNum {

    public static String getPhoneNumber(String s) {
        HashMap<String, Character> map = new HashMap<>();
        
        map.put("one", '1');
        map.put("two", '2');
        map.put("three", '3');
        map.put("four", '4');
        map.put("five", '5');
        map.put("six", '6');
        map.put("seven", '7');
        map.put("eight", '8');
        map.put("nine", '9');
        map.put("zero", '0');

        Stack<String> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            String word = "";
            while(i < s.length() && s.charAt(i) != ' ') {
                word += s.charAt(i);
                i++;
            }
            st.push(word);
        }
        
        ArrayList<String> list = new ArrayList<>();
        while(!st.isEmpty()) {
            String temp = st.peek();
            list.add(temp);
            st.pop();
        }
        Collections.reverse(list);

        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals("double")) {
                int idx = list.indexOf(list.get(i));
                String temp = list.get(idx+1);
                list.set(idx, temp);
            }
        }

        String ans = "";

        for(int i=0; i<list.size(); i++) {
            if(map.containsKey(list.get(i))) {    
                ans += map.get(list.get(i));
            }
        }

        return ans;
    }
   
    public static void main(String[] args) {
        String input = "double nine double two double three four";
        System.out.println(getPhoneNumber(input));

        String words[] = input.split(" ");

        for(String s : words) {
            System.out.println(s);
        }
    }
}