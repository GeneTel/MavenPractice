package org.gene;

import org.gene.unittests.JewelsAndStones;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class JewelsAndStonesTest {

    @Test
    void testNumJewelsInStones() {
        JewelsAndStones solution = new JewelsAndStones();
        assertEquals(3, solution.numJewelsInStones("aA", "aAAbbbb"));
        assertEquals(0, solution.numJewelsInStones("z", "ZZ"));
    }
}
