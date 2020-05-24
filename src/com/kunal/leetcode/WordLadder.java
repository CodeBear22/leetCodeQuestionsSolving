package com.kunal.leetcode;

import com.kunal.utils.Pair;

import javax.swing.event.InternalFrameEvent;
import java.util.*;

/**
 * 127. Word Ladder
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashMap<String, List<String>> patternWordMap = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "-" + word.substring(i + 1, word.length());
                List<String> wordsWithPattern = patternWordMap.getOrDefault(pattern, new ArrayList<>());
                wordsWithPattern.add(word);
                patternWordMap.put(pattern, wordsWithPattern);
            }
        }
        HashMap<String, Integer> wordsLevel = new HashMap<>();

        Queue<String> wordsToBeProcessed = new LinkedList<>();

        wordsToBeProcessed.add(beginWord);
        wordsLevel.put(beginWord, 1);

        while (!wordsToBeProcessed.isEmpty()) {
            String word = wordsToBeProcessed.poll();
            int wordLevel = wordsLevel.get(word);

            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "-" + word.substring(i + 1, word.length());
                List<String> wordsWithPattern = patternWordMap.getOrDefault(pattern, new ArrayList<>());

                for (String patternWord : wordsWithPattern) {
                    if (patternWord.equals(endWord))
                        return wordLevel + 1;

                    if (!wordsLevel.containsKey(patternWord)) {
                        wordsToBeProcessed.add(patternWord);
                        wordsLevel.put(patternWord, wordLevel + 1);
                    }
                }
            }

        }


        return 0;
    }
}
