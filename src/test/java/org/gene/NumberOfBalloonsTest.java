package org.gene;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class NumberOfBalloonsTest {
    @Test
    void testMaxNumberOfBalloons() {
        NumberOfBaloons solution = new NumberOfBaloons();
        int result = solution.maxNumberOfBalloons("nlaebolko");
        log.info("Result for testMaxNumberOfBalloons: {}", result);
    }
}
