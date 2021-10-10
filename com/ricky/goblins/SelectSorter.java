package com.ricky.goblins;

public class SelectSorter<T extends Comparable<T>> implements Sorter<T> {
    private T[] a;
    
    @Override
    public void load(T[] a) {
        this.a = a;
    }
    
    private void swap(int i, int j) {
        T tmp;
        tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        for (int i = 0; i < a.length; i++) {
            int mIdx = i;
            for (int j = i; j < a.length; j++) 
                if (a[j].compareTo(a[mIdx]) > 0) 
                    mIdx = j;
            if (mIdx != i)
                swap(i, mIdx);
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}
