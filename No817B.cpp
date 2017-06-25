#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
#include <unordered_map>
typedef long long ll;
using namespace std;

const int MAX_N = 100000;
int n;
int a [MAX_N];

ll choose(int n, int k) {
  k = min(k, n - k);
  ll x = 1;
  for (ll i = n; i > n - k; i--) {
    x *= i;
  }
  for (int i = k; i >= 2; i--) {
    x /= i;
  }
  return x; 
}

int main() {
  cin >> n;

  unordered_map<int, int> freq_map;
  vector<int> keys;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    
    if (freq_map.count(a[i]) == 0) {
      freq_map[a[i]] = 1;
      keys.push_back(a[i]);
    }
    else {
      freq_map[a[i]]++;    
    }
  }

  sort(keys.begin(), keys.end());
  int left = 3;
  for (int i = 0; i < 3; i++) {
    if (freq_map[keys[i]] >= left) {
      cout << choose(freq_map[keys[i]], left) << endl;
      break;
    } 
    left -= freq_map[keys[i]];
  } 
}
