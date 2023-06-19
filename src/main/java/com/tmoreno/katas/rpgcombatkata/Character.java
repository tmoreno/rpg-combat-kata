package com.tmoreno.katas.rpgcombatkata;

import java.util.UUID;

public final class Character {

    private static final int MAX_HEALTH = 1000;

    private final UUID id;
    private int health;
    private int level;
    private boolean alive;

    public Character() {
        id = UUID.randomUUID();
        health = MAX_HEALTH;
        level = 1;
        alive = true;
    }

    public UUID getId() {
        return id;
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
        if (damagedCharacter.getId().equals(id)) {
            throw new DamageToItselfException();
        }

        if (damagedCharacter.getLevel() - level >= 5) {
            quantity = quantity / 2;
        }
        
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

    public void heal(int quantity) {
        if (!alive) {
            throw new HealDeadCharacterException();
        }

        health = Math.min(health + quantity, MAX_HEALTH);
    }

    public void increaseLevel() {
        level++;
    }
}
