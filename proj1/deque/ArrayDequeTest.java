package deque;


import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.*;


/**
 * Performs some basic linked list tests.
 */
public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {


        ArrayDeque<String> ad1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", ad1.isEmpty());
        ad1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, ad1.size());
        assertFalse("ad1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("middle");
        assertEquals(2, ad1.size());

        ad1.addLast("back");
        assertEquals(3, ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {


        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        ad1.addFirst(10);
        // should not be empty
        assertFalse("ad1 should contain 1 item", ad1.isEmpty());

        ad1.removeFirst();
        // should be empty
        assertTrue("ad1 should be empty after removal", ad1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {


        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(3);

        ad1.removeLast();
        ad1.removeFirst();
        ad1.removeLast();
        ad1.removeFirst();

        int size = ad1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create ArrayDeques with different parameterized types*/
    public void multipleParamTest() {


        ArrayDeque<String> ad1 = new ArrayDeque<String>();
        ArrayDeque<Double> ad2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> ad3 = new ArrayDeque<Boolean>();

        ad1.addFirst("string");
        ad2.addFirst(3.14159);
        ad3.addFirst(true);

        String s = ad1.removeFirst();
        double d = ad2.removeFirst();
        boolean b = ad3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {


        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, ad1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, ad1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {


        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            ad1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) ad1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) ad1.removeLast(), 0.0);
        }


    }

    @Test
    public void testAddFirst() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        assertTrue(ad.isEmpty());
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        assertFalse(ad.isEmpty());

        assertEquals(3, ad.size());
        assertEquals("3 2 1", ad.toString());
        ad.printDeque();
    }

    @Test
    public void testAddLast() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        assertTrue(ad.isEmpty());
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        assertFalse(ad.isEmpty());

        assertEquals(3, ad.size());
        assertEquals("1 2 3", ad.toString());
        ad.printDeque();
    }

    @Test
    public void testRemoveFirst() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        assertTrue(ad.isEmpty());
        ad.printDeque();
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        assertFalse(ad.isEmpty());

        assertEquals(3, ad.size());
        assertEquals("1 2 3", ad.toString());
        ad.printDeque();
        assertEquals(1, ad.removeFirst().intValue());
        assertEquals(2, ad.removeFirst().intValue());
        assertEquals(1, ad.size());
        assertEquals("3", ad.toString());
        ad.printDeque();
    }

    @Test
    public void testRemoveLast() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.printDeque();
        assertTrue(ad.isEmpty());
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        assertFalse(ad.isEmpty());

        assertEquals(3, ad.size());
        assertEquals("1 2 3", ad.toString());
        ad.printDeque();
        assertEquals(3, ad.removeLast().intValue());
        assertEquals(2, ad.removeLast().intValue());
        assertEquals(1, ad.size());
        assertEquals("1", ad.toString());
        ad.printDeque();
    }

    @Test
    public void testGet() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.printDeque();
        assertTrue(ad.isEmpty());
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        assertFalse(ad.isEmpty());

        assertEquals(1, ad.get(0).intValue());
        assertEquals(2, ad.get(1).intValue());
        assertEquals(3, ad.get(2).intValue());
        assertEquals(null, ad.get(3));
        assertEquals(null, ad.get(4));
        assertEquals(3, ad.size());
        assertEquals("1 2 3", ad.toString());
        ad.printDeque();
    }

    @Test
    public void randomizedTest() {
        java.util.ArrayDeque<Integer> correct = new java.util.ArrayDeque<>();
        ArrayDeque<Integer> target = new ArrayDeque<>();
        int N = 500000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 5);
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
            }
        }
    }

    @Test
    public void testArrayDeque() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 32; i++) {
            ad1.addLast(i);
        }
        for (int i = 0; i < 32; i++) {
            ad1.removeFirst();
        }
    }

}
