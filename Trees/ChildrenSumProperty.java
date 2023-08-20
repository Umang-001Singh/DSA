package Trees;

import Trees.DiameterOfBT.TreeNode;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(4);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(1);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(3);
        int ans = sumChildren(node);
        System.out.println(ans);
    }

    public static int sumChildren(TreeNode node){
        if(node.left == null && node.right == null){
            return node.val;
        }
        int left = 0;
        if(node.left != null){
            left = sumChildren(node.left);
        }
        int right = 0;
        if(node.right != null){
            right = sumChildren(node.right);
        }

        if(left == -1 || right == -1){
            return -1;
        }

        if(left + right != node.val){
            return -1;
        }

        return node.val;
    }
}
