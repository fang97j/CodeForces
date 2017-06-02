#include <iostream>
#include <vector>
#include <set>
using namespace std;

struct pt {
  int x, y;
  pt(int x, int y) : x(x), y(y) {}
};

const int MAX_N = 1000;
int n, x, y;
vector<pt> pts;

// - if CCW, + if CW, 0 if colinear
int orientation(pt a, pt b, pt c) {
  return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
}

int main() {
  cin >> n >> x >> y;
  pt g (x, y);

  for (int i = 0; i < n; i++) {
    cin >> x >> y;
    pts.push_back(pt(x, y));
  }

  int c = 0;
  for (int i = 0; i < pts.size(); i++) {
    if (pts[i].x == g.x && pts[i].y == g.y) 
      continue;

    c++;
    for (int j = i + 1; j < pts.size(); j++) {
      if (orientation(g, pts[i], pts[j]) == 0) {
        pts[j].x = g.x;
        pts[j].y = g.y;
      }
    }
  }

  cout << c << endl;
}
