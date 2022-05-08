/**
 * Count Nodes Equal to Average of Subtree
Medium

Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.

Note:

The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
A subtree of root is a tree consisting of root and all of its descendants.
 

Example 1:


Input: root = [4,8,5,0,1,null,6]
Output: 5
Explanation: 
For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
For the node with value 0: The average of its subtree is 0 / 1 = 0.
For the node with value 1: The average of its subtree is 1 / 1 = 1.
For the node with value 6: The average of its subtree is 6 / 1 = 6.
Example 2:


Input: root = [1]
Output: 1
Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        
        findAverage(root);
        
        return count;
    }
    
    //return type int[], [0]->totalSum at that node, [1]->total no.of nodes(parent & child) at that node
    public int[] findAverage(TreeNode root){
        
        //if node is null, return sum as 0 and total no.of nodes as 0
        if(root == null)
            return new int[]{0,0};
        
        int[] left = findAverage(root.left);
        int[] right = findAverage(root.right);
        
        int totalSum = left[0]+right[0]+root.val;
        int totalNodes = left[1]+right[1]+1;
        
        if(totalSum/totalNodes == root.val)
            count++;
        
        return new int[]{totalSum, totalNodes};
    }
}