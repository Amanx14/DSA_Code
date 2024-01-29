import java.util.*;

public class WordBreak {
    public static boolean wordBreakHelper(String s, List<String> wordDict, Map<String, Boolean> map) {
        if(wordDict.contains(s)) {
            return true;
        }

        if(map.containsKey(s)) {
            return map.get(s);
        }

        for(int i=0; i<s.length(); i++) {
            String left = s.substring(0,i+1);

            if(wordDict.contains(left)) {
                String right = s.substring(i+1);
                if(wordBreakHelper(right, wordDict, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }

        map.put(s, false);

        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();

        return wordBreakHelper(s, wordDict, map);
    }
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println(wordBreakHelper(s, wordDict, new HashMap<>()));

    }
}
