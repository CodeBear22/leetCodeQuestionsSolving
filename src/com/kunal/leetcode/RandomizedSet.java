package com.kunal.leetcode;

/**
 * 380. Insert Delete GetRandom O(1)
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 * <p>
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * <p>
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * <p>
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * <p>
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * <p>
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * <p>
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * <p>
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * <p>
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RandomizedSet {

    private final List<Integer> storage;
    private final HashMap<Integer, Integer> map;
//    private int usedLength;


    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        storage = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {

        if (map.containsKey(val))
            return false;

        storage.add(val);
        map.put(val, storage.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int valIndex = map.get(val);

        int lastIndexVal = storage.get(storage.size() - 1);
        int lastIndex = storage.size() - 1;

        storage.set(valIndex, lastIndexVal);
        map.put(lastIndexVal, valIndex);
        map.remove(val);
        storage.remove(lastIndex);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int index = (int) (Math.random() * ((storage.size() - 1) + 1));
        return storage.get(index);
    }
}
