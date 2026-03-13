package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {

    @Test
    public void test() {
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        StringBuffer message = new StringBuffer();

        int count = 5000;

        for (int i = 0; i < count; i++) {
            int uniform = StdRandom.uniform(8);
            if (uniform == 0) {
                student.addFirst(i);
                solution.addFirst(i);
                message.append("addFirst(" + i + ")\n");
            } else if (uniform == 1) {
                student.addLast(i);
                solution.addLast(i);
                message.append("addLast(" + i + ")\n");
            } else if (uniform == 2) {
                if (!solution.isEmpty()) {
                    message.append("removeFirst()\n");
                    assertEquals(message.toString(), solution.removeFirst(), student.removeFirst());
                }
            } else if (uniform == 3) {
                if (!solution.isEmpty()) {
                    message.append("removeLast()\n");
                    assertEquals(message.toString(), solution.removeLast(), student.removeLast());
                }
            } else if (uniform == 4) {
                message.append("size()\n");
                assertEquals(message.toString(), solution.size(), student.size());
            } else if (uniform == 5) {
                message.append("isEmpty()\n");
                assertEquals(message.toString(), solution.isEmpty(), student.isEmpty());
            } else if (uniform == 6) {
                if (!solution.isEmpty()) {

                    int random = StdRandom.uniform(solution.size());
                    message.append("get(" + random + ")\n");
                    assertEquals(message.toString(), solution.get(random), student.get(random));
                }
            }
        }
    }
}
