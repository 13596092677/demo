package com.liuyuyao.myproject.demo.柠檬水找零;

/**
 * @author ：lyy
 * @date ：Created in 2022/5/6 下午6:06
 * @description：
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[3];
        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5:
                    ++change[0];
                    break;
                case 10:
                    if (change[0] == 0) {
                        return false;
                    } else {
                        --change[0];
                        ++change[1];
                    }
                    break;
                case 20:
                    if (change[1] >= 1 && change[0] >= 1) {
                        --change[0];
                        --change[1];
                        ++change[2];
                    } else if (change[0] >= 3) {
                        change[0] -= 3;
                        ++change[2];
                    } else {
                        return false;
                    }
            }
        }
        return true;
    }
}
