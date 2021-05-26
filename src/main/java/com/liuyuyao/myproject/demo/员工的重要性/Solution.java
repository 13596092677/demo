package com.liuyuyao.myproject.demo.员工的重要性;

import java.util.*;

/**
 * @author : mi
 * create at:  2021/5/24  下午8:41
 * @description: 给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
 *
 * 比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
 *
 * 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/employee-importance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    Map<Integer, Employee> indexMap = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            indexMap.put(employee.id, employee);
        }
        return dfs(id);
    }

    public int dfs(Integer id) {
        Employee employee = indexMap.get(id);
        List<Integer> subordinates = employee.subordinates;
        int total = employee.importance;
        for (Integer subordinate : subordinates) {
            total += dfs(subordinate);
        }
        return total;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(101, 3, Arrays.asList());
        Employee employee2 = new Employee(2, 5, Arrays.asList(101));
        Solution solution = new Solution();
        int importance = solution.getImportance(Arrays.asList(employee1, employee2), 2);
        System.out.println(importance);
    }
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }
}