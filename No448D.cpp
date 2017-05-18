#include <iostream>
using namespace std;

typedef long long ll;

ll n, m, k;

ll min(ll a, ll b) {
  return a < b ? a : b;
}

int main() {
  cin >> n >> m >> k; 
  ll lo = 1;
  ll hi = n * m;

  while (lo < hi) {
    ll mid = (lo + hi) / 2;
    ll ctr = 0;
    for (long i = 1; i <= n; i++) {
      ctr += min(m, mid / i);
    }

    if (ctr < k)
      lo = mid + 1;
    else
      hi = mid;
  }
  cout << lo << endl;
}
