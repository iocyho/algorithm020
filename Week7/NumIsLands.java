package Week7;

/**
 * @Description LeetCode-200 岛屿数量
 * @Author chenyihao
 * @Date 2021/1/3
 * @Version 1.0
 **/
public class NumIsLands {

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        int result = new NumIsLands().numIslands(grid);
        System.out.println(result);
        assert 3 == result;
    }

    // 通过并查集维护连通分量，岛屿数量 = 连通分量 - 空地
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        // 空地数量
        int space = 0;

        UnionFind unionFind = new UnionFind(rows * columns);
        int[][] directions = {{1, 0},{0, 1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '0') {
                    space++;
                    continue;
                }
                // grid[i][j] == '1'
                for (int[] direction : directions) {
                    // 如果陆地相邻则合并
                    int newX = i + direction[0];
                    int newY = j + direction[1];
                    if (newX < rows && newY < columns && grid[newX][newY] == '1') {
                        unionFind.union(i * columns + j, newX * columns + newY);
                    }
                }
            }
        }
        return unionFind.getCount() - space;
    }

    class UnionFind {

        private int count;
        private int[] parent;

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int getCount() {
            return count;
        }

        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return;
            }

            parent[xRoot] = yRoot;
            count--;
        }
    }
}
