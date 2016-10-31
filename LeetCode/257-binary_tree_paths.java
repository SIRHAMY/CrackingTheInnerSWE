/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /**
  * OJ Verified: No
  * 
  * Approach
  * - Recursively iterate over tree
  * - Pass down current tree path to each new level
  * - If no children found, return current path of tree
  * - When recursive functions return, combine them into result list at that level of recursion then pass up again
  * 
  * Efficiency
  * - Time
  * -- Every node is hit once O(n)
  * -- However, within each recursive level, we have to deal with string copies (immutable in Java) and list iteration
  * to add back to result list which could be up to O(h)? each time
  * 
  * - Space
  * -- Recursive call stack
  * -- Up to number of leaves * height of tree * char weight of encoding
  * /
 
public class Solution {
    /**
     * Makes initial call into recursive function
     * 
     */
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> result = new ArrayList();
        
        if(root != null) {
             result = binaryTreePathsHelper(root, root.val + "");
        }
        
        return result;
        
    }
    
    private List<String> binaryTreePathsHelper(TreeNode root, String currTree) {
        List<String> result = new ArrayList();
        
        //If this is a leaf node, return
        if(root.left == null && root.right == null) {
            result.add(currTree);
            return result;
        }
        
        //Check if left node exists and traverse
        if(root.left != null) {
            List<String> left = binaryTreePathsHelper(root.left, currTree + "->" + root.left);
            
            for(String s: left) {
                result.add(s);
            }
        }
        
        //Check if right node exists and traverse
        if(root.right != null) {
            List<String> right = binaryTreePathsHelper(root.right, currTree + "->" + root.right);
            
            for(String s: right) {
                result.add(s);
            }
        }
        
        return result;
    }
}