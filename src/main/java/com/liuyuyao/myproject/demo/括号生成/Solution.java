package com.liuyuyao.myproject.demo.括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/8 9:43 上午
 * @description：
 */
public class Solution {
    StringBuffer parenthesis = new StringBuffer();
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n);
        return ans;
    }

    void dfs(int leftCnt, int rightCnt) {
        if (leftCnt == 0 && rightCnt == 0) {
            ans.add(new String(parenthesis));
            return;
        }
        if (leftCnt == rightCnt) {
            parenthesis = parenthesis.append('(');
            dfs(leftCnt - 1, rightCnt);
            parenthesis.deleteCharAt(parenthesis.length() - 1);
        } else{
            if (leftCnt > 0) {
                parenthesis = parenthesis.append('(');
                dfs(leftCnt - 1, rightCnt);
                parenthesis.deleteCharAt(parenthesis.length() - 1);
            }
            if (rightCnt > 0) {
                parenthesis = parenthesis.append(')');
                dfs(leftCnt, rightCnt - 1);
                parenthesis.deleteCharAt(parenthesis.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.generateParenthesis(2);
        System.out.println(res);
    }
}
