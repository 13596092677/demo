package com.liuyuyao.myproject.demo;

import java.util.*;

/**
 * @author : mi
 * create at:  2021/5/24  下午8:41
 * @description:
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