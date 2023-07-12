package Tree;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int getBinaryTreeDepth(TreeNode node, int level){
        if(node == null){
            return level;
        }
        int left = getBinaryTreeDepth(node.left, level + 1);
        int right = getBinaryTreeDepth(node.right, level + 1);
        return Math.max(left, right);
    }

    // public int amountOfTime(TreeNode root, int start) {
        
    // }
}
public class DepthOfBinaryTree {
    public static TreeNode arrayToBinaryTree(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < nums.length) {
            TreeNode curr = queue.poll();

            if (nums[i] != null) {
                curr.left = new TreeNode(nums[i]);
                queue.offer(curr.left);
            }
            i++;

            if (i < nums.length && nums[i] != null) {
                curr.right = new TreeNode(nums[i]);
                queue.offer(curr.right);
            }
            i++;
        }

        return root;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(5);
        // root.right = new TreeNode(1);
        // root.left.left = new TreeNode(6);
        // root.left.right = new TreeNode(2);
        // root.right.left = new TreeNode(0);
        // root.right.right = new TreeNode(8);
        // root.left.right.left = new TreeNode(7);
        // root.left.right.right = new TreeNode(4);
        Integer[] nums = {1, 5, 3, null, 4, 10, 6, 9, 2};
        TreeNode root = arrayToBinaryTree(nums);
        int height = sol.getBinaryTreeDepth(root, 0);
        System.out.println(height);
    }
}

    //       1
    //     /   \
    //    5     3
    //     \    / \
    //      4  10  6
    //     / \
    //    9   2
