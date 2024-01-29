import java.util.*;

class Solution {
    public static String frequencySort(String s) {
        Map<Character, Integer> map= new HashMap<>();

        // char charArr[] = s.toCharArray(); 
        
        //put characters into a map and their freq
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c , map.getOrDefault(c, 0) + 1);
        }

        List<Character> [] bucket = new List[s.length() + 1];
        //traversin on map
        for(char key : map.keySet()) {
            int freq = map.get(key);
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        //travering on the bucket array
        StringBuilder sb = new StringBuilder();
        for(int pos=bucket.length-1; pos>=0; pos--) {
            if(bucket[pos] != null) {
                for(char c : bucket[pos]) {
                    for(int i=0; i<pos; i++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}