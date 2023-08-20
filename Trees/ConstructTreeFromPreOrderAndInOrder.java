package Trees;

import java.util.HashMap;

import Trees.BalancedBT.TreeNode;

public class ConstructTreeFromPreOrderAndInOrder {
    public static void main(String[] args) {
        int[] inOrder = {40, 20, 50, 10, 60, 30};
        int[] preOrder = {10, 20, 40, 50, 30, 60};
        TreeNode ans = build(inOrder, preOrder);
        System.out.println(ans);
    }

    // public static void createMap(int[] inOrder, HashMap<Integer, Integer> map){
    //     for(int i = 0;i<inOrder.length;i++){
    //         map.put(inOrder[i], i);
    //     }
    // }

    public static TreeNode buildTrees(int[] inOrder, int inStart, int inEnd, int[] preOrder, int preStart, int preEnd, HashMap<Integer, Integer> map){
        if(inStart>inEnd || preStart>preEnd){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preStart]);
        int inRoot = map.get(preOrder[preStart]);
        int numsLen = inRoot - inStart;

        root.left = buildTrees(inOrder, inStart, inRoot-1, preOrder, preStart+1, preStart + numsLen , map);
        root.right = buildTrees(inOrder, inRoot + 1, inEnd, preOrder, preStart+numsLen + 1, preEnd, map);

        return root;
    }

    public static TreeNode build(int[] inOrder, int[] preOrder){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<inOrder.length;i++){
            map.put(inOrder[i], i);
        }

        TreeNode root = buildTrees(inOrder, 0, inOrder.length-1, preOrder, 0, preOrder.length-1, map);

        return root;
    }
}
