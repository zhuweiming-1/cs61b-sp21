package cn.zhu;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeightedQuickUnionPathCompressionTest {
    @Test
    public void testQuickUnion() {
        WeightedQuickUnionPathCompression qf = new WeightedQuickUnionPathCompression(1000);
        QuickUnionPathCompressionUF qfuf = new QuickUnionPathCompressionUF(1000);

        int count = 10000;
        for (int i = 0; i < count; i++) {
            int uniform = StdRandom.uniform(4);
            int p = StdRandom.uniform(100);
            int q = StdRandom.uniform(100);
            if (uniform == 0) {
                qf.connect(p, q);
                qfuf.union(p, q);
            } else if (uniform == 1) {
                assertEquals(qfuf.find(p), qf.find(p));
            } else if (uniform == 2) {
                assertEquals(qfuf.count(), qf.count());
            } else if (uniform == 3) {
                assertEquals(qfuf.connected(p, q), qf.isConnected(p, q));
            }
        }

    }
}
