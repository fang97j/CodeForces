#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

class interval {
public:
    int a, b;
    bool visited;
    unordered_set<interval*> neighbors;

    interval(int a, int b) : a(a), b(b), visited(false) {}
};

bool hasPath(interval* src, interval* dst) {
    src->visited = true;
    if (src == dst) {
        return true;
    }
    for (auto iterator = src->neighbors.begin(); iterator != src->neighbors.end(); iterator++) {
        if (!(*iterator)->visited && hasPath(*iterator, dst)) {
            return true;
        }
    }
    return false;
}

int n;

int main() {
    cin >> n;
    vector<interval*> graph;

    for (int i = 0; i < n; i++) {
        int q, x, y;
        cin >> q >> x >> y;

        if (q == 1) {
            interval* i = new interval(x, y);

            for (auto iterator = graph.begin(); iterator != graph.end(); iterator++) {
                interval* o = *iterator;
                if ((o->a < x && x < o->b) || (o->a < y && y < o->b)) {
                    i->neighbors.insert(o);
                }
                if ((x < o->a && o->a < y) || (x < o->b && o->b < y)) {
                    o->neighbors.insert(i);
                }
            }
            graph.push_back(i);
        }
        else {
            interval* src = graph.at(x - 1);
            interval* dest = graph.at(y - 1);

            for (auto iterator = graph.begin(); iterator != graph.end(); iterator++) {
                (*iterator)->visited = false;
            }

            string answer = hasPath(src, dest) ? "YES" : "NO";
            cout << answer << endl;
        }
    }
}

