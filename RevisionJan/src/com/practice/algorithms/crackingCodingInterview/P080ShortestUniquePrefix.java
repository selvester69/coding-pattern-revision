package com.practice.algorithms.crackingCodingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P080ShortestUniquePrefix {

    class Trie {
        class Node {
            Node[] children;
            int freq;
            char data;
            boolean isTerminal;

            public Node(char c) {
                this.data = c;
                this.freq = 0;
                this.isTerminal = false;
                this.children = new Node[26];
            }
        }

        Node root;

        public Trie() {
            this.root = new Node('\0');
        }

        public void insert(String word) {
            Node temp = this.root;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new Node(c);
                }
                temp.freq++;
                temp = temp.children[c - 'a'];
            }
            temp.isTerminal = true;
        }

        public boolean search(String word) {
            Node temp = this.root;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    return false;
                }
                temp = temp.children[c - 'a'];
            }
            return temp.isTerminal;
        }

        public String getPrefix(String word) {
            StringBuilder sb = new StringBuilder();
            Node temp = this.root;
            for (char c : word.toCharArray()) {
                sb.append(c);
                if (temp.children[c - 'a'].freq == 1) {
                    return sb.toString();
                } else {
                    temp = temp.children[c - 'a'];
                }
            }
            return sb.toString();
        }
    }

    public List<String> findPrefix(List<String> wordsList) {
        Trie trie = new Trie();
        for (int i = 0; i < wordsList.size(); i++) {
            trie.insert(wordsList.get(i));
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < wordsList.size(); i++) {
            res.add(trie.getPrefix(wordsList.get(i)));
        }
        return res;
    }
    // another approach is to not use the count variable and while adding only is
    // termninal is set to true for is each node
    // but in case if we are coming for the second time set isTerminal to false.
    // and return the first terminal true and we will get prefix
    

    public static void main(String[] args) {
        P080ShortestUniquePrefix obj = new P080ShortestUniquePrefix();
        List<String> input = Arrays.asList(new String[] { "geeksgeeks", "geeksquiz", "geeksforgeeks" });
        List<String> res = obj.findPrefix(input);
        System.out.println(res);
    }
}
