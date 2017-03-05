#include <iostream>
#include <unordered_set>

using namespace std;

int n, m;
string h_str, v_str;
unordered_set<int> visited;

bool in_bounds(int r, int c) {
    return 0 <= r && r < n && 0 <= c && c < m;
}

void flood(int idx) {
    visited.insert(idx);

    int r = idx / m;
    int c = idx % m;

    // look left/right
    int lr_dir = h_str[r] == '>' ? 1 : -1;
    int lr_spot = idx + lr_dir;
    if (in_bounds(r, c + lr_dir) && visited.find(lr_spot) == visited.end()) {
        flood(lr_spot);
    }

    // look up/down
    int ud_dir = v_str[c] == '^' ? -1 : 1;
    int ud_spot = (r + ud_dir) * m + c;
    if (in_bounds(r + ud_dir, c) && visited.find(ud_spot) == visited.end()) {
        flood(ud_spot);
    }
}

int main() {
    cin >> n >> m;
    cin >> h_str >> v_str;

    bool connected = true;
    for (int i = 0; i < n * m; i++) {
        visited = {};
        flood(i);
        if (visited.size() != n * m) {
            connected = false;
            break;
        }
    }

    cout << (connected ? "YES" : "NO") << endl;
}