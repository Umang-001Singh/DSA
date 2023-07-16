package Trees;

import java.util.ArrayList;

public class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        root.right.right.right.right = new TreeNode(7);
        root.right.right.right.right.left =new TreeNode(9);
        root.right.right.right.right.right = new TreeNode(8);       

        ArrayList<Integer> list = new ArrayList<>();
        Boundary(root, list);
        System.out.println(list);
    }

    public static void Boundary(TreeNode root, ArrayList<Integer> list){
        //IF ROOT IS NOT THE ONLY NODE, THEN ADD ROOT IN THE BEGINNING, ELSE BoundaryLeaf WILL TAKE CARE OF IT.
        if(isLeaf(root)==false){
            list.add(root.val);
        }
        
        
        BoundaryLeft( root.left, list);
        
        BoundaryLeaf( root, list);
        ArrayList<Integer> temp = new ArrayList<>();
        BoundaryRight( root.right, temp);
        for(int i = temp.size()-1;i>=0;i--){
            list.add(temp.get(i));
        }

        return;
    }

    public static void BoundaryLeft(TreeNode root, ArrayList<Integer> list){
        TreeNode cur = root;
        while(cur!=null){
            if(isLeaf(cur) == false){
                list.add(cur.val);
            }
            else{
                return;
            }
            if(cur.left != null){
                BoundaryLeft(cur.left, list);
            }
            else{
                BoundaryLeft(cur.right, list);
            }
            
            
            return;
        }
        return;
    }

    public static void BoundaryLeaf(TreeNode root, ArrayList<Integer> list){
        //WE ARE RECEIVING A ROOT NODE HERE BECAUSE TO ADD ALL THE LEAF NODES OF THE BINARY TREE, WE WILL NEED ROOT NODE
        TreeNode cur = root;
        while(cur != null){
            if(isLeaf(cur)){
                list.add(cur.val);
                return;
            }
            BoundaryLeaf(cur.left, list);
            BoundaryLeaf(cur.right, list);
            return;
        }
        return;
        
    }

    public static void BoundaryRight(TreeNode root, ArrayList<Integer> list){
        TreeNode cur = root;
        // ArrayList<Integer> list = new ArrayList<>();
        while(cur!=null){
            if(isLeaf(cur) == false){
                list.add(cur.val);
            }
            else{
                return;
            }
            if(cur.right!=null){
                BoundaryRight(cur.right, list);
            }
            else{
                BoundaryRight(cur.left, list);
            }
            return;
        }
        return;
    }

    public static boolean isLeaf(TreeNode node){
        if(node.left == null && node.right ==null){
            return true;
        }
        return false;
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
