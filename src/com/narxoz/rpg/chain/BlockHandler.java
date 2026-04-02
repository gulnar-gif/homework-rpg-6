package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public class BlockHandler extends DefenseHandler {
    private final double blockPercent;

    public BlockHandler(double blockPercent) {
        this.blockPercent = blockPercent;
    }

    @Override
    public void handle(int incomingDamage, ArenaFighter target) {
        int blocked = (int)(incomingDamage * blockPercent);

        int remainingDamage = incomingDamage - blocked;

        if (remainingDamage < 0) {
            remainingDamage = 0;
        }

        System.out.println("Block reduced: " + blocked + " damage");
        passToNext(remainingDamage, target);
    }
}
