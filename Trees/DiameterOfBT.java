package Trees;

import java.util.Arrays;

// import javax.swing.tree.TreeNode;

public class DiameterOfBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(5);
        root.right.left.left.left = new TreeNode(6);
        int []max = new int[1];
        diameter(root, max);
        System.out.println(Arrays.toString(max));

    }

    public static int diameter(TreeNode node, int[] max){
        if(node == null){
            return 0;
        }

        int left = diameter(node.left,max);
        int right = diameter(node.right,max);

        max[0] =  Math.max(max[0], left + right);
        return 1+Math.max(left, right);
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
