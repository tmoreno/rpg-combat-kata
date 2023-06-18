package com.tmoreno.katas.rpgcombatkata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterTest {

    @Test
    void should_create_a_character_in_initial_state() {
        Character character = new Character();
        assertThat(character.getHealth()).isEqualsTo(100);
        assertThat(character.getLevel()).isEqualsTo(1);
        assertThat(character.isAlive()).isEqualsTo(true);
    }
}
