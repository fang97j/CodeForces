#include <iostream>
#include <vector>
using namespace std;

vector<vector<int> > map;
int n, x;

int main() {
  map.push_back(vector<int> { 0, 1, 2 });
  map.push_back(vector<int> { 1, 0, 2 });
  map.push_back(vector<int> { 1, 2, 0 });
  map.push_back(vector<int> { 2, 1, 0 });
  map.push_back(vector<int> { 2, 0, 1 });
  map.push_back(vector<int> { 0, 2, 1 });

  cin >> n >> x;
  n %= 6; 
  cout << map[n][x] << endl;
}
