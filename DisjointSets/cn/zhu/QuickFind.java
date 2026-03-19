package cn.zhu;

public class QuickFind implements UF {

    private int[] uf;
    private int count = 0;

    public QuickFind(int n) {
        uf = new int[n];
        count=n;
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
    }

    @Override
    public void connect(int p, int q) {
        if (isConnected(p, q)) {
            return;
        }
        int pComponent = find(p);
        int qComponent = find(q);
        for (int i = 0; i < uf.length; i++) {
            if (uf[i] == pComponent) {
                uf[i] = qComponent;
            }
        }
        count--;

    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        return uf[p];
    }

    @Override
    public int count() {
        return count;
    }
}
