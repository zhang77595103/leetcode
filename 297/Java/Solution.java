/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private StringBuilder sb;
    private int index;

    public Codec() {
        sb = new StringBuilder();
        index = 0;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            append("n");
        }
        else{
            append("" + root.val);
            serialize(root.left);
            serialize(root.right);
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }
    private void append(String str){
        if(sb.toString().isEmpty()){
            sb.append(str);
        }
        else{
            sb.append("," + str);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("n"))    return null;
        
        int i;
        for(i = index; i < data.length() && data.charAt(i) != ','; ++i);
        String temp = data.substring(index, i);
        index = i == data.length() ? i : i + 1;
        if(temp.equals("n"))    return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(temp));
        root.left = deserialize(data);
        root.right = deserialize(data);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
