package datastructure.hashtable;

public class HashTableTest {

    public static void main(String[] args) {

        HashTable myHashTable = new HashTable();

        myHashTable.set("paint", 20);
        myHashTable.set("bolts", 40);
        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);

        System.out.println( myHashTable.keys() );
        
    	/*
        	EXPECTED OUTPUT:
        	----------------
        	[paint, bolts, nails, tile, lumber]
    
    	*/        

    }
}
