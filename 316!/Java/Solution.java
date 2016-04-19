/*
    In this question, we can simplely use greedy and stack
 */


import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int counter[] = new int[26];
        boolean in[] = new boolean[26];

        //traversal to calculate the occurence number
        for(char ch : s.toCharArray()){
            counter[ch - 'a']++;
        }

        Stack<Character> stk = new Stack();
        for(Character ch : s.toCharArray()){
            /*
                even the value has put into the stack, but it can be pop out if
                the counter is not 0, so if we meet an char that is in stack, we
                still need to minus the counter.
             */
            --counter[ch - 'a'];

            //we just igonre those element that has been determined
            if(in[ch - 'a']){
                continue;
            }

            /*
                if the stack not empty, then we look the top element in it,
                if the char is less than the top element and we will
                continue to meet the char later, so we just give the
                pos to the appropriate char.
             */
            while(!stk.isEmpty() && ch < stk.peek() && counter[stk.peek() - 'a'] > 0){
                in[stk.pop() - 'a'] = false;
            }

            stk.push(ch);
            in[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.insert(0, stk.pop());
        }
        return sb.toString();
    }
}

