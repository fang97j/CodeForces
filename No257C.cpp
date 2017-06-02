#include <iostream>
#include <iomanip>
#include <math.h>
#include <vector>
#include <algorithm>

#define PI 3.14159265358979323846
using namespace std;

struct pt {
  int x, y;
  pt(int x, int y) : x(x), y(y) {}
};

int n;
vector<pt> pos_pts; // [0, 180)
vector<pt> neg_pts; // [180, 360)
vector<pt> all_pts; 

// + if CCW, - if CW, 0 is colinear
int orientation(pt a, pt b, pt c) {
  return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
}

int main() {
  pt o(0, 0);

  cin >> n;
  for (int i = 0; i < n; i++) {
    int x, y;
    cin >> x >> y;

    if (y > 0 || (y == 0 && x > 0)) {
      pos_pts.push_back(pt(x, y));
    }
    else if (y < 0 || (y == 0 && x < 0)) {
      neg_pts.push_back(pt(x, y));
    }
  }

  sort(pos_pts.begin(), pos_pts.end(), [o] (pt a, pt b) { return orientation(o, a, b) > 0; });
  sort(neg_pts.begin(), neg_pts.end(), [o] (pt a, pt b) { return orientation(o, a, b) > 0; });

  // merge points
  for (pt p : pos_pts) {
    all_pts.push_back(p);
  }
  for (pt p : neg_pts) {
    all_pts.push_back(p);
  }
  
  double theta = 361;
  for (int i = 0; i < all_pts.size(); i++) {
    int j = (i + 1) % all_pts.size();

    pt I = all_pts[i];
    pt J = all_pts[j];

    double det = I.x * J.y - I.y * J.x;
    double dot = I.x * J.x + I.y * J.y;

    // clockwise angle i to j
    double t = atan2(det, dot) * 180.0 / PI;
    if (t < 0)
      t += 360;

    // make anti-clockwise
    theta = min(theta, 360 - t);
  }
  if (theta >= 360)
    theta = 0;
  cout << fixed << setprecision(10) << theta << endl;
}
