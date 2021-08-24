package com.boardgames.snakeLadder;

import com.boardgames.snakeLadder.models.CrookedDice;
import com.boardgames.snakeLadder.models.Dice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class DiceTest {

    @Test
    public void testNormalDice() {
        Dice dice = new Dice();
        int diceRollResult = dice.roll();
        assertTrue("Dice is working as expected and returning values between 1 and 6", diceRollResult <= 6);
    }

    @Test
    public void testCrookedDice() {
        Dice dice = new CrookedDice();
        int diceRollResult = dice.roll();
        assertTrue("Dice is working as expected and returning values between 1 and 6", diceRollResult <= 6);
        assertEquals("Crooked dice is always returning even values", 0, diceRollResult % 2);
    }
}