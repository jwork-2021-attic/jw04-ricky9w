package com.ricky.screen;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

import com.ricky.goblins.BubbleSorter;
import com.ricky.goblins.Goblin;
import com.ricky.goblins.SelectSorter;
import com.ricky.goblins.World;

import com.ricky.utils.GetColor;

import asciiPanel.AsciiPanel;

public class WorldScreen implements Screen {

    private World world;
    private Goblin[][] goblins;
    String[] sortSteps;

    final int ROW = 16;
    final int COL = 16;

    public WorldScreen() throws IOException{
        world = new World();

        int[][] colors = GetColor.getColor("./resources/c256.png", 16, 16);
        Goblin[][] goblins = new Goblin[ROW][];
        for (int i = 0; i < ROW; i++) {
            goblins[i] = new Goblin[COL];
            for (int j = 0; j < COL; j++) {
                int index = i * COL + j;
                goblins[i][j] = new Goblin(new Color(colors[index][0], colors[index][1], colors[index][2]), i * COL + j, world);
            }
        }
        
        Random random = new Random();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                int x = random.nextInt(ROW);
                int y = random.nextInt(COL);
                Goblin tmp = goblins[x][y];
                goblins[x][y] = goblins[i][j];
                goblins[i][j] = tmp;
            }
        }
        random = null;
        
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                world.put(goblins[i][j], 10 + 2 * i, 10 + 2 * j);
            }
        }

        //BubbleSorter<Goblin> sorter = new BubbleSorter<>();
        SelectSorter<Goblin> sorter = new SelectSorter<>();

        Goblin[] arrayGoblins = new Goblin[ROW * COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                arrayGoblins[i * COL + j] = goblins[i][j];
            }
        }
        sorter.load(arrayGoblins);
        sorter.sort();

        sortSteps = this.parsePlan(sorter.getPlan());

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(Goblin[][] goblins, String step) {
        String[] couple = step.split("<->");
        getGoblinByRanke(Integer.parseInt(couple[0])).swap(getGoblinByRanke(Integer.parseInt(couple[1])));
    }

    private Goblin getGoblinByRanke(int rank) {
        return Goblin.getGoblinByRank(rank);
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        
        for (int x = 0; x < World.WIDTH; x++) {
            for (int y = 0; y < World.HEIGHT; y++) {

                terminal.write(world.get(x, y).getGlyph(), x, y, world.get(x, y).getColor());

            }
        }
    }

    int i = 0;
    
    @Override
    public Screen respondToUserInput(KeyEvent key) {

        if (i < this.sortSteps.length) {
            this.execute(goblins, sortSteps[i]);
            i++;
        }

        return this;
    }

}