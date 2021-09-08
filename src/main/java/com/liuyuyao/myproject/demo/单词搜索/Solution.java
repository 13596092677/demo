package com.liuyuyao.myproject.demo.单词搜索;

import javax.jws.soap.SOAPBinding;

/**
 * @author ：lyy
 * @date ：Created in 2021/9/8 12:04 下午
 * @description：
 */
public class Solution {
    StringBuffer temp = new StringBuffer();
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        int[][] visited = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, visited, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int[][] visited, String word, int row, int col, int idx) {
        if (word.equals(temp.toString())) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (visited[row][col] == 1) {
            return false;
        }
        if (board[row][col] == word.charAt(idx)) {
            temp.append(board[row][col]);
            visited[row][col] = 1;
            boolean up = dfs(board, visited, word, row - 1, col, idx + 1);
            temp.deleteCharAt(temp.length() - 1);
            visited[row][col] = 0;
            if (up) {
                return true;
            }
            temp.append(board[row][col]);
            visited[row][col] = 1;
            boolean down = dfs(board, visited, word, row + 1, col, idx + 1);
            temp.deleteCharAt(temp.length() - 1);
            visited[row][col] = 0;
            if (down) {
                return true;
            }
            temp.append(board[row][col]);
            visited[row][col] = 1;
            boolean left = dfs(board, visited, word, row, col - 1, idx + 1);
            temp.deleteCharAt(temp.length() - 1);
            visited[row][col] = 0;
            if (left) {
                return true;
            }
            temp.append(board[row][col]);
            visited[row][col] = 1;
            boolean right = dfs(board, visited, word, row, col + 1, idx + 1);
            temp.deleteCharAt(temp.length() - 1);
            visited[row][col] = 0;
            if (right) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE");
        System.out.println(res);
    }
}
