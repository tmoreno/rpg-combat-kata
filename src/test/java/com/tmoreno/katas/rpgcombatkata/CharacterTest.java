package com.tmoreno.katas.rpgcombatkata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterTest {

    @Test
    void should_create_a_character_in_initial_state() {
        Character character = new Character();
        assertThat(character.getHealth()).isEqualTo(100);
        assertThat(character.getLevel()).isEqualTo(1);
        assertThat(character.isAlive()).isTrue();
    }

    @Test
    void should_decrease_health_when_a_character_is_damaged_by_other() {
        Character character1 = new Character();
        Character character2 = new Character();
        character1.damageTo(character2, 10);

        assertThat(character2.getHealth()).isEqualTo(90);
        assertThat(character2.isAlive()).isTrue();
    }

    @Test
    void should_die_character_when_damage_exceeds_current_health() {
        Character character1 = new Character();
        Character character2 = new Character();
        character1.damageTo(character2, 101);

        assertThat(character2.getHealth()).isEqualTo(0);
        assertThat(character2.isAlive()).isFalse();
    }
}
