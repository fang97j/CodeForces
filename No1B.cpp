#include <iostream>
using namespace std;

int n;
string s;

string int2excel(int i) {
  string s = "";
  while(i > 0) {
    i -= 1;
    int m = i % 26;
    s = (char) ('A' + m) + s;
    i /= 26;
  }
  return s;
}

int excel2int(string s) {
  int i = 0;
  for (char c : s) {
    i *= 26;
    i += (int) (c - 'A' + 1);
  }
  return i;
}

string convert(string s) {
  // find format. excel is type 1, RXCY is type 2
  bool number = false;
  bool letter = false;
  for (char c : s) {
    if ('0' <= c && c <= '9') 
      number = true;
    if ('A' <= c && c <= 'Z' && number) 
      letter = true; 
  }
  int type = letter ? 2 : 1;

  // convert type 1
  if (type == 1) {
    int c_idx = -1;
    for (int i = 0; i < s.length() && c_idx == -1; i++) {
      if ('0' <= s[i] && s[i] <= '9') 
        c_idx = i;
    }
    int C = excel2int(s.substr(0, c_idx));
    int R = stoi(s.substr(c_idx));
    return "R" + to_string(R) + "C" + to_string(C);
  }
  // convert type 2
  else {
    int c_idx = -1;
    for (int i = 0; i < s.length() && c_idx == -1; i++) {
      if (s[i] == 'C') 
        c_idx = i;
    }
    int X = stoi(s.substr(1, c_idx - 1));
    int Y = stoi(s.substr(c_idx + 1));
    return int2excel(Y) + to_string(X);
  }
}

int main() {
  cin >> n;
  while (n-- > 0) {
    cin >> s;
    cout << convert(s) << endl;
  }
}
