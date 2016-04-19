/*
    the most clean solution from internet, the basic idea is :

    通过二叉树的性质，所有二叉树中Null指针的个数=节点个数+1。因为一棵树要增加一个节点，
    必然是在null指针的地方增加一个叶子结点，也就是毁掉一个null指针的同时带来两个null指针，
    意味着每增加一个节点，增加一个null指针。然而最开始一颗空树本来就有一个null指针，因此
    二叉树中null指针的个数等于节点数+1。从头开始扫描这个字串，如果途中#的个数超了，或者
    字符串扫描完不满足等式则返回false。

 */

public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");

        //we can set the inital value as 1
        int val = 1;

        for(String i : nodes){
            val--; //
            if(val < 0){
                // when this happen val == -1, but not the tree end
                return false;
            }

            if(!i.equals("#")){
                val += 2;
            }
        }

        return val == 0;
    }
}
