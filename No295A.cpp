#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;

struct op {
  ll l, r, d;
  op() {}
  op(ll l, ll r, ll d) : l(l), r(r), d(d) {}
};
struct query {
  ll x, y;
  query() {}
  query(ll x, ll y) : x(x), y(y) {}
};

const ll MAX_VAL = 100001;
ll n, m, k, l, r, d, x, y;
ll a[MAX_VAL], op_delta[MAX_VAL], val_delta[MAX_VAL];
op ops[MAX_VAL];
query queries[MAX_VAL];

int main() {
  for (ll i = 0; i < MAX_VAL; i++) {
    op_delta[i] = 0;
    val_delta[i] = 0;
  }

  cin >> n >> m >> k;
  for (ll i = 1; i <= n; i++) {
    cin >> a[i];
  }
  for (ll i = 1; i <= m; i++) {
    cin >> l >> r >> d;
    ops[i] = op(l, r, d);
  }
  for (ll i = 1; i <= k; i++) {
    cin >> x >> y;
    queries[i] = query(x, y);
  }

  // condense queries
  for (ll i = 1; i <= k; i++) {
    query q = queries[i];
    op_delta[q.x - 1]++;
    op_delta[q.y]--;    
  }
  // condense ops
  ll delta = op_delta[0];
  for (ll i = 1; i <= m; i++) {
    op o = ops[i];
    val_delta[o.l - 1] += o.d * delta;
    val_delta[o.r] -= o.d * delta;
    delta += op_delta[i];
  }

  delta = val_delta[0];
  for (ll i = 1; i < n; i++) {
    cout << a[i] + delta << " ";
    delta += val_delta[i];
  }
  cout << a[n] + delta << endl;
}
