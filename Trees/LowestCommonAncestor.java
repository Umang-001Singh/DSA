package Trees;

import java.util.*;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        // Queue<Integer> q1 = new LinkedList<>();
        // Queue<Integer> q2 = new LinkedList<>();
        
        TreeNode root = new TreeNode(1);
        root.left =new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left =new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.left =new TreeNode(8);
        root.right.right = new TreeNode(9);

        // // Stack<Integer> s1 = new Stack<>();
        // boolean []flag = new boolean[1];
        // flag[0] = false;
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(6);

        TreeNode ans = null;
        ans = Lca(root, n1, n2);
        System.out.println(ans.val);

    }
    public static TreeNode Lca(TreeNode node, TreeNode n1, TreeNode n2){
        if(node == null){
            return null;
        }
        
        if(node.val == n1.val || node.val == n2.val){
            return node.val==n1.val?n1:n2;
        }

        

        TreeNode left = Lca(node.left, n1, n2);
        TreeNode right = Lca(node.right, n1, n2);

        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return node;
    }
    // public static TreeNode Lca(TreeNode node, TreeNode n1, TreeNode n2){
    //     Stack<TreeNode> s1 = new Stack<>();
    //     Stack<TreeNode> s2 = new Stack<>();

    //     boolean []flag1 = new boolean[1];
    //     flag1[0] = false;

    //     boolean []flag2 = new boolean[1];
    //     flag2[0] = false;

    //     Path(node, n1, s1, flag1);
    //     Path(node, n2, s2, flag2);
        
    //     TreeNode val1 = null;
    //     TreeNode val2 = null;
    //     TreeNode ans = null;
    //     while(!s1.isEmpty() && !s2.isEmpty()){
    //         if(s1.peek() == s2.peek()){
    //             val1 = s1.pop();
    //             val2 = s2.pop();
    //         }
    //         else{
    //             break;
    //         }
    //     }
    //     ans = val1;
    //     return ans;
    // }

    // public static void Path(TreeNode node, TreeNode n, Stack<TreeNode> s,boolean []flag){
    //     while(node!=null){
    //         if(node.val == n.val){
    //             s.push(node);
    //             flag[0] = true;
    //             return;
    //         }

    //         Path(node.left, n ,s,flag);
    //         if(flag[0] == true){
    //             s.push(node);
    //             return;
    //         }
    //         Path(node.right, n ,s,flag);
    //         if(flag[0] == true){
    //             s.push(node);
    //             return;
    //         }
    //         return;
    //     }
    //     return;

    // }

    
    // public static boolean isLeaf(TreeNode node){
    //     if(node.left == null && node.right == null){
    //         return true;
    //     }
    //     return false;
    // }
    
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
