package com.tmoreno.katas.rpgcombatkata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
    void should_heal_a_character() {
        Character character1 = new Character();
        Character character2 = new Character();
        character1.damageTo(character2, 10);

        character2.heal(10);

        assertThat(character2.getHealth()).isEqualTo(1000);
    }

    @Test
    void should_not_heal_a_dead_character() {
        Character character1 = new Character();
        Character character2 = new Character();
        character1.damageTo(character2, 1001);

        assertThatExceptionOfType(HealDeadCharacterException.class)
            .isThrownBy(() -> character2.heal(10));
    }

    @Test
    void should_not_has_health_above_1000_after_healing() {
        Character character1 = new Character();
        Character character2 = new Character();
        character1.damageTo(character2, 10);

        character2.heal(30);

        assertThat(character2.getHealth()).isEqualTo(1000);
    }

    @Test
    void should_not_damage_to_itself() {
        Character character1 = new Character();

        assertThatExceptionOfType(DamageToItselfException.class)
                .isThrownBy(() -> character1.damageTo(character1, 10));
    }

    @Test
    void should_reduce_damage_to_50_percent_when_other_character_is_5_or_more_levels_above() {
        Character character1 = new Character();

        Character character2 = new Character();
        character2.increaseLevel();
        character2.increaseLevel();
        character2.increaseLevel();
        character2.increaseLevel();
        character2.increaseLevel();

        character1.damageTo(character2, 50);

        assertThat(character2.getHealth()).isEqualTo(975);
    }
}
