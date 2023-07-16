package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class LevelOrderTraversal{
    public static ArrayList<Integer> levelOrder(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        queue.offer(node);
        while(!queue.isEmpty()){
            if(queue.peek().left != null){
                queue.offer(queue.peek().left);
            }

            if(queue.peek().right != null){
                queue.offer(queue.peek().right);
            }

            list.add(queue.poll().val);
        }

        return list;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);
        

        ArrayList<Integer> list = new ArrayList<>();
        list = levelOrder(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
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