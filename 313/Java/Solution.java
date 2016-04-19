/*
    After analyse the question, if we want to find the nth ugly num.
    we just need to loop from 1 to nth num, so how can we make sure
    we don't leak any ugly number ? In fact, any ugly number can be
    derived from the previous ugly number(previous ugly num * prime
    respectively , and choose the smallest one that is bigger than
    current one.) So we can hold an array to record the position of
    the last number that the prime has multiplied, so next time we
    just need to use the next ugly num to multiply the prime to
    check if it is the proper num.
 */

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        //record the pos
        int[] index = new int[primes.length];
        int[] nums = new int[n+1];

        // 1 is also a ugly number
        nums[0] = 1;
        int counter = 1;
        //sometimes we meet several prime's next multiply is the same
        //so we just put they into queue then deal they equally
        Queue<Integer> q = new LinkedList();
        while(counter < n){
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < primes.length ; i++) {
                int temp = primes[i] * nums[index[i]];
                if(temp <= best ){
                    if(temp != best){
                        if(!q.isEmpty()) {
                            q.clear();
                        }
                        q.add(i);
                    }
                    else{
                        q.add(i);
                    }
                    best = temp;

                }
            }
            //System.out.println(flag[0] + " " + flag[1]);
            nums[counter++] = best;
            while(!q.isEmpty()){
                index[q.poll()]++;
            }
        }
        return nums[n-1];
    }
}

/*
 * I got a better solution for line 27, we simple use one value (eg : i) to record the prime that made us get the current value
 * if duplicate cur-value occurs, just index[i]++ then change i to another prime, it save time and space.
*/ 
