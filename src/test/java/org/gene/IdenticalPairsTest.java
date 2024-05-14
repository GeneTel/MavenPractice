package org.gene;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class IdenticalPairsTest {
    @Test
void testNumIdenticalPairs() {
    IdenticalPairs solution = new IdenticalPairs();
    int result = solution.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3});
    log.info("Result for testNumIdenticalPairs: {}", result);
}
}
