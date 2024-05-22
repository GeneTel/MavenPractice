package org.gene;


import org.gene.unittests.JewelsAndStones;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class IdenticalPairsTest {
    @Test
    void testNumIdenticalPairs() {
        JewelsAndStones solution = new JewelsAndStones();
        assertEquals(4, solution.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        assertEquals(6, solution.numIdenticalPairs(new int[]{1, 1, 1, 1}));
        assertEquals(0, solution.numIdenticalPairs(new int[]{1, 2, 3}));
    }
}
