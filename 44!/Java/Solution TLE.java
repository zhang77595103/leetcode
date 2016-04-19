public class Solution {
    public boolean isMatch(String s, String p) {
        int fir = 0;
        int sec = 0;
        int len1 = s.length();
        int len2 = p.length();

        while(sec < len2){
            if(p.charAt(sec) == '*'){
                //if * is the last char in p
                while(p.charAt(sec) == '*') {
                    //avoid there continuous * occur
                    if (++sec == len2) {
                        return true;
                    }
                }
                char aim = p.charAt(sec);
                //aim can be either ? or letter
                while(fir < len1){
                    //find the matching item
                    while(aim != s.charAt(fir) && aim != '?'){
                        if(++fir == len1){
                            return false;
                        }
                    }

                    boolean flag = isMatch(s.substring(++fir), p.substring(++sec));
                    if(flag){
                        return true;
                    }
                    else{
                        sec--;
                        continue;
                    }
                }
                //if go out of the loop, means can't find
                return false;
            }
            if(fir == len1){
                return false;
            }
            
            if(s.charAt(fir) != p.charAt(sec) && p.charAt(sec) != '?'){
                return false;
            }
            else{
                fir++;
                sec++;
            }
        }
        return  (fir == len1 && sec == len2);
    }
}

