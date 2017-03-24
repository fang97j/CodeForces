#include <iostream>
#include <unordered_set>

using namespace std;

int n;
int a [100000];
int dp [100000];

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    for (int i = n - 1; i >= 0; i--) {
        if (i < n - 1 && a[i] < a[i + 1]) {
            dp[i] = dp[i + 1] + 1;
        }
        else {
            dp[i] = 1;
        }
    }

    int longest = 0;
    for (int i = 0; i < n; i++) {
        if (i + dp[i] < n) {
            longest = max(longest, dp[i] + 1);
            if (i + dp[i] + 1 < n && a[i + dp[i] + 1] - a[i + dp[i] - 1] > 1) {
                longest = max(longest, dp[i] + 1 + dp[i + dp[i] + 1]);
            }
            if (a[i + dp[i]] - a[i + dp[i] - 2] > 1) {
                longest = max(longest, dp[i] + dp[i + dp[i]]);
            }
        }
        if (i < n - 1) {
            longest = max(longest, 1 + dp[i + 1]);
        }

        longest = max(longest, dp[i]);
    }
    cout << longest;
}