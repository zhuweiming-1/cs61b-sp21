package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.List;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        List<Integer> labs = List.of(1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000);
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int M = 10000;
        for (Integer lab : labs) {
            SLList<Integer> tmp = new SLList<>();
            for (Integer i = 0; i < lab; i++) {
                tmp.addLast(i);
            }
            Ns.addLast(lab);
            opCounts.addLast(M);
            Stopwatch stopwatch = new Stopwatch();
            for (Integer i = 0; i < M; i++) {
                tmp.getLast();
            }
            times.addLast(stopwatch.elapsedTime());
        }
        printTimingTable(Ns, times, opCounts);
    }

}
