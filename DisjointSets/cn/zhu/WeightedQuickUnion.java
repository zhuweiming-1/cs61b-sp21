package cn.zhu;

public class WeightedQuickUnion implements UF {
    protected int[] id;
    protected int count;

    public WeightedQuickUnion(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = -1;
        }
    }

    @Override
    public void connect(int p, int q) {
        if (isConnected(p, q)) {
            return;
        }
        int pId = find(p);
        int qId = find(q);
        if (id[pId] <= id[qId]) {
            id[pId] += id[qId];
            id[qId] = pId;
        } else {
            id[qId] += id[pId];
            id[pId] = qId;
        }
        count--;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        int parent = id[p];
        while (parent >= 0) {
            p = parent;
            parent = id[p];
        }
        return p;
    }

    @Override
    public int count() {
        return count;
    }
}
