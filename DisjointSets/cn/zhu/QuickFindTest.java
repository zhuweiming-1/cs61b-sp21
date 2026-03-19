package cn.zhu;

import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdRandom;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickFindTest {


    @Test
    public void testQuickFind() {
        QuickFind qf = new QuickFind(100);
        QuickFindUF qfuf = new QuickFindUF(100);

        int count = 1000;
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
