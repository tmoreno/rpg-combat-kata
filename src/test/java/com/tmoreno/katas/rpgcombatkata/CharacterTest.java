package com.tmoreno.katas.rpgcombatkata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CharacterTest {

    @Test
    void should_create_a_character_in_initial_state() {
        Character character = new Character();
        assertThat(character.getHealth()).isEqualTo(1000);
        assertThat(character.getLevel()).isEqualTo(1);
        assertThat(character.isAlive()).isTrue();
    }

    @Test
    void should_decrease_health_when_a_character_is_damaged_by_other() {
        Character character1 = new Character();
        Character character2 = new Character();
        character1.damageTo(character2, 10);

        assertThat(character2.getHealth()).isEqualTo(990);
        assertThat(character2.isAlive()).isTrue();
    }

    @Test
    void should_die_character_when_damage_exceeds_current_health() {
        Character character1 = new Character();
        Character character2 = new Character();
        character1.damageTo(character2, 1001);

        assertThat(character2.getHealth()).isEqualTo(0);
        assertThat(character2.isAlive()).isFalse();
    }

    @Test
    void should_not_heal_a_dead_character() {
        Character character1 = new Character();
        Character character2 = new Character();
        character1.damageTo(character2, 1001);

        assertThatExceptionOfType(HealDeadCharacterException.class)
            .isThrownBy(() -> character1.heal(character2, 10));
    }
}
