import java.util.HashMap;

class Code {
    public static boolean isAnagram(String s, String t) {
         if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                if(map.get(ch) > 1) {
                    map.put(ch, map.get(ch)-1);
                }
                else {
                    map.remove(ch);
                }
            }
        }

        return map.isEmpty();
    }

    public static boolean optimized(String s, String t) {
        int freq[] = new int[26];

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            freq[idx]++;
        }

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            int idx = ch - 'a';
            freq[idx]--;
        }

        for(int i : freq) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
        // System.out.println(optimized(s, t));
    }
}