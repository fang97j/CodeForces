#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

const int MAX_N = 100001;
int n, k;
int p [MAX_N];

int gcd (int a, int b) {
  while (b != 0) {
    int t = b;
    b = a % b;
    a = t;
  }
  return a;
}

int main() {
  cin >> n >> k;

  if (k == n) {
    cout << -1 << endl;
  }
  else {
    for (int i = n - k + 1; i <= n; i++) {
      p[i] = i;
    }
    for (int i = 2; i < n - k + 1; i++) {
      p[i] = i - 1; 
    }
    p[1] = n - k;
    for (int i = 1; i < n; i++) {
      cout << p[i] << " ";
    }
    cout << p[n] << endl;
  }
}
