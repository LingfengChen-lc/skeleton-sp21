package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.SLList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */

public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> alist = new AListNoResizing<>();
        BuggyAList<Integer> blist = new BuggyAList<>();
        alist.addLast(1);
        blist.addLast(1);
        alist.addLast(2);
        blist.addLast(2);
        alist.addLast(3);
        blist.addLast(3);
        int anum1 = alist.removeLast();
        int bnum1 = blist.removeLast();
        assertEquals(anum1, bnum1);
        int anum2 = alist.removeLast();
        int bnum2 = blist.removeLast();
        assertEquals(anum2, bnum2);
        int anum3 = alist.removeLast();
        int bnum3 = blist.removeLast();
        assertEquals(anum3, bnum3);
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size2 = B.size();
                assertEquals(size, size2);
            }
            // getLast
            else if (operationNumber == 2) {
                if (L.size() < 1 || B.size() < 1) {
                    continue;
                }
                assertEquals(L.getLast(), B.getLast());

            }
            // removeLast
            else {
                if (L.size() < 1 || B.size() < 1) {
                    continue;
                }
                int aLast = L.removeLast();
                int bLast = B.removeLast();
                assertEquals(aLast, bLast);
            }
        }
    }

}
