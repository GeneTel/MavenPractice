package org.gene;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumberOfBaloons {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        for (char ch : text.toCharArray()) {
            counts[ch - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        String balloon = "balloon";
        for (char ch : balloon.toCharArray()) {
            int index = ch - 'a';
            if (ch == 'l' || ch == 'o') {
                min = Math.min(min, counts[index] / 2);
            } else {
                min = Math.min(min, counts[index]);
            }
        }
        return min;
    }
}

