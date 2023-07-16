package Trees;

import java.util.Scanner;

public class LeetCodeBTree {
    public static TreeNode BuildTree(TreeNode root){
        System.out.println("Enter data for the root");
        int data;
        Scanner sc = new Scanner(System.in);
        data = sc.nextInt();

        if(data == -1){
            return null;
        }
        root = new TreeNode(data);

        System.out.println("Enter data for inserting in the left of " + data +" ");
        root.left = BuildTree(root.left);

        System.out.println("Enter data for inserting to the right of" + data +" ");
        root.right = BuildTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        //CREATING A TREE
        root = BuildTree(root); //PASSING DATA VALUE AS NULL
    }
    
    //MENTIONING STAIC REFERS THAT TreeNode class IS NESTED
    //IF NOT PRESENT FOLLOWING ERROR WILL BE ENCOUNTERED:No enclosing instance of type LeetCodeBTree is accessible. Must 
    //qualify the allocation with an enclosing instance of type LeetCodeBTree
    //TO SOLVE THIS PROBLEM EITHER CREATE AN INSTANCE OF LeetCodeBTree BEFORE TreeNode CLASS INSTANCE (SINCE TreeNode class
    // IS ASSOCIATED WITH CLASS LeetCodeBTree) OR MAKE TreeNode CLASS NESTED USING KEYWORD static
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
