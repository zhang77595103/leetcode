import java.util.HashMap;

/*
 * In fact arraylist can do better.
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(strs.length != pattern.length()) return false;
        HashMap<Character, String> hashMap = new HashMap<Character, String>();
        int i = 0, j = 0;
        char ch;
        String temp;
        while(i < pattern.length() && j < strs.length){
            ch = pattern.charAt(i++);
            temp = strs[j++];
            if(hashMap.containsKey(ch) || hashMap.containsValue(temp)){
                if(hashMap.containsKey(ch) && hashMap.get(ch).equals(temp)) continue;
                return false;
            }
            else{
                hashMap.put(ch, temp);
            }
        }
        return true;
    }
}
