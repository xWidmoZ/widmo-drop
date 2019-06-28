package com.gmail.widmo.bok.drop.data;

import org.bukkit.inventory.ItemStack;

public class Drop {

    private String ID;
    private String name;
    private ItemStack drop;
    private boolean fortune;
    private int y;
    private int exp;
    private double chance;

    public Drop(String ID, String name, ItemStack drop, boolean fortune, int y, int exp, double chance)
    {
        this.ID = ID;
        this.name = name;
        this.drop = drop;
        this.fortune = fortune;
        this.y = y;
        this.exp = exp;
        this.chance = chance;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public ItemStack getDrop() {
        return drop;
    }

    public boolean isFortune() {
        return fortune;
    }

    public int getY() {
        return y;
    }

    public int getExp() {
        return exp;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDrop(ItemStack drop) {
        this.drop = drop;
    }

    public void setFortune(boolean fortune) {
        this.fortune = fortune;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }
}
