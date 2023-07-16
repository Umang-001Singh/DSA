package Trees;

import java.util.*;

public class MorrisTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(9);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);

        ArrayList<Integer> ans = new ArrayList<>();
        getInorder(root,ans);
        System.out.println(ans);
    }

    public static void getInorder(TreeNode root, ArrayList<Integer> list){
        // ArrayList<Integer> inorder = new ArrayList<>();
        // TreeNode cur = root;
        // while(cur!=null){
        //     if(cur.left == null){
        //         inorder.add(cur.val);
        //         getInorder(cur.right);
        //     }
        //     else{
        //         TreeNode prev = cur.left;
        //         while(prev.right != null && prev.right != cur){
        //             prev = prev.right;
        //         }
        //         if(prev.right == null){
        //             prev.right = cur;
        //             cur = cur.left;
        //         }   
        //         else{
        //             prev.right = null;
        //             inorder.add(cur.val);
        //             cur = cur.right;
        //         }
        //     }
        // }
        // return inorder;


        //CORRECT SOLUTION FOR INORDER MORRIS TRAVERSAL
        // TreeNode cur = root;
        // while(cur != null){
        //     if(cur.left == null){
        //         list.add(cur.val);
        //         cur = cur.right;
        //         getInorder(cur, list); 
        //         return;
        //         //HERE FUNCTION IS BEING CALLED AS WE NEED TO DELETE THEADED LINK WHERE SKIPPING IS REQUIRED AND THIS IS 
        //         //DONE IN else PART OF THE CODE.
        //     }
        //     else{
        //         TreeNode node = cur.left;

        //         //SKIPPING IS NECESSARY AT BOTH THREADED LINK GENERATION AND THREADED LINK DELETION. SO THIS PART OF THE CODE IS COMMON.
        //         while(node.right != null && node.right != cur){
        //             node = node.right;
        //         }

        //         if(node.right == null){
        //             node.right = cur;
        //             cur = cur.left; //FOR MOVING TO THE NEXT LEFT SUBTREE CONSIDERING current node AS root node.
        //         }
        //         else{
        //             node.right = null;
        //             list.add(cur.val);
        //             cur = cur.right;
        //         }
        //     }
        // }
        // return;

        //PREORDER MORRIS TRAVERSAL
        TreeNode cur = root;
        while(cur!=null){
            // list.add(cur.val);
            if(cur.left == null){
                list.add(cur.val);
                cur = cur.right;
                getInorder(cur, list);
                return;
            }
            else{
                // list.add(cur.val);
                TreeNode node = cur.left;
                // list.add(node.val);
                while(node.right != null && node.right != cur){
                    node = node.right;
                }
                if(node.right == null){
                    node.right = cur;
                    list.add(cur.val);
                    cur = cur.left;
                }
                else{
                    node.right = null;
                    cur = cur.right;
                    // list.add(cur.val);
                }
            }
        }
        return;
        

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
