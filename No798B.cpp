#include <iostream>
#include <map>
using namespace std;

const int MAX_N = 51;
int n, m;
string s;
map<string, int> s_freq;

int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> s;
    if (s_freq.count(s) > 0) 
      s_freq[s]++;
    else 
      s_freq[s] = 1;
  }
  m = s.length();
  int min_moves = INT_MAX;
  for (auto p : s_freq) {
    int cnt = 0;
    string j = p.first;
    for (auto q : s_freq) {
      string k = q.first;

      bool matched = false;
      for (int i = 0; i < m; i++) {
        string l = k.substr(i) + k.substr(0, i);
        if (j.compare(l) == 0) {
          matched = true;
          cnt += s_freq[k] * i;
          break;
        }
      }
      if (!matched) 
        goto failed;
    }
    min_moves = min(min_moves, cnt);
  }
  cout << min_moves << endl;
  return 0;

failed:
  cout << -1 << endl;
}
