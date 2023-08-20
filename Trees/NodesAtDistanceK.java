package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Trees.BalancedBT.TreeNode;

public class NodesAtDistanceK {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        // TreeNode target = new TreeNode(5);
        List<Integer> ans = nodesAtK(root, root.left, 2);
        System.out.println(ans);
    }

    public static void parent_track(TreeNode node, HashMap<TreeNode, TreeNode> par_track){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i= 0;i<size;i++){
                TreeNode current = q.poll();
                if(current.left != null){
                    par_track.put(current.left, current);
                    q.offer(current.left);
                }
                if(current.right != null){
                    par_track.put(current.right, current);
                    q.offer(current.right);
                }
            }
        }
        // System.out.println(par_track);
    }

    public static List<Integer> nodesAtK(TreeNode node, TreeNode target, int tar){
        HashMap<TreeNode, TreeNode> par_track = new HashMap<>();
        parent_track(node, par_track);
        // System.out.println(par_track);
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int cur_level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(cur_level == tar){
                break;
            }
            cur_level++;
            for(int i = 0;i<size;i++){
                TreeNode current = q.poll();
                if(current.left != null && visited.get(current.left) == null){
                    visited.put(current.left, true);
                    q.offer(current.left);
                }

                if(current.right != null && visited.get(current.right) == null){
                    visited.put(current.right, true);
                    q.offer(current.right);
                }

                if(par_track.get(current) != null && visited.get(par_track.get(current)) == null){
                    visited.put(par_track.get(current), true);
                    q.offer(par_track.get(current));
                }
                // System.out.println(visited);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode temp =  q.poll();
            int val = temp.val;
            // System.out.println(val);
            ans.add(val);
            // System.out.println(ans);
        }
        return ans;
    }
}
