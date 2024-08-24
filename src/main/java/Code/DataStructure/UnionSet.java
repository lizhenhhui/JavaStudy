package Code.DataStructure;

class UnionSet {
        int[] parent;
        int setCount;

        public UnionSet(int n) {
            parent = new int[n + 1];
            setCount = n;
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        public int find(int u) {
            if (u == parent[u]) {
                return u;
            } else {
                parent[u] = find(parent[u]);
                return parent[u];
            }
        }

        public void join(int u, int v) {
            u = find(u);
            v = find(v);
            if (u == v)
                return;
            parent[v] = u;
            --setCount;
        }

        public boolean isSame(int u, int v) {
            return find(u) == find(v);
        }

        public int getSetCount() {
            return setCount;
        }
    }
