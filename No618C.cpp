#include <iostream>
using namespace std;
typedef long long ll;

struct pt {
  ll x, y, idx;

  pt(ll x, ll y, ll idx) : x(x), y(y), idx(idx) {}
};

ll n, x, y;

ll dist(pt a, pt b) {
  return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
}

ll cross(pt a, pt b, pt c) {
  ll z = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
  return z > 0 ? z : -z;
}

int main() {
  cin >> n;
  
  cin >> x >> y;
  pt a(x, y, 1);
  cin >> x >> y;
  pt b(x, y, 2);

  pt c(0, 0, 0);
  ll area = -1; 

  for (ll i = 2; i < n; i++) {
    cin >> x >> y;
    pt t (x, y, i + 1); 
    ll z = cross(a, b, t);   

    // if t is on ab line and t is closer to a, replace b with t
    if (z == 0 && dist(a, t) < dist(a, b)) {
      b = t; 
      if (area != -1) {
        area = cross(a, b, c);
      }
    }
    // if abt is a smaller triangle than abc, replace c with t
    if (z != 0 && (area == -1 || z < area)) {
      c = t; 
      area = z;
    }
  }

  cout << a.idx << " " << b.idx << " " << c.idx << endl;
}
