package com.tmoreno.katas.rpgcombatkata;

public final class Character {

    private int health;
    private final int level;
    private boolean alive;

    public Character() {
        health = 1000;
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

    public void damageTo(Character damagedCharacter, int quantity) {
        damagedCharacter.decreaseHealth(quantity);
    }

    private void decreaseHealth(int quantity) {
        if (quantity > health) {
            health = 0;
            alive = false;
        }
        else {
            health = health - quantity;
        }
    }

    public void heal(Character healedCharacter, int quantity) {
        healedCharacter.increaseHealth(quantity);
    }

    private void increaseHealth(int quantity) {
        if (!alive) {
            throw new HealDeadCharacterException();
        }

        health = Math.min(health + quantity, 1000);
    }
}
