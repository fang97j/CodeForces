#include <iostream>
#include <cstring>
#include <queue>
using namespace std;

const int MAX_N = 405;
int n, m, u, v;
int dists [MAX_N];
int adj_matrix [MAX_N][MAX_N];  // road = 0, railroad = 1

int main() {
  memset(adj_matrix, 0, sizeof(adj_matrix[0][0]) * MAX_N * MAX_N);
  memset(dists, -1, sizeof(dists[0]) * MAX_N);

  cin >> n >> m;
  while (m-- > 0) {
    cin >> u >> v;
    adj_matrix[u][v] = 1;
    adj_matrix[v][u] = 1;
  }
  
  int type = adj_matrix[1][n] ^ 1;
  queue<int> q;
  q.push(1);
  dists[1] = 0;
  
  while (!q.empty()) {
    int x = q.front();
    q.pop();

    for (int i = 1; i <= n; i++) {
      if (adj_matrix[x][i] == type && dists[i] == -1) {
        dists[i] = dists[x] + 1;
        q.push(i); 
      }
    }
  } 
  cout << dists[n] << endl;
}
