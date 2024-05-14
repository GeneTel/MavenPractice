package org.gene;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (jewels.indexOf(stone) != -1) {
                count++;
            }
        }
        return count;
    }
}