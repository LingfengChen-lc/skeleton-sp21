package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int[] endList = new int[]{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        for (int i = 0; i < 8; i++) {
            AList<Integer> testList = new AList<>();
            int end = endList[i];
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < end; j++) {
                testList.addLast(0);
            }
            times.addLast(sw.elapsedTime());
            Ns.addLast(end);
            opCounts.addLast(end);
        }
        printTimingTable(Ns, times, opCounts);

    }
}
