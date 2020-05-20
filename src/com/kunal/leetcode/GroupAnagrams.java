package com.kunal.leetcode;

//49. Group Anagrams
//Given an array of strings, group anagrams together.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
public class GroupAnagrams {
    /**
     * leetCode 49
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        if (strs.length == 0)
            return result;

        HashMap<String, List<String>> map = new HashMap<>();
        String sortedWord;
        char[] temp;

        for (int i = 0; i < strs.length; i++) {
            temp = strs[i].toCharArray();
            Arrays.sort(temp);
            sortedWord = new String(temp);
            if (map.containsKey(sortedWord)) {
                List<String> anagramGroup = map.get(sortedWord);
                anagramGroup.add(strs[i]);
                map.put(sortedWord, anagramGroup);
            } else {
                List<String> anagramGroup = new ArrayList<>();
                anagramGroup.add(strs[i]);
                map.put(sortedWord, anagramGroup);
            }
        }
        return new ArrayList<>(map.values());
    }
}
