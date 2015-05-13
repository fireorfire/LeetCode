public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> hash = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int len = words.length;
        if(len == 0) return result;
        int wordLen = words[0].length();
        for(String word: words) {
            if(hash.containsKey(word)) {
                hash.put(word, hash.get(word) + 1);
            }
            else hash.put(word, 1);
        }
        
        for(int i = 0; i <= s.length() - len * wordLen; i++) {
            HashMap<String, Integer> target = new HashMap<>(hash);
            int j;
            for(j = 0; j < len; j++) {
                int index = i + j * wordLen;
                String sub = s.substring(index, index + wordLen);
                if(!target.containsKey(sub)) break;
                else if(target.get(sub) == 1) target.remove(sub);
                else target.put(sub, target.get(sub) - 1);
            }
            if(j == len) result.add(i);
        }
        return result;
    }
}