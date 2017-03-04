#include <iostream>
#include <iterator>
#include <algorithm>
#include <math.h>

using namespace std;

int n, q;

int binSearch(int array[], int val) {
    int lo = 0, hi = n - 1;

    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (array[mid] <= val) {
            if (mid == n - 1 || val < array[mid + 1]) {
                return mid;
            }
            else {
                lo = mid + 1;
            }
        }
        else {
            hi = mid - 1;
        }
    }
    return -1;
}

int main() {
    cin >> n;
    int x [n];
    for (int i = 0; i < n; i++) {
        cin >> x[i];
    }
    sort(x, x + n);

    cin >> q;
    int m;
    for (int i = 0; i < q; i++) {
        cin >> m;
        cout << binSearch(x, m) + 1 << endl;
    }
}