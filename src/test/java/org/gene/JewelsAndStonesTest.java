package org.gene;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
@Slf4j
public class JewelsAndStonesTest {

    @Test
     void testNumJewelsInStones() {
        JewelsAndStones solution = new JewelsAndStones();
        int result = solution.numJewelsInStones("aA", "aAAbbbb");
        log.info("Result for testNumJewelsInStones: {}", result);
    }
}
