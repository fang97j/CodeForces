#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
string a; 
vector<int> factors [10];
vector<int> x_digits;

int main() {
  factors[0] = vector<int> {};
  factors[1] = vector<int> {};
  factors[2] = vector<int> { 2 };
  factors[3] = vector<int> { 3 };
  factors[4] = vector<int> { 3, 2, 2 };
  factors[5] = vector<int> { 5 };
  factors[6] = vector<int> { 5, 3 };
  factors[7] = vector<int> { 7 };
  factors[8] = vector<int> { 7, 2, 2, 2 };
  factors[9] = vector<int> { 7, 3, 3, 2 };
   
  cin >> n >> a;
  for (char c : a) {
    int i = c - '0';
    for (int j : factors[i]) {
      x_digits.push_back(j);
    } 
  }
  sort(x_digits.begin(), x_digits.end(), greater<int>());
  for (int i : x_digits) {
    cout << i;
  }
  cout << endl;
}
