package Solved;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2B {
  public static void main(String[] args) throws IOException {
    No2B program = new No2B();
    program.solve();

  }

  int n;
  
  public void solve() throws IOException {
    // BufferedReader f = new BufferedReader(new FileReader("C:/Users/John/workspace/CodeForces/src/input.txt"));
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(f.readLine());
    
    
    int[][] min2s = new int[n][n];
    int[][] min5s = new int[n][n];
    
    boolean zero = false;
    int zR = 0;
    
    for (int r = 0; r < n; r++) {
      String[] nums = f.readLine().split("\\s+");
      for (int c = 0; c < n; c++) {
        int val = Integer.parseInt(nums[c]);
        if (val == 0) {
          zero = true;
          zR = r;
        }

        int[] d = decompose(val);
        if (r == 0 && c == 0) {
          min2s[r][c] = d[0];
          min5s[r][c] = d[1];
        }
        else if (r == 0) {
          min2s[r][c] = min2s[r][c - 1] + d[0];
          min5s[r][c] = min5s[r][c - 1] + d[1];
        }
        else if (c == 0) {
          min2s[r][c] = min2s[r - 1][c] + d[0];
          min5s[r][c] = min5s[r - 1][c] + d[1];
        }
        else {
          min2s[r][c] = Math.min(min2s[r][c - 1] + d[0], min2s[r - 1][c] + d[0]);
          min5s[r][c] = Math.min(min5s[r][c - 1] + d[1], min5s[r - 1][c] + d[1]);
        }
      }
    }
    
    int endNo2s = min2s[n - 1][n - 1];
    int endNo5s = min5s[n - 1][n - 1];
    
    int best = Math.min(zero ? 1 : Integer.MAX_VALUE, Math.min(endNo2s, endNo5s));
    if (zero && best == 1) {
      System.out.println(1);
      StringBuilder answer = new StringBuilder();
      for (int i = 0; i < zR; i++) {
        answer.append('D');
      }
      for (int i = 0; i < n - 1; i++) {
        answer.append('R');
      }
      for (int i = 0; i < n - 1 - zR; i++) {
        answer.append('D');
      }
      System.out.println(answer);
    }
    else if (endNo2s <= endNo5s) {
      System.out.println(endNo2s);
      System.out.println(buildPath(n - 1, n - 1, min2s));
    }
    else {
      System.out.println(endNo5s);
      System.out.println(buildPath(n - 1, n - 1, min5s));
    }
  }

  int[] decompose(int i) {
    int temp = i;
    int no2s = 0, no5s = 0;
    
    if (i == 0) return new int[] { 0, 0 };
    
    while (temp % 5 == 0) {
      temp /= 5;
      no5s++;
    }
    while (temp % 2 == 0) {
      temp /= 2;
      no2s++;
    }
    return new int[] { no2s, no5s };
  }
  
  StringBuilder buildPath(int r, int c, int[][] dp) {
    StringBuilder answer = new StringBuilder();
    if (r == 0) {
      for (int i = 0; i < c; i++) {
        answer.append('R');
      }
    }
    else if (c == 0) {
      for (int i = 0; i < r; i++) {
        answer.append('D');
      }
    }
    else {
      if (dp[r - 1][c] < dp[r][c - 1]) {
        answer.append(buildPath(r - 1, c, dp));
        answer.append('D');
      }
      else {
        answer.append(buildPath(r, c - 1, dp));
        answer.append('R');
      }
    }
    return answer;
  }
}