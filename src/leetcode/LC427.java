package leetcode;


/**
 *
 *@author JH-Wang
 *@since 2024/7/29 22:42
 */
public class LC427 {
    public static void main(String[] args) {
        int[][] grids = {{1, 1, 0, 0}, {0, 0, 1, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}};
        Solution427 solution427 = new Solution427();
        Solution427.Node construct = solution427.construct(grids);
        System.out.println(construct);
    }
}

class Solution427 {
    public Node construct(int[][] grid) {
        return help(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    private Node help(int[][] grid, int t, int b, int l, int r) {
        if (l == r && t == b) {
            return new Node(grid[t][l] == 1, true);
        }
        Node tl = help(grid, t, (t + b - 1) / 2, l, (l + r - 1) / 2);
        Node tr = help(grid, t, (t + b - 1) / 2, (l + r + 1) / 2, r);
        Node bl = help(grid, (t + b + 1) / 2, b, l, (l + r - 1) / 2);
        Node br = help(grid, (t + b + 1) / 2, b, (l + r + 1) / 2, r);
        if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf && isSame(tl.val, tr.val, bl.val, br.val)) {
            return new Node(grid[t][l] == 1, true);
        }
        return new Node(false, false, tl, tr, bl, br);
    }

    private boolean isSame(boolean b1, boolean b2, boolean b3, boolean b4) {
        return b1 == b2 && b3 == b4 && b1 == b3;
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}

