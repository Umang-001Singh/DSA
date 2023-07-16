package Trees;

import Trees.InOrderTraversal.TreeNode;

public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        System.out.println(depth(root));
    }

    public static int depth(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);

        return 1+Math.max(left, right);
    }
}
