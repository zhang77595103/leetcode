/*
    after search the solution from internet, got another convenient way to solution this problem.
    we can think like this, wo just add non # node to the stack, when we meet two continues # node,
    we just pop three element out and push a # (you can just think we are simplifying the tree --
    change the non # node into # node) then after we traversal the tree, we can get only one # since
     the tree has become a null node.
 */

public class Solution {
    public boolean isValidSerialization(String preorder) {

        /*
            this question has a trap, it did't tell us the node is only one char long or more, so we
            can't treat it just as one char long, so I use split.
        */
        String[] x = preorder.split(",");
        java.util.Stack<String> sta = new java.util.Stack<String>();

        for(String i : x){
            if(i.equals("#")){
                while(true) {
                    if (sta.empty()) {
                        break;
                    }
                    if (sta.peek().equals("#")) {
                        sta.pop();
                        if (sta.empty() || sta.pop().equals("#")) {
                            // when two # node has a # node parent, it's invalid.
                            return false;
                        }
                    }
                    else{
                        //if the peek of the stack is no longer #
                        break;
                    }
                }
                // it is possible that there is also another # left before, so we must check again
                sta.push("#");
            }
            else{
                sta.push(i);
            }
        }

        if(sta.pop().equals("#") && sta.empty()){
            return true;
        }
        return false;
    }
}
