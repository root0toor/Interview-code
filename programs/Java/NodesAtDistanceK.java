
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public void getParentsByBFS(Map<TreeNode, TreeNode> parent, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    parent.put(curr.left, curr);
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    parent.put(curr.right, curr);
                    queue.offer(curr.right);
                }
            }
        }
    }

    public void getParentsByDFS(Map<TreeNode, TreeNode> parent, TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            parent.put(root.left, root);
        if (root.right != null)
            parent.put(root.right, root);
        getParentsByDFS(parent, root.left);
        getParentsByDFS(parent, root.right);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        getParentsByDFS(parent, root);
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        visited.put(target.val, true);
        queue.offer(target);
        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            if (level == k)
                break;
            level++;
            while (n-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left != null && !visited.containsKey(curr.left.val)) {
                    visited.put(curr.left.val, true);
                    queue.offer(curr.left);
                }
                if (curr.right != null && !visited.containsKey(curr.right.val)) {
                    visited.put(curr.right.val, true);
                    queue.offer(curr.right);
                }
                if (parent.containsKey(curr) && !visited.containsKey(parent.get(curr).val)) {
                    visited.put(parent.get(curr).val, true);
                    queue.offer(parent.get(curr));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }
        return ans;
    }
}

public class NodesAtDistanceK {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        // int target1 = 5;
        int k1 = 2;

        List<Integer> result1 = solution.distanceK(root1, root1.left, k1);
        System.out.println("Output 1: " + result1); // [7, 4, 1]

        // Example 2
        TreeNode root2 = new TreeNode(1);
        // int target2 = 1;
        int k2 = 3;

        List<Integer> result2 = solution.distanceK(root2, root1.right, k2);
        System.out.println("Output 2: " + result2); // []
    }
}
