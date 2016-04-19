/**
 *  In this question the key point is when you meet * after you have met * before, we can just ignore the pos of the previous 
 *  one and just record the one we are facing now.
 */

public class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        int left = 0;
        int right = 0;
        int s_left = -1;
        int p_right = -1;

        while(left < len1){
            if(right < len2 && (s.charAt(left) == p.charAt(right) || p.charAt(right) == '?')){
                left++;
                right++;
            }
            else if(right < len2 && p.charAt(right) == '*'){
                s_left = left;
                p_right = right;
                right++;
            }
            else if(p_right != -1){
                left = ++s_left;
                right = p_right + 1;
            }
            else{
                return false;
            }
        }
        while(right < len2 && p.charAt(right) == '*'){
            right++;
        }

        return right == len2;
    }
}

