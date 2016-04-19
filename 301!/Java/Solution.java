import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
    Idea from Internet.
    https://leetcode.com/discuss/81478/easy-short-concise-and-fast-java-dfs-3-ms-solution
 */
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List re = new LinkedList<String>();
        remove(s, new char[]{'(', ')'}, 0, 0, re);
        re = new LinkedList(new HashSet(re));
        return re;
    }
    /*
        why we can flag here is because the in the last recursion we delete char
        at the position of flag, so we can delete the char before flag because
        there must be other recursion that delete the char before flag.
     */
    private void remove(String s, char[] ch, int point, int flag, List<String> re){
        int len = s.length();
        int i = point;
        int counter = 0;
        while(i < len){
            if(s.charAt(i) == ch[0]) counter++;
            if(s.charAt(i) == ch[1]) counter--;

            if(counter < 0){
                int j = flag;
                while(j <= i){
                    if(j > point && s.charAt(j-1) == ch[1]) {
                        j++;
                        continue;
                    }

                    if(s.charAt(j) == ch[1]){
                        remove(s.substring(0, j) + s.substring(j+1), ch, i, j,re);
                    }
                    j++;
                }
                return;
            }
            i++;
        }

        String reverse = new StringBuilder(s).reverse().toString();
        if(ch[0] == '('){
            /*
                from right to left to check if there are too many right parentheses.
             */
            remove(reverse, new char[]{')', '('}, 0, 0, re);
        }
        else{
            re.add(reverse);
        }
    }
}
