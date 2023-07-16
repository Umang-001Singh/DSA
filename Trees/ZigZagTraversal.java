package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        ZigZag(root);
    }

    public static void ZigZag(TreeNode node){
        boolean flag = true; //true for left to right and false for right to left;
        ArrayList<ArrayList<Integer>> list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            int [] row;
            int Size = queue.size();
            row = new int[Size];
            for(int i=0;i<Size;i++){
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }

                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }

                if(flag){
                    row[i] = queue.remove().val;
                }
                else{
                    int y = Size - i - 1;
                    row[y] = queue.remove().val;
                }
            }
            flag = !flag;
            System.out.println(Arrays.toString(row));
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
