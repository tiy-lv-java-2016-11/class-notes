package com.theironyard.textadventure;

/**
 * Created by jeff on 12/6/16.
 */
public class Character {
    private String name;
    private int health;
    private int damage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void battle(Character enemy){
        System.out.printf("%s appears!\n", enemy.getName());

        while(health > 0 && enemy.getHealth() > 0){
            health -= enemy.getDamage();
            enemy.setHealth(enemy.getHealth() - damage);
            System.out.printf("%s's health: %d\n", name, health);
            System.out.printf("%s's health: %d\n", enemy.getName(), enemy.getHealth());
        }

        String message = "%s has died.\n";

        if(health <=0){
            System.out.printf(message, name);
        }

        if(enemy.getHealth() <= 0){
            System.out.printf(message, enemy.getName());
        }
    }
}
