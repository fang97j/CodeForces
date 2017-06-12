#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

const int BIG_NUM = 1000000;
const int MAX_N = 105;
int n, m, a, b, p, q;
int res [2 * MAX_N][2 * MAX_N];
bool added [2 * MAX_N];
int parent [2 * MAX_N];

bool bfs() {
  memset(added, false, sizeof(added[0]) * 2 * MAX_N);
  memset(parent, -1, sizeof(parent[0]) * 2 * MAX_N);

  queue<int> q;
  parent[0] = -1;
  added[0] = true;
  q.push(0);

  while (!q.empty()) {
    int x = q.front();
    q.pop();

    for (int i = 0; i <= 2 * n + 1; i++) {
      if (res[x][i] > 0 && !added[i]) {
        parent[i] = x;
        added[i] = true;
        q.push(i);
      }      
    }
  } 
  return parent[2 * n + 1] != -1;
}

int main() {
  memset(res, 0, sizeof(res[0][0]) * 4 * MAX_N * MAX_N);

  cin >> n >> m;
  int s = 0, t = 2 * n + 1, x = 0;
  int a_sum = 0, b_sum = 0;

  // read input
  for (int i = 1; i <= n; i++) {
    cin >> x;
    res[0][i] = x;
    a_sum += res[0][i];
  }
  for (int i = 1; i <= n; i++) {
    cin >> x;
    res[n + i][t] = x;
    b_sum += x;
  }
  if (a_sum != b_sum) {
    cout << "NO" << endl;
    return 0;
  }

  // connect 'old' and 'new' nodes
  for (int i = 1; i <= n; i++) 
    res[i][i + n] = BIG_NUM;

  for (int i = 0; i < m; i++) {
    cin >> p >> q; 
    res[p][q + n] = BIG_NUM;
    res[q][p + n] = BIG_NUM;
  }

  int flow = 0;
  while(bfs()) {
    int f = INT_MAX;

    // find bottleneck
    for (int c = 2 * n + 1; parent[c] != -1; c = parent[c]) 
      f = min(f, res[parent[c]][c]);      

    // update res graph
    for (int c = 2 * n + 1; parent[c] != -1; c = parent[c]) {
      res[parent[c]][c] -= f;
      res[c][parent[c]] += f;
    }
    flow += f;
  }

  if (flow != b_sum) {
    cout << "NO" << endl;
    return 0;
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) {
    for (int j = 1 + n; j <= 2 * n; j++) {
      cout << res[j][i] << " ";
    }
    cout << endl;
  }
  return 0;
}
