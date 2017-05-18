#include <iostream>

using namespace std;

int n, a, b;
string s;

int main() {
  cin >> n >> a >> b >> s;

  int cost = s[a - 1] == s[b - 1] ? 0 : 1;
  cout << cost << endl;
}
