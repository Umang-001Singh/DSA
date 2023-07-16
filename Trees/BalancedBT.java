package Trees;

public class BalancedBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(6);

        int ans = balanced(root);
        if(ans == -1){
            System.out.println("False");
        }
        else{
            System.out.println("True");
        }
    }

    public static int balanced(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = balanced(node.left);
        int right = balanced(node.right);

        // int diff = Math.abs(left - right);

        if(left == -1 || right == -1 || Math.abs(right - left)>1){
            return -1;
        }
        
        return 1+Math.max(left,right);
        
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
