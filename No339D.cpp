#include <iostream>
#include <math.h>
using namespace std;

const int MAX_A = 131072;
int n, m, p, b;
int a[MAX_A];
int tree [131075];

void init() {
  for (int i = 0; i < pow(2, n); i++) {
    tree[(int) (pow(2, n) + i)] = a[i];
  } 
  int ptr = pow(2, n) - 1;
  int e = n - 1;
  while (e >= 0) {
    for (int i = 0; i < pow(2, e); i++) {
      int l = tree[2 * ptr];
      int r = tree[2 * ptr + 1];
      tree[ptr--] = ((n - e) & 1) == 1 ? l | r : l ^ r;
    }
    e--;
  }
}

void update(int p, int b) {
  int c = pow(2, n) + p - 1;
  tree[c] = b;

  c >>= 1;
  int e = n - 1;
  while (e >= 0) {
    int l = tree[2 * c];
    int r = tree[2 * c + 1];
    tree[c] = ((n - e) & 1) == 1 ? l | r : l ^ r;
    c >>= 1;
    e--;
  }
}

int main() {
  cin >> n >> m;
  for (int i = 0; i < pow(2, n); i++) {
    cin >> a[i]; 
  }
  init();
  for (int i = 0; i < m; i++) {
    cin >> p >> b;
    update(p, b);
    cout << tree[1] << endl;
  }
}
