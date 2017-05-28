#include <iostream>
using namespace std;

typedef long long ll;

const ll MOD = 1000000007;
ll n;
ll c = 1, d = 0;

int main() {
  cin >> n;
  for (ll i = 1; i < n; i++) {
    ll temp = c;
    c = (2 * temp + d) % MOD;
    d = (3 * temp) % MOD;
  }
  cout << d << endl;
}
