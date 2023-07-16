package Trees;

// import Trees.BalancedBT.TreeNode;

public class MaxSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int []max = new int[1];
        max[0] = 0;

        Sum(root, max);
        System.out.println(max[0]);
    }

    public static int Sum(TreeNode node, int max[]){
        if(node == null){
            return 0;
        }

        int leftSum = Math.max(0 ,Sum(node.left, max));
        int rightSum = Math.max(0 ,Sum(node.right, max));

        max[0] = Math.max(max[0], leftSum + rightSum + node.val);

        return node.val + Math.max(leftSum, rightSum);
        
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
