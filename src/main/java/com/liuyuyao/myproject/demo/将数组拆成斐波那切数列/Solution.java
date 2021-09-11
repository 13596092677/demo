package com.liuyuyao.myproject.demo.将数组拆成斐波那切数列;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/10 4:51 下午
 * @description：
 */
public class Solution {
    List<Integer> temp = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    public List<Integer> splitIntoFibonacci(String num) {
        // TODO
        dfs(num, 0);
        return ans;
    }

    boolean dfs(String num, int idx) {
        if (idx == num.length()) {
            if (temp.size() >= 3) {
                ans = new ArrayList<>(temp);
                return true;
            }
            return false;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = idx; i < num.length(); i++) {
            sb.append(num.charAt(i));
            if (isValidNumeric(sb.toString())) {
                temp.add(Integer.parseInt(sb.toString()));
                boolean res = dfs(num, idx + sb.length());
                temp.remove(temp.size() - 1);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isValidNumeric(String s) {
        // 如果前导'0'且该数字不为'0'，则直接返回false
        if (s.length() != 1 && s.charAt(0)=='0') {
            return false;
        }
        try {
            if (Integer.parseInt(s) >= 0) {
                if (temp.size() < 2) {
                    return true;
                } else if (temp.get(temp.size() - 1) + temp.get(temp.size() - 2) == Integer.parseInt(s)) {
                    return true;
                }
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.splitIntoFibonacci("123456579");
        System.out.println(res);
    }
}
