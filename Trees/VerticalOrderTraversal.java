package Trees;

import java.util.*;

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        Tuple tup = new Tuple(root, 0, 0);
        q.offer(tup);
        while(!q.isEmpty()){
            Tuple temp = q.poll();
            TreeNode node = temp.node;
            int x = temp.col;
            int y = temp.row;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<Integer>());
            }
            map.get(x).get(y).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left, x-1, y+1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right, x+1, y+1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> row : map.values()){
            list.add(new ArrayList<Integer>());
            for(PriorityQueue<Integer> queue : row.values()){
                while(!queue.isEmpty()){
                    list.get(list.size() -1).add(queue.poll());
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

