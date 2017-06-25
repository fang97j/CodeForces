#include <iostream>
using namespace std;
typedef long long ll;

const ll MAX_N = 1E18;
ll n, s;

int sum_digits(ll x) {
    int sum = 0;
    while (x != 0) {
        sum += x % 10;
        x /= 10;
    }
    return sum;
}

int main() {
    cin >> n >> s;

    ll lo = 0;
    ll hi = MAX_N / 10 + 1;

    while (lo < hi) {
        ll mid = (hi - lo) / 2 + lo;
        ll diff = 10 * mid - sum_digits(mid);
        if (diff < s) {
            lo = mid + 1;
        }
        else {
            hi = mid;
        }
    }

    if (lo > 1E17 || lo * 10 > n) {
        cout << 0 << endl;
    }
    else {
        cout << (n - lo * 10 + 1) << endl;
    }
}
