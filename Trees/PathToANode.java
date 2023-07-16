package Trees;

import java.util.Stack;

public class PathToANode {
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left =new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        
        
        Stack<Integer> s = new Stack<>();
        boolean []flag = new boolean[1];
        flag[0] = false;

        Path(root,5,s,flag);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    public static void Path(TreeNode node, int n, Stack<Integer> s,boolean []flag){
        while(node!=null){
            if(node.val == n){
                s.push(node.val);
                flag[0] = true;
                return;
            }

            Path(node.left, n ,s,flag);
            if(flag[0] == true){
                s.push(node.val);
                return;
            }
            Path(node.right, n ,s,flag);
            if(flag[0] == true){
                s.push(node.val);
                return;
            }
            return;
        }
        return;

    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}

        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }
}
