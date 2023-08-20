package Trees;

import java.util.HashMap;

import Trees.BalancedBT.TreeNode;

public class ConstructTreeFromPostOrderAndInOrder {
    public static void main(String[] args) {
        int[] inOrder = {40, 20, 50, 10, 60, 30};
        int[] postOrder = {40, 50, 20, 60, 30, 10};
        TreeNode ans = build(inOrder, postOrder);
        System.out.println(ans);
    }

    public static TreeNode build(int[] inOrder, int[] postOrder){
        if(inOrder == null || postOrder == null || inOrder.length != postOrder.length){
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<inOrder.length;i++){
            map.put(inOrder[i], i);
        }

        TreeNode root = buildTrees(inOrder, 0, inOrder.length-1, postOrder, 0, postOrder.length - 1, map);

        return root;
    }

    public static TreeNode buildTrees(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd, HashMap<Integer, Integer> map){
        if(inStart>inEnd || postStart>postEnd){
            return null;
        }

        TreeNode root = new TreeNode(postOrder[postEnd]);
        int inRoot = map.get(root.val);

        root.left = buildTrees(inOrder, inStart, inRoot-1, postOrder, postStart, inRoot - 1, map);
        root.right = buildTrees(inOrder, inRoot + 1, inEnd, postOrder, inRoot, postEnd - 1, map);

        return root;
    }
}
