package Trees;

import java.util.*;


public class RightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right= new TreeNode(2);

        ArrayList<Integer> ans = new ArrayList<>();
        ans.addAll(Right(root));
        System.out.println(ans);
    }

    public static ArrayList<Integer> Right(TreeNode root){
        TreeMap<Integer, TreeMap<Integer ,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        Tuple tup = new Tuple(root, 0, 0);
        q.offer(tup);
        while(!q.isEmpty()){
            Tuple temp = q.poll();
            TreeNode node = temp.node;
            int x = temp.col;
            int y = temp.row;

            if(!map.containsKey(y)){
                map.put(y, new TreeMap<>());
                if(!map.get(y).containsKey(x)){
                    map.get(y).put(x, new PriorityQueue<>());
                    map.get(y).get(x).offer(node.val);
                }
            }

            if(node.right != null){
                q.offer(new Tuple(node.right, x + 1, y+1));
            }
            if(node.left != null){
                q.offer(new Tuple(node.left, x - 1, y+1));
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> col : map.values()){
            for(PriorityQueue<Integer> queue : col.values()){
                while(!queue.isEmpty()){
                    list.add(queue.poll());
                }
            }
        }
        
        return list;
    }

    static class Tuple{
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode _node, int _col, int _row){
            this.node = _node;
            this.row = _row;
            this.col = _col;
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
