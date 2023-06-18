package com.tmoreno.katas.rpgcombatkata;

public final class Character {

    private final int health;
    private final int level;
    private final boolean alive;

    public Character() {
        health = 100;
        level = 1;
        alive = true;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return alive;
    }
}
