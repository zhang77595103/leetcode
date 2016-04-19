import java.util.LinkedList;

public class Solution {
    public LinkedList<String> addOperators(String num, int target) {
        LinkedList<String> re = new LinkedList<String>();
        if(num.length() == 0)   return re;

        dfs(num, target, 0, 0, 0, re, new StringBuilder());
        return re;
    }
    private void dfs(String num, int target, int pos, long cur, long pre, LinkedList<String> re, StringBuilder sb){
        if(pos == num.length()){
            if(target == cur)   re.add(sb.toString());
            return;
        }

        long n = 0;
        int length = sb.length();
        for(int i = pos; i < num.length(); ++i){
            n = n * 10 + (num.charAt(i) - '0');
            if(pos != 0){
                /*
                    The reason why every line of dfs must follow sb.setLength()
                    is because we must keep the sb unchanged.
                 */
                dfs(num, target, i + 1, cur + n, n, re, sb.append("+" + n));
                sb.setLength(length);
                /*
                    the way it deal with * to obey the calculation rule is really nice !
                 */
                dfs(num, target, i + 1, cur - pre + pre * n, pre * n, re, sb.append("*" + n));
                sb.setLength(length);
                dfs(num, target, i + 1, cur - n, -n, re, sb.append("-" + n));
                sb.setLength(length);
            }
            else{
                dfs(num, target, i + 1, n, n, re, sb.append("" + n));
                sb.setLength(length);
            }
            /*
                if n = 0 which means num.charAt(0) is 0, so it can not combine
                digits following it into a big number. (since no number start with a 0 except 0)
             */
            if(n == 0)  break;
        }
    }
}
