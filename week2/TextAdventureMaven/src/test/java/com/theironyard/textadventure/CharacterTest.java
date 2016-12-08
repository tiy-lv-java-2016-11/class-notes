package com.theironyard.textadventure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jeff on 12/8/16.
 */
public class CharacterTest {

    Player player;
    Enemy enemy;

    @Before
    public void setup(){
        player = new Player();
        player.setName("Test");
        player.setHealth(100);
        player.setDamage(10);

        enemy = new Enemy();
        enemy.setName("Test Enemy");
        enemy.setHealth(50);
        enemy.setDamage(10);
    }

    @Test
    public void testBattle(){


        player.battle(enemy);

        assertEquals("Enemy health not correct", 0, enemy.getHealth());
        assertEquals("Player health not correct", 50, player.getHealth());
    }

    @Test
    public void foo(){
        enemy.setHealth(100);
    }



}
