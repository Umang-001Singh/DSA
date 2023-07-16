package Trees;

import java.util.*;


public class TopView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        

        ArrayList<Integer> ans = new ArrayList<>();
        ans.addAll(Top(root));
        System.out.println(ans);
    }

    public static ArrayList<Integer> Top(TreeNode root){
        Tuple tup = new Tuple(root, 0, 0);
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(tup);
        while(!q.isEmpty()){
            Tuple temp = q.poll();
            TreeNode node = temp.node;
            int y = temp.row;
            int x = temp.col;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
                if(!map.get(x).containsKey(y)){
                    map.get(x).put(y, new PriorityQueue<>());
                    map.get(x).get(y).offer(node.val);
                }
            }

            if(node.left != null){
                q.offer(new Tuple(node.left, x-1, y+1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right, x+1, y+1));
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> row : map.values()){
            for(PriorityQueue<Integer> queue : row.values()){
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
            this.col = _col;
            this.row = _row;
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
