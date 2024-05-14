package org.gene;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
@Slf4j
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
