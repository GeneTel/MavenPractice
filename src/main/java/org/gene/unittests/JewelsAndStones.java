package org.gene.unittests;


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


    public int numIdenticalPairs(int[] ints) {
        return 0;
    }

    public int maxNumberOfBalloons(String nlaebolko) {
        return 0;
    }
}