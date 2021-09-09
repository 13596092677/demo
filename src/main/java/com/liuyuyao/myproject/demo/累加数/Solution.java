package com.liuyuyao.myproject.demo.累加数;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/9 9:04 上午
 * @description：
 */
public class Solution {
    List<String> temp = new ArrayList<>();
    public boolean isAdditiveNumber(String num) {
        // TODO
        return dfs(num, 0);
    }

    boolean dfs(String num, int idx) {
        if (idx == num.length()) {
            if (temp.size() >= 3) {
                return true;
            }
            return false;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = idx; i < num.length(); i++) {
            sb.append(num.charAt(i));
            if (isValidNumeric(sb.toString())) {
                temp.add(sb.toString());
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
        // 为了处理一个溢出的过大的整数输入，引入了BigInteger
        BigInteger container = new BigInteger(s);
        if (container.longValue() >= 0) {
            if (temp.size() < 2) {
                return true;
            } else if (new BigInteger(temp.get(temp.size() - 1)).longValue() + new BigInteger(temp.get(temp.size() - 2)).longValue() == container.longValue()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isAdditiveNumber("2461016264268110179");
        System.out.println(res);
    }
}
