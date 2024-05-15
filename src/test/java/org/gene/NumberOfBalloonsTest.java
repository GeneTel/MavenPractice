package org.gene;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfBalloonsTest {
    @Test
    void testMaxNumberOfBalloons() {
        JewelsAndStones solution = new JewelsAndStones();
        assertEquals(1, solution.maxNumberOfBalloons("nlaebolko"));
        assertEquals(2, solution.maxNumberOfBalloons("loonbalxballpoon"));
        assertEquals(0, solution.maxNumberOfBalloons("leetcode"));
    }
}
