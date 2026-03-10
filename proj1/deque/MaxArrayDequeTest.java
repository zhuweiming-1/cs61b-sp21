package deque;


import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Comparator;

public class MaxArrayDequeTest {

    @Test
    public void testMax() {
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < 10; i++) {
            mad.addLast(i);
        }
        assertEquals(9, mad.max().intValue());
        assertEquals(0, mad.max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }).intValue());
    }
}
