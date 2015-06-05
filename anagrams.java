public class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for(String str: strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortStr = new String(ch);
            if(hash.containsKey(sortStr)) {
                hash.get(sortStr).add(str);
            }else {
                List<String> strlist = new ArrayList<>();
                strlist.add(str);
                hash.put(sortStr, strlist);
            }
        }
        List<String> result = new ArrayList<>();
        for(Map.Entry entry: hash.entrySet()) {
            List<String> list = (List<String>)entry.getValue();
            if(list.size() > 1) 
                result.addAll(list);
        }
        return result;
    }
}