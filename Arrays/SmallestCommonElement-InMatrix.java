/**
 * Given an m x n matrix mat where every row is sorted in strictly increasing order, 
 * return the smallest common element in all rows.

If there is no common element, return -1.

 

Example 1:

Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
Output: 5
Example 2:

Input: mat = [[1,2,3],[2,3,4],[2,3,5]]
Output: 2
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 500
1 <= mat[i][j] <= 104
mat[i] is sorted in strictly increasing order.

 */

class Solution {
    public int smallestCommonElement(int[][] mat) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(!map.containsKey(mat[i][j]))
                    map.put(mat[i][j],1);
                else
                    map.put(mat[i][j],map.get(mat[i][j])+1);
            }
        }
        
        for(Map.Entry<Integer,Integer> set: map.entrySet()){
            if(set.getValue() == mat.length)
                return set.getKey();
        }
        return -1;
    }
}