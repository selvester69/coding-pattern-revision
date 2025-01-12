package com.practice.datastructure.hashtable;

import java.util.*;

public class HashTable {
    Node[] dataMap;
    int size = 7;

    public HashTable() {
        this.dataMap = new Node[size];
    }

    public Node[] getDataMap() {
        return this.dataMap;
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            if (dataMap[i] != null) {
                Node temp = dataMap[i];
                while (temp != null) {
                    System.out.println("{" + temp.key + "," + temp.value + "}");
                    temp = temp.next;
                }
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int ascii = keyChars[i];
            hash = (hash + ascii * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int hashKey = hash(key);
        Node newNode = new Node(key, value);
        if (this.dataMap[hashKey] == null) {
            this.dataMap[hashKey] = newNode;
        } else {
            Node temp = this.dataMap[hashKey];
            while (temp.next != null) {
                if (temp.key.equals(key)) {
                    temp.value = value;
                    break;
                }
                temp = temp.next;
            }
            temp.next = newNode;

        }
    }

    public int get(String key) {
        int hashKey = hash(key);
        Node temp = this.dataMap[hashKey];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public List<String> allKeys() {
        List<String> keys = new ArrayList<>();
        for (Node node : this.dataMap) {
            while (node != null) {
                keys.add(node.key);
                node = node.next;
            }
        }
        return keys;
    }

}