package dataStructure.Trie;

class Node{
    Node[] children = new Node[26];
    boolean isLeaf;

    public Node() {
        this.children = new Node[26];
        this.isLeaf = false;
    }
}

class TrieNode{
    Node root;

    TrieNode(){
        root = null;
    }

    public void insertIntoTrie(String str){
        Node itr = root;
        for(char ch : str.toCharArray()){
           int idx = ch - 'a';

           if(itr.children[idx]== null){
               itr.children[idx] = new Node();
           }

           itr = itr.children[idx];
        }
        itr.isLeaf = true;
    }
}

public class Trie {
    public static void main(String[] args) {

    }
}
