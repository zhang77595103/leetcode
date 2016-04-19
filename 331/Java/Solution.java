/*
    this is my own way to solve this problem.
    Here is basically two situation.

    1. when the first char is #, then unless there is only one #, otherwise must be wrong.

    2. if not the first situation, we only need to make sure every node has it's two child node.
    (push the node without found his son into the stack and pop it out when his son is found.)
    we can even use no stack, for example in C, i just use a array substitution.

 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if( preorder.charAt(0) == '#'){
            if(preorder.length() == 1){
                return true;
            }
            return false;
        }

        int i = 0;
        boolean left = true;
        java.util.Stack<Character> sta = new java.util.Stack<Character>();
        sta.push(preorder.charAt(i));

        while(i < preorder.length()){
            while(i < preorder.length() && preorder.charAt(i) != ','){
                i++;
            }
            if(i == preorder.length()){
                break;
            }

            i++;
            if(left){
                if(preorder.charAt(i) == '#'){
                    left = false;
                }
                else{
                    sta.push(preorder.charAt(i));
                }

            }
            else{
                // if no char left, means things unexpected happened, so it's false.
                if(sta.empty()){
                    return false;
                }
                if(preorder.charAt(i) == '#'){
                    sta.pop();
                    left = false; // can ignore cause only left == false the code will get here
                }
                else{
                    sta.pop();
                    sta.push(preorder.charAt(i));
                    left = true;
                }
            }
        }

        if(sta.empty()){
            return true;
        }
        return false;
    }
}
