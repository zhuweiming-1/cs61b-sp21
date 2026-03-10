package deque;


import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.LinkedList;


import static org.junit.Assert.*;


/**
 * Performs some basic linked list tests.
 */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {


        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double> lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }

    @Test
    public void testAddFirst() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        assertTrue(lld.isEmpty());
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);
        assertFalse(lld.isEmpty());

        assertEquals(3, lld.size());
        assertEquals("3 2 1", lld.toString());
        lld.printDeque();
    }

    @Test
    public void testAddLast() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        assertTrue(lld.isEmpty());
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        assertFalse(lld.isEmpty());

        assertEquals(3, lld.size());
        assertEquals("1 2 3", lld.toString());
        lld.printDeque();
    }

    @Test
    public void testRemoveFirst() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        assertTrue(lld.isEmpty());
        lld.printDeque();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        assertFalse(lld.isEmpty());

        assertEquals(3, lld.size());
        assertEquals("1 2 3", lld.toString());
        lld.printDeque();
        assertEquals(1, lld.removeFirst().intValue());
        assertEquals(2, lld.removeFirst().intValue());
        assertEquals(1, lld.size());
        assertEquals("3", lld.toString());
        lld.printDeque();
    }

    @Test
    public void testRemoveLast() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.printDeque();
        assertTrue(lld.isEmpty());
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        assertFalse(lld.isEmpty());

        assertEquals(3, lld.size());
        assertEquals("1 2 3", lld.toString());
        lld.printDeque();
        assertEquals(3, lld.removeLast().intValue());
        assertEquals(2, lld.removeLast().intValue());
        assertEquals(1, lld.size());
        assertEquals("1", lld.toString());
        lld.printDeque();
    }

    @Test
    public void testGet() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.printDeque();
        assertTrue(lld.isEmpty());
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        assertFalse(lld.isEmpty());

        assertEquals(1, lld.get(0).intValue());
        assertEquals(2, lld.get(1).intValue());
        assertEquals(3, lld.get(2).intValue());
        assertEquals(null, lld.get(3));
        assertEquals(null, lld.get(4));
        assertEquals(3, lld.size());
        assertEquals("1 2 3", lld.toString());
        lld.printDeque();
    }

    @Test
    public void testGetRecursive() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.printDeque();
        assertTrue(lld.isEmpty());
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        assertFalse(lld.isEmpty());

        assertEquals(1, lld.getRecursive(0).intValue());
        assertEquals(2, lld.getRecursive(1).intValue());
        assertEquals(3, lld.getRecursive(2).intValue());
        assertEquals(null, lld.getRecursive(3));
        assertEquals(null, lld.getRecursive(4));
        assertEquals(3, lld.size());
        assertEquals("1 2 3", lld.toString());
        lld.printDeque();
    }

    @Test
    public void randomizedTest() {
        LinkedList<Integer> correct = new LinkedList<>();
        LinkedListDeque<Integer> target = new LinkedListDeque<>();
        int N = 500000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 1000);
                correct.addLast(randVal);
                target.addLast(randVal);
            } else if (operationNumber == 1) {
                int randVal = StdRandom.uniform(0, 100);
                correct.addFirst(randVal);
                target.addFirst(randVal);
            } else if (operationNumber == 2) {
                assertEquals(correct.size(), target.size());
            } else if (operationNumber == 3) {
                if (!correct.isEmpty()) {
                    assertEquals(correct.removeFirst(), target.removeFirst());
                }
            } else if (operationNumber == 4) {
                if (!correct.isEmpty()) {
                    assertEquals(correct.removeLast(), target.removeLast());
                }
            } else if (operationNumber == 5) {
                if (!correct.isEmpty()) {
                    int index = StdRandom.uniform(0, correct.size());
                    assertEquals(correct.get(index), target.get(index));
                }
            }
        }

    }

    @Test
    public void testIterator() {

    }

}
