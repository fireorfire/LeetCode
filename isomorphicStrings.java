public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sch = s.toCharArray(), tch = t.toCharArray();
        char[] map = new char[256], mapback = new char[256];
        for(int i = 0; i < map.length; i++) {
            map[i] = '0';
            mapback[i] = '0';
        }
        for(int i = 0; i < sch.length; i++) {
            if(map[sch[i]] == '0' && mapback[tch[i]] == '0') {
                map[sch[i]] = tch[i];
                mapback[tch[i]] = sch[i];
            }
            else if(map[sch[i]] != tch[i] || mapback[tch[i]] != sch[i]) return false;
        }
        return true;
    }
}