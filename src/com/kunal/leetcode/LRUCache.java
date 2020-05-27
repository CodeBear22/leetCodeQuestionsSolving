package com.kunal.leetcode;

import java.util.HashMap;

/**
 * 146. LRU Cache
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * //LRUCache cache = new LRUCache( 2 //capacity);
 * <p>
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LRUCache {

    private final int _capacity;
    private final HashMap<Integer, DoublyLinkedListNode> _lookup;
    private DoublyLinkedListNode _head;
    private int _capacityUsed;
    private DoublyLinkedListNode _tail;

    public LRUCache(int capacity) {
        this._capacity = capacity;
        this._head = null;
        this._lookup = new HashMap<>();
        this._capacityUsed = 0;
        this._tail = null;
    }

    public int get(int key) {

        if (this._lookup.containsKey(key)) {
            DoublyLinkedListNode node = _lookup.get(key);
            _moveNodeInFront(node);
            return node.getVal();
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {


        if (!_lookup.containsKey(key)) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, value, null, _head);
            if (_head == null) {
                _head = newNode;
                _tail = newNode;
                _capacityUsed++;
            } else {

                _head.setPrevious(newNode);
                _head = newNode;
                _capacityUsed++;
                _removeUpdateTail();
            }
            _lookup.put(key, newNode);
        } else {
            _updateNodeValue(key, value);
        }

    }

    private void _updateNodeValue(int key, int value) {
        if (_lookup.containsKey(key)) {
            DoublyLinkedListNode newNode = _lookup.get(key);
            newNode.setVal(value);
            _moveNodeInFront(newNode);
        }
    }

    private void _moveNodeInFront(DoublyLinkedListNode node) {
        if (node != _head) {

            DoublyLinkedListNode previousNode = node.getPrevious();
            DoublyLinkedListNode nextNode = node.getNext();
            previousNode.setNext(nextNode);

            if (nextNode != null)
                nextNode.setPrevious(previousNode);

            if (_tail == node)
                _tail = previousNode;

            node.setPrevious(null);
            node.setNext(_head);

            _head.setPrevious(node);
            _head = node;
        }
    }

    private void _removeUpdateTail() {
        if (_capacityUsed > _capacity) {
            DoublyLinkedListNode newTail = _tail.getPrevious();
            _lookup.remove(_tail.getKey());
            _tail = newTail;
            newTail.setNext(null);
            _capacityUsed--;
        }
    }

    public void printCache() {
        DoublyLinkedListNode temp = _head;
        while (temp != null) {
            System.out.print("(" + temp.getKey() + "," + temp.getVal() + ")" + " --> ");
            temp = temp.getNext();
        }
        System.out.println();
    }
}


class DoublyLinkedListNode {
    private int _val;
    private DoublyLinkedListNode _next;
    private DoublyLinkedListNode _previous;
    private int _key;

    public DoublyLinkedListNode(int key, int value, DoublyLinkedListNode previous, DoublyLinkedListNode next) {
        this.setVal(value);
        this.setPrevious(previous);
        this.setNext(next);
        this.setKey(key);
    }

    public int getVal() {
        return _val;
    }

    public void setVal(int val) {
        this._val = val;
    }

    public DoublyLinkedListNode getNext() {
        return _next;
    }

    public void setNext(DoublyLinkedListNode next) {
        this._next = next;
    }

    public DoublyLinkedListNode getPrevious() {
        return _previous;
    }

    public void setPrevious(DoublyLinkedListNode previous) {
        this._previous = previous;
    }

    public void setPrevNext(DoublyLinkedListNode prev, DoublyLinkedListNode next) {
        this.setPrevious(prev);
        this.setNext(next);
    }

    public int getKey() {
        return _key;
    }

    public void setKey(int key) {
        this._key = key;
    }
}
