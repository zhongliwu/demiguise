package edu.usc.demiguise.datastructure;

import java.util.*;

public class _264_UglyNumberII {

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        heap.offer(1L);
        seen.add(1L);
        int[] factors = {2, 3, 5};
        int uglyNumber = 1;
        for (int i = 0; i < n; i++) {
            uglyNumber = heap.poll().intValue();
            for (int factor : factors) {
                long newUglyNumber = (long) factor * uglyNumber;
                if (seen.contains(newUglyNumber)) {
                    continue;
                }
                heap.offer(newUglyNumber);
                seen.add(newUglyNumber);
            }
        }

        return uglyNumber;
    }


    public static void main(String[] args) {
        _264_UglyNumberII test = new _264_UglyNumberII();
        test.nthUglyNumber(10);
    }
}
