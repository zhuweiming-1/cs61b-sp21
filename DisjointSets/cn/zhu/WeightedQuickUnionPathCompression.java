package cn.zhu;

public class WeightedQuickUnionPathCompression extends WeightedQuickUnion {

    public WeightedQuickUnionPathCompression(int n) {
        super(n);
    }

    @Override
    public int find(int p) {
        int root = super.find(p);
        while (p != root) {
            int tmp = p;
            p = id[p];
            id[tmp] = root;
        }
        return root;
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
}
