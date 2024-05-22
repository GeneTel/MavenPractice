package org.gene.unittests;

import java.util.HashMap;
import java.util.Map;

public class IdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
    int count = 0;
    Map<Integer, Integer> numCounts = new HashMap<>();
    for (int num : nums) {
        numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
    }
    for (int numCount : numCounts.values()) {
        count += numCount * (numCount - 1) / 2;
    }
    return count;
}
}
