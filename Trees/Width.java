package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Width {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(11);
        root.left.left.right = new TreeNode(10);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(7);
        root.right.right.left = new TreeNode(6);
        // root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(10);
        int ans = maxWidth(root);
        System.out.println(ans);
    }

    public static int maxWidth(TreeNode root){
        if(root == null){
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        int ans = 0;
        while(!q.isEmpty()){
            
            int size = q.size();
            // System.out.println(size);
            int first = 0;
            int last = 0;
            int min = q.peek().index;
            // System.out.println(min);

            for(int i = 0;i<size;i++){
                int curId = q.peek().index - min;
                // System.out.println(curId);
                TreeNode node = q.peek().node;
                q.remove();
                if(i == 0){
                    first = curId;
                }
                if(i == size-1){
                    last = curId;
                }

                if(node.left != null){
                    q.offer(new Pair(node.left, curId*2+1));
                }
                if(node.right != null){
                    q.offer(new Pair(node.right, curId*2 + 2));
                }
            }
            // System.out.println(first);
            // System.out.println(last);
            ans = Math.max(ans, last - first + 1);

        }
        return ans;
    }

    static class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode _node, int _index){
            this.node = _node;
            this.index = _index;
        }
    }

    static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
}
