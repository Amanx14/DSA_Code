import java.util.ArrayList;

public class RatInMaze {
     public static void solve(int[][] mat, int vis[][], int i, int j, String newStr, ArrayList<String> ans) {
        int n = mat.length, m = mat[0].length;
        // base case
        if(i == n-1 && j == m-1) {
            ans.add(newStr);
            return;
        }
        
        // downward 
        if(i<n-1 && vis[i+1][j] == 0 && mat[i+1][j] == 1) {
            vis[i][j] = 1;
            solve(mat, vis, i+1, j, newStr + "D", ans);
            vis[i][j] = 0;
        }
        
        // left
        if(j>0 && vis[i][j-1] == 0 && mat[i][j-1] == 1) {
            vis[i][j] = 1;
            solve(mat, vis, i, j-1, newStr + "L", ans);
            vis[i][j] = 0;
        }
        
        // right
        if(j<m-1 && vis[i][j+1] == 0 && mat[i][j+1] == 1) {
            vis[i][j] = 1;
            solve(mat, vis, i, j+1, newStr + "R", ans);
            vis[i][j] = 0;
        }
        
        // upward
        if(i>0 && vis[i-1][j] == 0 && mat[i-1][j] == 1) {
            vis[i][j] = 1;
            solve(mat, vis, i-1, j, newStr + "U", ans);
            vis[i][j] = 0;
        }
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        int vis[][] = new int[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                vis[i][j] = 0;
            }
        }
        
        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0] == 1) {
            solve(m, vis, 0, 0, "", ans);
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int N = 4;
        int maze[][] = {{1, 0, 0, 0},
                        {1, 1, 0, 1}, 
                        {1, 1, 0, 0},
                        {0, 1, 1, 1}};

        ArrayList<String> ways = findPath(maze, N);
        System.out.println(ways);
    }
}
