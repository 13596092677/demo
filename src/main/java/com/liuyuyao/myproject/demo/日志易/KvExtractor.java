package com.liuyuyao.myproject.demo.日志易;

import java.lang.reflect.Proxy;
import java.util.*;

/**
 * @author ：lyy
 * @date ：Created in 2022/4/25 下午9:19
 * @description：
 */
public class KvExtractor {
    /*
    inputString: k1=v1;k2=v2;k3=v3;k4=v41,v42
    输出的Map有四个kv键值对（->之前为key，之后为value）
    outputString: Map<k1->v1, k2->v2, k3->v3, k4->v41,v42>
    */
    Map<String, String> extract(String inputString) {
        Map<String, String> res = new HashMap<>();
        // 匹配所有成对"的栈
        Stack<Integer> stack = new Stack<>();
        // 存储所有非"之间的;位置
        List<Integer> semicolonPos = new ArrayList<>();
        // 先扫描得到所有"的位置
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == '"' && inputString.charAt(i) != '\\') {
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    stack.pop();
                }
            } else if (inputString.charAt(i) == ';') {
                if (stack.isEmpty()) {
                    semicolonPos.add(i);
                }
            } else if (inputString.charAt(i) == '=') {
                if (stack.isEmpty()) {
                }
            }
        }
        // 根据;位置进行切分成若干子串
        List<String> subStrings = new ArrayList<>();
        for (int i = 0; i < semicolonPos.size(); i++) {
            if (i == 0) {
                subStrings.add(inputString.substring(0, semicolonPos.get(0)));
            } else{
                subStrings.add(inputString.substring(semicolonPos.get(i - 1) + 1, semicolonPos.get(i)));
            }
        }
        subStrings.add(inputString.substring(semicolonPos.get(semicolonPos.size() - 1) + 1));
        for (String pair : subStrings) {
            int firstEquationPos = pair.indexOf("=");
            if (firstEquationPos >= 0) {
                String key = pair.substring(0, firstEquationPos);
                String value = pair.substring(firstEquationPos + 1);
                res.put(key, value);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        KvExtractor kvExtractor = new KvExtractor();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
        kvExtractor.extract(s);
    }
}
