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

    public void setHealth(int health) {
        this.health = health;
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
        if (!healedCharacter.isAlive()) {
            throw new HealDeadCharacterException();
        }

        if (healedCharacter.getHealth() + quantity > 1000) {
            healedCharacter.setHealth(1000);
        }
        else {
            healedCharacter.setHealth(healedCharacter.getHealth() + quantity);
        }
    }
}
