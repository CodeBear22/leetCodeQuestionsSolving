package com.kunal.leetcode;


import java.util.HashMap;

/**
 * 208. Implement Trie (Prefix Tree)
 * <p>
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Example:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 * <p>
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */

public class ImplementTriePrefixTree {
    private final Trie trie;

    public ImplementTriePrefixTree() {
        this.trie = this.Trie();
    }

    public Trie Trie() {

        return new Trie();

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        trie.insert(word);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return trie.search(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {

        return trie.startsWith(prefix);

    }
}

class Trie {


    private final TrieTreeNode _rootOfPossibilities;

    /**
     * Initialize your data structure here.
     */
    public Trie() {

        this._rootOfPossibilities = new TrieTreeNode('*');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        _insertHelper(_rootOfPossibilities, word, 0);

    }

    private boolean _insertHelper(TrieTreeNode possibilitiesRoot, String word, int currentIndex) {
        if (currentIndex == word.length())
            return true;

        char currentChar = word.charAt(currentIndex);
        TrieTreeNode possibility = possibilitiesRoot.insertPossibility(currentChar);

        if (currentIndex == word.length() - 1)
            possibility.setWordEndsHere();

        return _insertHelper(possibility, word, currentIndex + 1);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return _searchHelper(_rootOfPossibilities, word, 0);
    }

    private boolean _searchHelper(TrieTreeNode possibilitiesRoot, String word, int currentIndex) {

        if (currentIndex == word.length())
            return false;

        if (possibilitiesRoot.checkPossibility(word.charAt(currentIndex))) {
            TrieTreeNode nextPossibility = possibilitiesRoot.getPossibility(word.charAt(currentIndex));

            System.out.println(nextPossibility.getNodeName() + "-" + currentIndex + "-" + word.length() + "-" + nextPossibility.isWordEnds());

            if (currentIndex == word.length() - 1 && nextPossibility.isWordEnds()) {
                return true;
            }

            return _searchHelper(nextPossibility, word, currentIndex + 1);
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return _startsWithHelper(_rootOfPossibilities, prefix, 0);
    }

    private boolean _startsWithHelper(TrieTreeNode possibilitiesRoot, String word, int currentIndex) {

        if (currentIndex == word.length())
            return true;

        if (possibilitiesRoot.checkPossibility(word.charAt(currentIndex))) {
            TrieTreeNode nextPossibility = possibilitiesRoot.getPossibility(word.charAt(currentIndex));
            return _startsWithHelper(nextPossibility, word, currentIndex + 1);
        }
        return false;
    }
}

class TrieTreeNode {

    private final HashMap<Character, TrieTreeNode> _validChars;
    private final char _nodeSymbol;
    private boolean _wordEnds;

    public TrieTreeNode(char nodeSymbol) {
        this._validChars = new HashMap<>();
        this._nodeSymbol = nodeSymbol;
        this._wordEnds = false;
    }

    public TrieTreeNode insertPossibility(char possibility) {

        if (this._validChars.containsKey(possibility))
            return this._validChars.get(possibility);

        TrieTreeNode newPossibility = new TrieTreeNode(possibility);
        this._validChars.put(possibility, newPossibility);

        return newPossibility;
    }

    public boolean checkPossibility(char possibility) {
        return this._validChars.containsKey(possibility);
    }

    public TrieTreeNode getPossibility(char possibility) {
        return this._validChars.get(possibility);
    }

    public boolean isWordEnds() {
        return this._wordEnds;
    }

    public boolean setWordEndsHere() {
        this._wordEnds = true;
        return true;
    }

    public boolean unsetWordEndsHere() {
        this._wordEnds = false;
        return true;
    }

    public char getNodeName() {
        return _nodeSymbol;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
