package com.ricky.goblins;

import java.awt.Color;
import java.util.HashMap;


public class Goblin extends Creature implements Comparable<Goblin> {
    private int rank;
    private static HashMap<Integer, Goblin> goblins = new HashMap<Integer, Goblin>();

    public Goblin(Color color, int rank, World world) {
        super(color, (char) 2, world);
        this.rank = rank;
        Goblin.goblins.put(rank, this);
    }

    public static Goblin getGoblinByRank(int rank) {
        return Goblin.goblins.get(rank);
    }

    public int getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return String.valueOf(this.rank);
    }

    @Override
    public int compareTo(Goblin o) {
        return Integer.valueOf(this.rank).compareTo(Integer.valueOf(o.rank));
    }

    public void swap(Goblin another) {
        int x = this.getX();
        int y = this.getY();
        this.moveTo(another.getX(), another.getY());
        another.moveTo(x, y);
    }
}