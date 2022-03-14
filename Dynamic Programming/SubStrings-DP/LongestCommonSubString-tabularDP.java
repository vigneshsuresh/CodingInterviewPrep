/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none)
deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.


Approach - DP tabular version
 */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        //create 2-D array with +1 because we start with index 1 on the iteration
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        int longest=0;
        

        for(int i=1;i<=text1.length();i++){
            for(int j=1; j<=text2.length(); j++){

                //compare the characters, if equal, increment the current tabular value by 1 with previous value
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); //find the max of one row down/col down
                
                // update longest if we find any max value than previous
                longest = Math.max(longest, dp[i][j]);
            }
        }
        
        return longest;
    }
}