package com.practice.algorithms.crackingCodingInterview;


public class P078Trie {
    
    class TrieNode {
        char data;
        boolean isTerminal;
        TrieNode[] child;

        public TrieNode() {
            this.data = '\0';
            this.isTerminal = false;
            this.child = new TrieNode[26];
            
        }
    }

    TrieNode root;

    public P078Trie() {
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        int n = word.length();
        for(int i=0;i<n;i++){
            if(node.child[word.charAt(i)-'a']==null){
                node.child[word.charAt(i)-'a'] = new TrieNode();
            }
            node = node.child[word.charAt(i)-'a'];
        }
        node.isTerminal = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            if(node.child[word.charAt(i)-'a']==null){
                return false;
            }
            node = node.child[word.charAt(i)-'a'];
        }
        return node.isTerminal;
    }
    
    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(int i=0;i<prefix.length();i++){
            if(node.child[prefix.charAt(i)-'a']==null){
                return false;
            }
            node = node.child[prefix.charAt(i)-'a'];
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
