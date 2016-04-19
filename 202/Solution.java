import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isHappy(int n) {
        Queue<Integer> q = new LinkedList<Integer>();
        int remainer = 0;
        while(n > 0) {
            while (n > 0) {
                remainer = n % 10;
                n = n / 10;
                q.offer(remainer);
            }
            while(!q.isEmpty()){
                n += Math.pow(q.poll(), 2);
            }
            System.out.println(n);
            if(n < 10){
                break;
            }
        }
        return n == 1;
    }
}
