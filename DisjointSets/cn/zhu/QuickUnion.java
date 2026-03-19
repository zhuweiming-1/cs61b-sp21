package cn.zhu;

public class QuickUnion implements UF {
    private int[] id;
    private int count;

    public QuickUnion(int n) {
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
        id[pId] = qId;
        count--;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        int parent = id[p];
        while (parent != -1) {
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
