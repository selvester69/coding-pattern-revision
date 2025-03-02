package com.practice.algorithms.crackingCodingInterview;

import java.util.List;
import java.util.Map;

// basic solution is to iterate over the words and figure out the word in each map and replace them 

// optimize by building reverse map between words and dictionary
//but that would only work for single word replacement and also dictioanry map is not too big 
// because of reverse mapping is huge memory consumption is there 

//other optimized solution is to build using trie. and store the dictionary key at the end of each word in trie;

public class P081ParagraphWordReplacement {
    class Trie {
        class Node {
            char data;
            Node[] children;
            boolean isTerminal;
            String key;

            public Node(char c) {
                this.data = c;
                children = new Node[26];
                key = "";
                isTerminal = false;
            }
        }

        Node root;

        Trie() {
            this.root = new Node('\0');
        }

        public void add(String word, String key) {
            Node temp = this.root;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new Node(c);
                }
                temp = temp.children[c - 'a'];
            }
            temp.isTerminal = true;
            temp.key = key;
        }

        public String search(String word) {
            Node temp = this.root;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    return null;
                }
                temp = temp.children[c - 'a'];
            }
            return temp.key;
        }
    }

    public String paragraphWordReplacement(Map<String, List<String>> dictionary, String paragraph) {
        Trie trie = new Trie();
        for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
            List<String> values = entry.getValue();
            for (int i = 0; i < values.size(); i++) {
                trie.add(values.get(i), entry.getKey());
            }
        }
        // search words in paragraph and replace
        String[] words = paragraph.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (trie.search(word) != null && !"".equals(trie.search(word))) {
                sb.append(trie.search(word)).append(" ");
            } else {
                sb.append(word).append(" ");
            }
        }
        return sb.toString();
    }
}
