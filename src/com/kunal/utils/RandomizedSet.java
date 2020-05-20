package com.kunal.utils;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;
class RandomizedSet {

    private List<Integer> storage;

    private HashMap<Integer, Integer> map;


    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.storage = new ArrayList<>();
        this.map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

        System.out.println("###INSERT OPERATION");
        if(this.map.containsKey(val))
        {
            this.print();
            System.out.println("###INSERT OPERATION ENDS");
            return false;
        }

        this.storage.add(val);
        this.map.put(val, this.storage.size() - 1);
        this.print();

        System.out.println("###INSERT OPERATION ENDS");
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        System.out.println("###REMOVE OPERATION");

        Integer valIndex = this.map.get(val);
        if(valIndex == null)
        {
            this.print();
            System.out.println("#REMOVE OPERATIONS ENDS");
            return false;
        }

        int lastIndex = this.storage.size() - 1;
        int lastIndexVal = this.storage.get(lastIndex);
        this.map.remove(val);

        if(lastIndex == valIndex)
        {
            this.storage.remove(lastIndex);
            this.print();

            System.out.println("#REMOVE OPERATIONS ENDS");
            return true;
        }

        Collections.swap(this.storage, lastIndex, valIndex);
        this.storage.remove(lastIndex);
        this.map.put(lastIndexVal, valIndex);
        this.print();

        System.out.println("#REMOVE OPERATIONS ENDS");
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {

        int index = (int)(Math.random() * ((this.storage.size() - 1) + 1));
        return this.storage.get(index);
    }

    public void print()
    {
        System.out.println("Printing MAp");
        System.out.println(this.map.toString());
        System.out.println("printing storage");
        System.out.println(this.map.toString());
    }
}

/**
 * Your com.kunal.utils.RandomizedSet object will be instantiated and called as such:
 * com.kunal.utils.RandomizedSet obj = new com.kunal.utils.RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */