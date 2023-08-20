package Trees;

import Trees.BalancedBT.TreeNode;

public class SumTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(62);
        root.left = new TreeNode(16);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(4);
        int ans = sumTree(root);
        System.out.println(ans);
    }

    public static int sumTree(TreeNode node){
        if(node.left == null && node.right == null){
            System.out.println(node.val);
            return node.val;
        }
        int left = Integer.MIN_VALUE;
        if(node.left != null){
            left = sumTree(node.left);
        }
        System.out.println(left);
        int right = Integer.MIN_VALUE;
        if(node.right != null){
            right = sumTree(node.right);
        }
        System.out.println(right);

        if(right == Integer.MIN_VALUE){
            System.out.println(node.val + left);
            return node.val + left;
        }

        if(left == Integer.MIN_VALUE){
            System.out.println(node.val + right);
            return node.val + right;
        }

        if(left + right != node.val){
            return -1;
        }

        return node.val;


    }
}
