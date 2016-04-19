/**
 *  After we analyse the question, we will find the rule.
 *  for the ith bulb , it will be toggle like below:
 *
 *  1 : 1
 *  2 : 1, 2
 *  3 : 1, 3
 *  4 : 1, 2, 4
 *  5 : 1, 5
 *  6 : 1, 2, 3, 6
 *  7 : 1, 7
 *  8 : 1, 2, 4, 8
 *  9 : 1, 3, 9
 *  10 : 1, 2, 5, 10
 *
 * if the number is not a square number, it factor will always come in pairs, so only those square number will be on at last.
 *
 */
public class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
