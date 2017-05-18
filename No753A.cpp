#include <iostream>

using namespace std;

int n;

int main() {
  cin >> n;

  int k = 1;
  while ((k + 1) * (k + 2) / 2 <= n) {
    k++;
  }

  cout << k << endl;
  for (int i = 1; i < k; i++) {
    cout << i << " ";
  }
  cout << n - k*(k - 1)/2 << endl;
}
