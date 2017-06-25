#include <iostream>
#include <cmath>
using namespace std;

int x_1, y_1, x_2, y_2, x, y;
int main() {
  cin >> x_1 >> y_1 >> x_2 >> y_2 >> x >> y;

  int x_diff = abs(x_1 - x_2);
  int y_diff = abs(y_1 - y_2);

  if ((x_diff % x != 0) || (y_diff % y != 0)) {
    cout << "NO" << endl;
    return 0;
  }


  int steps = x_diff / x + y_diff / y;

  cout << ((steps % 2 == 0) ? "YES" : "NO") << endl;
}
